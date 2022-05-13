package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Album;


public interface AlbumRepository extends MongoRepository<Album, String>{

	

}

