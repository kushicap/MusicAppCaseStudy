package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.cg.model.Songs;



public interface SongRepository extends MongoRepository<Songs, Integer> {

}
