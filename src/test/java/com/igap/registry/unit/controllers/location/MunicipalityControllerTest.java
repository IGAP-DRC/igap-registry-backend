package com.igap.registry.unit.controllers.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igap.registry.controllers.location.MunicipalityController;
import com.igap.registry.entities.core.location.Municipality;
import com.igap.registry.services.location.MunicipalityService;
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

@WebMvcTest(MunicipalityController.class)
class MunicipalityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MunicipalityService municipalityService;

    @Autowired
    private ObjectMapper objectMapper;

    private Municipality municipality;

    @BeforeEach
    void setUp() {
        municipality = new Municipality();
        municipality.setId(UUID.randomUUID());
        municipality.setName("Kalamu");
    }

    @Test
    void createMunicipality_shouldReturnCreatedMunicipality() throws Exception {
        when(municipalityService.saveMunicipality(Mockito.any(Municipality.class))).thenReturn(municipality);

        mockMvc.perform(post("/api/municipalities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(municipality)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kalamu"));

        verify(municipalityService, times(1)).saveMunicipality(Mockito.any(Municipality.class));
    }

    @Test
    void getMunicipalityById_shouldReturnMunicipalityIfFound() throws Exception {
        when(municipalityService.getMunicipalityById(municipality.getId())).thenReturn(Optional.of(municipality));

        mockMvc.perform(get("/api/municipalities/{id}", municipality.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kalamu"));

        verify(municipalityService, times(1)).getMunicipalityById(municipality.getId());
    }

    @Test
    void getMunicipalityById_shouldReturnNotFoundIfMunicipalityDoesNotExist() throws Exception {
        when(municipalityService.getMunicipalityById(municipality.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/municipalities/{id}", municipality.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(municipalityService, times(1)).getMunicipalityById(municipality.getId());
    }

    @Test
    void getAllMunicipalities_shouldReturnAllMunicipalities() throws Exception {
        Municipality municipality2 = new Municipality();
        municipality2.setId(UUID.randomUUID());
        municipality2.setName("Ngaliema");

        when(municipalityService.getAllMunicipalities()).thenReturn(Arrays.asList(municipality, municipality2));

        mockMvc.perform(get("/api/municipalities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Kalamu"))
                .andExpect(jsonPath("$[1].name").value("Ngaliema"));

        verify(municipalityService, times(1)).getAllMunicipalities();
    }

    @Test
    void deleteMunicipality_shouldDeleteMunicipality() throws Exception {
        doNothing().when(municipalityService).deleteMunicipality(municipality.getId());

        mockMvc.perform(delete("/api/municipalities/{id}", municipality.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(municipalityService, times(1)).deleteMunicipality(municipality.getId());
    }
}
