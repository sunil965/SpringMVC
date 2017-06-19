package com.bridgeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class UserRegistrationModel {

	@Id
	@GenericGenerator(name="reg", strategy="increment")
	@GeneratedValue(generator="reg")
	@Column
	private int id;
	
	@Column
	@NotEmpty(message="Enter The Name")
	private String name;
	
	@Column
	@NotEmpty
	@Email
	private String email;
	
	@Column
	@NotEmpty
	@Size(min=3,max=8)
	private String password;
	
	
	@Column
	@NotEmpty
	private String contact;
	
	public UserRegistrationModel(int id, String name, String email, String password, String contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public UserRegistrationModel() {
		
	}
	@Override
	public String toString() {
		return "UserRegistrationModel [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + "]";
	}
}
