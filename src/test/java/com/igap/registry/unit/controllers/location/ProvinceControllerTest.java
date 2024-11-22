package com.igap.registry.unit.controllers.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igap.registry.controllers.location.ProvinceController;
import com.igap.registry.entities.core.location.Province;
import com.igap.registry.services.location.ProvinceService;
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

@WebMvcTest(ProvinceController.class)
class ProvinceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProvinceService provinceService;

    @Autowired
    private ObjectMapper objectMapper;

    private Province province;

    @BeforeEach
    void setUp() {
        province = new Province();
        province.setId(UUID.randomUUID());
        province.setName("Kinshasa");
    }

    @Test
    void createProvince_shouldReturnCreatedProvince() throws Exception {
        when(provinceService.saveProvince(Mockito.any(Province.class))).thenReturn(province);

        mockMvc.perform(post("/api/provinces")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(province)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kinshasa"));

        verify(provinceService, times(1)).saveProvince(Mockito.any(Province.class));
    }

    @Test
    void getProvinceById_shouldReturnProvinceIfFound() throws Exception {
        when(provinceService.getProvinceById(province.getId())).thenReturn(Optional.of(province));

        mockMvc.perform(get("/api/provinces/{id}", province.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kinshasa"));

        verify(provinceService, times(1)).getProvinceById(province.getId());
    }

    @Test
    void getProvinceById_shouldReturnNotFoundIfProvinceDoesNotExist() throws Exception {
        when(provinceService.getProvinceById(province.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/provinces/{id}", province.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(provinceService, times(1)).getProvinceById(province.getId());
    }

    @Test
    void getAllProvinces_shouldReturnAllProvinces() throws Exception {
        Province province2 = new Province();
        province2.setId(UUID.randomUUID());
        province2.setName("Kongo-Central");

        when(provinceService.getAllProvinces()).thenReturn(Arrays.asList(province, province2));

        mockMvc.perform(get("/api/provinces")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Kinshasa"))
                .andExpect(jsonPath("$[1].name").value("Kongo-Central"));

        verify(provinceService, times(1)).getAllProvinces();
    }

    @Test
    void deleteProvince_shouldDeleteProvince() throws Exception {
        doNothing().when(provinceService).deleteProvince(province.getId());

        mockMvc.perform(delete("/api/provinces/{id}", province.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(provinceService, times(1)).deleteProvince(province.getId());
    }
}
