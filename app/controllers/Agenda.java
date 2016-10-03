package controllers;

import java.util.List;

import javax.inject.Inject;

import controllers.auth.AgendaAuthenticator;
import models.Contact;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.list;
import views.html.newContact;

@LogRequest
@Authenticated(AgendaAuthenticator.class)
public class Agenda extends Controller {
	
	
	
	@Inject FormFactory formFactory;
	
	public Agenda (){
	}
	

	public Result list(){
		List<Contact> contact = Contact.find.all();
		return ok(list.render(contact));
	}
	
	public Result show(Long id){
		Contact contact = Contact.find.byId(id);
		if (contact == null){
			return notFound();
		} else {
			return ok();
		}
	}
	
	public Result newContact(){
		Logger.info("Working");
		

		return ok(newContact.render(formFactory.form(Contact.class)));
	}
	
	public Result createContact(){
		
		Form<Contact> cForm = formFactory.form(Contact.class).bindFromRequest();
		if(cForm.hasErrors()){
			return badRequest(views.html.newContact.render(cForm));
		} else {
			Contact contact = cForm.get();
			contact.save();
			return redirect(routes.Agenda.list());
		}
		
	}
}
