package com.cg;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
 
import com.cg.service.ContactService;
 
import static org.mockito.Mockito.when;
 
import com.cg.model.ContactDetails;
import com.cg.repository.ContactRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
@SpringBootTest
@RunWith(SpringRunner.class)

class ContactServiceApplicationTests {
	@Autowired
    private ContactService contactService;

    @MockBean
    private ContactRepository conatctRepository;
 
    @Test
    public void getContactTest() {
        when(conatctRepository.findAll()).thenReturn(Stream
                .of(new ContactDetails("@max","max","max@gmail.com"), new ContactDetails("1john","john","john@yahoo.com")).collect(Collectors.toList()));
            assertEquals(2,contactService.getContactDetails().size());
    }
        private void assertEquals(int i, int size) {
        // TODO Auto-generated method stub

    }
        @Test
        public void saveContactTest() {
            ContactDetails contact = new ContactDetails("Clay#", "clay", "clay@gmail.com");
            when(conatctRepository.save(contact)).thenReturn(contact);
            assertEquals(contact, contactService.addContactDetails(contact));

        }
        private void assertEquals(ContactDetails contact, ContactDetails addContact) {
            // TODO Auto-generated method stub

        }
}
