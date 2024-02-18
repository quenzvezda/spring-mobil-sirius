package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;

public interface MobilCrudService {
    MobilResponseDto createMobil(MobilCreationDto mobilCreationDto);
}
