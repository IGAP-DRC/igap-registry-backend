package com.igap.registry.controllers.location;

import com.igap.registry.entities.core.location.Province;
import com.igap.registry.services.location.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        return ResponseEntity.ok(provinceService.saveProvince(province));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable UUID id) {
        return provinceService.getProvinceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        return ResponseEntity.ok(provinceService.getAllProvinces());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable UUID id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}