package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.ContactDetails;
import com.cg.repository.ContactRepository;

@RestController
@RequestMapping("/api/v1")
public class ContactController {
	@Autowired
	private ContactRepository contactrepository;
	
	@PostMapping("/addContact")
	public String saveBook(@RequestBody ContactDetails contact) {
    contactrepository.save(contact);
	return "Added contact with id :  " + contact.getId();
}
	
	@GetMapping("/findAllContacts")
	public List<ContactDetails> getContacts(){
		return contactrepository.findAll();
		
	}
	@GetMapping("/findAllContacts/{id}")
	public Optional<ContactDetails> getContactDetails(@PathVariable String id){
		return contactrepository.findById(id);
	}
	@PutMapping("/update/{id}")
    public ContactDetails updateContactDetails(@PathVariable("id") String id,@RequestBody ContactDetails contact ) {
        contact.setId(id);
        contactrepository.save(contact);
        return contact;
	}
	 @DeleteMapping("/delcontact/{id}")
		public String deleteContactDetails (@PathVariable String id) {
			contactrepository.deleteById(id);
			return "Contact deleted with id : "+id;
		}
	 @GetMapping("/Contact")
     public ContactDetails getContactData() {
      ContactDetails cd = new ContactDetails ("1","john","john@gmail.com" );
         return cd;
	}

}
