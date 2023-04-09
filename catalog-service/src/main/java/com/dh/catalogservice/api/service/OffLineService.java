package com.dh.catalogservice.api.service;


import com.dh.catalogservice.domain.model.OffLine;
import com.dh.catalogservice.repository.OffLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OffLineService {

    @Autowired
    private OffLineRepository offLineRepository;


    public List<OffLine> Offline(String genre) {
        return offLineRepository.findAllByGenre(genre);
    }

    public String create(OffLine offLine) {
        offLineRepository.save(offLine);
        return offLine.getId();
    }

}
