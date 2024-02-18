package com.quenzvezda.mobilApp.controller;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.service.MobilCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobil")
@CrossOrigin(origins = "http://localhost:8082") // CORS Url Front-end
public class MobilCrudController {
    @Autowired
    private MobilCrudService mobilCrudService;

    @PostMapping("/new")
    public ResponseEntity<MobilResponseDto> createMobil(@RequestBody MobilCreationDto mobilCreationDto) {
        MobilResponseDto mobilResponseDto = mobilCrudService.createMobil(mobilCreationDto);
        return new ResponseEntity<>(mobilResponseDto, HttpStatus.CREATED);
    }
}
