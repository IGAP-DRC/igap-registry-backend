package com.igap.registry.unit.controllers.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igap.registry.controllers.location.NeighborhoodController;
import com.igap.registry.entities.core.location.Neighborhood;
import com.igap.registry.services.location.NeighborhoodService;
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

@WebMvcTest(NeighborhoodController.class)
class NeighborhoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NeighborhoodService neighborhoodService;

    @Autowired
    private ObjectMapper objectMapper;

    private Neighborhood neighborhood;

    @BeforeEach
    void setUp() {
        neighborhood = new Neighborhood();
        neighborhood.setId(UUID.randomUUID());
        neighborhood.setName("Kauka");
    }

    @Test
    void createNeighborhood_shouldReturnCreatedNeighborhood() throws Exception {
        when(neighborhoodService.saveNeighborhood(Mockito.any(Neighborhood.class))).thenReturn(neighborhood);

        mockMvc.perform(post("/api/neighborhoods")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(neighborhood)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kauka"));

        verify(neighborhoodService, times(1)).saveNeighborhood(Mockito.any(Neighborhood.class));
    }

    @Test
    void getNeighborhoodById_shouldReturnNeighborhoodIfFound() throws Exception {
        when(neighborhoodService.getNeighborhoodById(neighborhood.getId())).thenReturn(Optional.of(neighborhood));

        mockMvc.perform(get("/api/neighborhoods/{id}", neighborhood.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kauka"));

        verify(neighborhoodService, times(1)).getNeighborhoodById(neighborhood.getId());
    }

    @Test
    void getNeighborhoodById_shouldReturnNotFoundIfNeighborhoodDoesNotExist() throws Exception {
        when(neighborhoodService.getNeighborhoodById(neighborhood.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/neighborhoods/{id}", neighborhood.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(neighborhoodService, times(1)).getNeighborhoodById(neighborhood.getId());
    }

    @Test
    void getAllNeighborhoods_shouldReturnAllNeighborhoods() throws Exception {
        Neighborhood neighborhood2 = new Neighborhood();
        neighborhood2.setId(UUID.randomUUID());
        neighborhood2.setName("Binza");

        when(neighborhoodService.getAllNeighborhoods()).thenReturn(Arrays.asList(neighborhood, neighborhood2));

        mockMvc.perform(get("/api/neighborhoods")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Kauka"))
                .andExpect(jsonPath("$[1].name").value("Binza"));

        verify(neighborhoodService, times(1)).getAllNeighborhoods();
    }

    @Test
    void deleteNeighborhood_shouldDeleteNeighborhood() throws Exception {
        doNothing().when(neighborhoodService).deleteNeighborhood(neighborhood.getId());

        mockMvc.perform(delete("/api/neighborhoods/{id}", neighborhood.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(neighborhoodService, times(1)).deleteNeighborhood(neighborhood.getId());
    }
}
