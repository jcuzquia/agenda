package models;
import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

import org.junit.Test;

public class ContactTest {
	
	@Test
	public void testContactModel(){
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			public void run() {
				String name = "Gonto";
				String email = "gonto@gonto.com";
				String phone = "4444";
						
				Contact contact = new Contact(name, phone, email);
				
				contact.save();
				
				Contact savedContact = Contact.find.byId(contact.id);
				
				assertNotNull(savedContact);
				assertEquals(savedContact.name, name);
				assertEquals(savedContact.email, email);
				assertEquals(savedContact.phone, phone);
			}
		});
	}
}
