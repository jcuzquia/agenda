package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.*;

import org.junit.Test;

import models.Contact;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.routing.Router;
import play.test.WithApplication;

public class AgendaTest extends WithApplication{
	
	
	@Test
	public void testListAction() {
		
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			
			public void run() {
				String name = "Gonto";
				String email = "gonto@gonto.com";
				String phone = "4444";
						
				Contact contact = new Contact(name, phone, email);
				contact.save();
				
				Result result = new Agenda().list();
				assertEquals(OK, result.status());
				assertEquals(result.contentType().get(),"text/html" );
				assertTrue(contentAsString(result).contains(contact.name));
			}
		});
	}
	
	@Test
	public void testNewContactRoute(){
		RequestBuilder request = new RequestBuilder().method(GET).uri("/contacts/new");
		Result result = route(request);
		assertEquals(OK, result.status());
	}
	
	@Test
	public void testInvalideRoute(){
		RequestBuilder request = new RequestBuilder().method(GET).uri("/contac/new");
		Result result = route(request);
		assertEquals(NOT_FOUND,result.status());
	}

}
