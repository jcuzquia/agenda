package views;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.apache.http.entity.ContentType;
import org.junit.Test;

import models.Contact;
import play.Logger;
import play.twirl.api.Html;

public class ListTemplateTest {
	
	@Test
	public void testTemplateList(){
		List<Contact> contacts = new ArrayList<Contact>();
		String name = "Gonto";
		String email = "gonto@gonto.com";
		String phone = "4444";
				
		Contact contact = new Contact(name, phone, email);
		
		contacts.add(contact);
		Html content = views.html.list.render(contacts);
		
		assertEquals(content.contentType(), "text/html");
		
		assertTrue(content.body().contains(contact.name));
		assertTrue(content.body().contains("Create New Contact"));
	}
}
