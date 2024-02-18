package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilDetailDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;

import java.util.List;

public interface MobilCrudService {
    MobilResponseDto createMobil(MobilCreationDto mobilCreationDto);

    List<MobilDetailDto> getAllMobilDetails();

    void deleteMobil(Long mobilId);
}
