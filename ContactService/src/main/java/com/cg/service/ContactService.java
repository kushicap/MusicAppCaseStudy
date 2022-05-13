package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.ContactDetails;
import com.cg.repository.ContactRepository;
@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactrepository;
	

	public ContactDetails addContactDetails (ContactDetails contact) {
		return contactrepository.save(contact);
	}

	public List<ContactDetails> getContactDetails() {
		List<ContactDetails> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<ContactDetails> getContactbyId(String id) {
		return contactrepository.findById(id);
	}

	public void deleteContactDetails(ContactDetails contact) {
		contactrepository.delete(contact);
	}
}
