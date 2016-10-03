package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

@Entity
public class Contact extends Model{
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	public String name;
	
	@Required
	public String phone;
	
	@Required
	@Email
	public String email;
	
	public static Finder<Long, Contact> find = new Model.Finder<Long, Contact>(Contact.class);

	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	
}
