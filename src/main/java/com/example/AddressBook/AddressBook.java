package com.example.AddressBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private String addressBookName;
	private ArrayList<Contact> phonebook = new ArrayList<>();
	
	public AddressBook(String name) {
        this(name, new ArrayList<Contact>());
    }
	
	public AddressBook(String addressBookName, ArrayList<Contact> phonebook) {
		super();
		this.phonebook = phonebook;
		this.addressBookName = addressBookName;
	}

    public AddressBook() {
        this.phonebook = new ArrayList<>();
    }

    @Override
	public String toString() {
		return "AddressBook [addressBookName=" + addressBookName + ", phonebook=" + phonebook + "]";
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}
    
    

	public void addContact(Contact contact) {
        phonebook.add(contact);
    }

    public void displayContacts() {
        System.out.println("Contacts in Address Book in sorted order:");
        Set<Contact> set = phonebook.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Contact::getName))));
        for (Contact contact : set) {
            System.out.println(contact);
        }
        System.out.println();
    }

    public Contact searchContact(String name) {
        for (Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

	public String getAddressBookName() {
		return addressBookName;
	}

	

	

}
