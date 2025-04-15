package sn.uasz.ParametresAPI.services;


import sn.uasz.ParametresAPI.dto.CycleDto;

import java.util.List;

public interface CycleService {
    CycleDto createCycle(CycleDto dto);
    CycleDto updateCycle(Long id, CycleDto dto);
    void deleteCycle(Long id);
    CycleDto getCycle(Long id);
    List<CycleDto> getAllCycles();
}

