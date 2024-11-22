package com.igap.registry.unit.controllers.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igap.registry.controllers.location.CountryController;
import com.igap.registry.entities.core.location.Country;
import com.igap.registry.services.location.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Autowired
    private ObjectMapper objectMapper;

    private Country country;

    @BeforeEach
    void setUp() {
        country = new Country();
        country.setId(UUID.randomUUID());
        country.setName("RD Congo");
    }

    @Test
    void createCountry_shouldReturnCreatedCountry() throws Exception {
        when(countryService.saveCountry(Mockito.any(Country.class))).thenReturn(country);

        mockMvc.perform(post("/api/countries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(country)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("RD Congo"));

        verify(countryService, times(1)).saveCountry(Mockito.any(Country.class));
    }

    @Test
    void getCountryById_shouldReturnCountryIfFound() throws Exception {
        when(countryService.getCountryById(country.getId())).thenReturn(Optional.of(country));

        mockMvc.perform(get("/api/countries/{id}", country.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("RD Congo"));

        verify(countryService, times(1)).getCountryById(country.getId());
    }

    @Test
    void getCountryById_shouldReturnNotFoundIfCountryDoesNotExist() throws Exception {
        when(countryService.getCountryById(country.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/countries/{id}", country.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(countryService, times(1)).getCountryById(country.getId());
    }

    @Test
    void getAllCountries_shouldReturnAllCountries() throws Exception {
        Country country2 = new Country();
        country2.setId(UUID.randomUUID());
        country2.setName("Congo");

        when(countryService.getAllCountries()).thenReturn(Arrays.asList(country, country2));

        mockMvc.perform(get("/api/countries")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("RD Congo"))
                .andExpect(jsonPath("$[1].name").value("Congo"));

        verify(countryService, times(1)).getAllCountries();
    }

    @Test
    void deleteCountry_shouldDeleteCountry() throws Exception {
        doNothing().when(countryService).deleteCountry(country.getId());

        mockMvc.perform(delete("/api/countries/{id}", country.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(countryService, times(1)).deleteCountry(country.getId());
    }
}
