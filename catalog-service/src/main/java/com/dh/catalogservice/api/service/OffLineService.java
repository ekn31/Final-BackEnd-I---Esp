package com.dh.catalogservice.api.service;


import com.dh.catalogservice.domain.model.OffLine;
import com.dh.catalogservice.repository.OffLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OffLineService {

    private final OffLineRepository offLineRepository;


    public OffLineService(OffLineRepository offLineRepository) {
        this.offLineRepository = offLineRepository;
    }

    public List<OffLine> getAll() {
        return offLineRepository.findAll();
    }

    public List<OffLine> getSeriesBygGenre(String genre) {
        return offLineRepository.findAllByGenre(genre);
    }

    public String create(OffLine offLine) {
        offLineRepository.save(offLine);
        return offLine.getId();
    }
}
