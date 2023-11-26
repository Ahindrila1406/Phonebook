package com.example.AddressBook;

import java.io.Serializable;

public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	String name;
	String phoneNumber;
	
	public Contact(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }

}
