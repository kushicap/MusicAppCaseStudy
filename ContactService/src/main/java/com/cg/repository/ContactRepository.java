package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.ContactDetails;

public interface ContactRepository extends MongoRepository<ContactDetails, String> {

}
