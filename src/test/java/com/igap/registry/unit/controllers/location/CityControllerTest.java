package com.igap.registry.unit.controllers.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igap.registry.controllers.location.CityController;
import com.igap.registry.entities.core.location.City;
import com.igap.registry.services.core.location.CityService;
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

/**
 * @author Joe Monkila
 */

@WebMvcTest(CityController.class)
class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    @Autowired
    private ObjectMapper objectMapper;

    private City city;

    @BeforeEach
    void setUp() {
        city = new City();
        city.setId(UUID.randomUUID());
        city.setName("Kinshasa");
    }

    @Test
    void createCity_shouldReturnCreatedCity() throws Exception {
        when(cityService.saveCity(Mockito.any(City.class))).thenReturn(city);

        mockMvc.perform(post("/api/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(city)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kinshasa"));

        verify(cityService, times(1)).saveCity(Mockito.any(City.class));
    }

    @Test
    void getCityById_shouldReturnCityIfFound() throws Exception {
        when(cityService.getCityById(city.getId())).thenReturn(Optional.of(city));

        mockMvc.perform(get("/api/cities/{id}", city.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kinshasa"));

        verify(cityService, times(1)).getCityById(city.getId());
    }

    @Test
    void getCityById_shouldReturnNotFoundIfCityDoesNotExist() throws Exception {
        when(cityService.getCityById(city.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/cities/{id}", city.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(cityService, times(1)).getCityById(city.getId());
    }

    @Test
    void getAllCities_shouldReturnAllCities() throws Exception {
        City city2 = new City();
        city2.setId(UUID.randomUUID());
        city2.setName("Lubumbashi");

        when(cityService.getAllCities()).thenReturn(Arrays.asList(city, city2));

        mockMvc.perform(get("/api/cities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Kinshasa"))
                .andExpect(jsonPath("$[1].name").value("Lubumbashi"));

        verify(cityService, times(1)).getAllCities();
    }

    @Test
    void deleteCity_shouldDeleteCity() throws Exception {
        doNothing().when(cityService).deleteCity(city.getId());

        mockMvc.perform(delete("/api/cities/{id}", city.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(cityService, times(1)).deleteCity(city.getId());
    }
}
