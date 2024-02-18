package com.quenzvezda.mobilApp.controller;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilDetailDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.service.MobilCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobil")
public class MobilCrudController {
    @Autowired
    private MobilCrudService mobilCrudService;

    @PostMapping("/new")
    public ResponseEntity<MobilResponseDto> createMobil(@RequestBody MobilCreationDto mobilCreationDto) {
        MobilResponseDto mobilResponseDto = mobilCrudService.createMobil(mobilCreationDto);
        return new ResponseEntity<>(mobilResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MobilDetailDto> getAllMobilDetails() {
        return mobilCrudService.getAllMobilDetails();
    }

    @DeleteMapping("/{mobilId}")
    public ResponseEntity<?> deleteMobil(@PathVariable Long mobilId) {
        mobilCrudService.deleteMobil(mobilId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{mobilId}")
    public ResponseEntity<MobilDetailDto> getMobilById(@PathVariable Long mobilId) {
        MobilDetailDto mobilDetailDto = mobilCrudService.findMobilById(mobilId);
        return ResponseEntity.ok(mobilDetailDto);
    }
}
