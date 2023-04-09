package com.dh.catalogservice.repository;

import com.dh.catalogservice.domain.model.OffLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OffLineRepository extends MongoRepository<OffLine, Long> {
    List<OffLine> findAllByGenre(String genre);

}
