package com.example.AddressBook;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String addressBookName;
    private ArrayList<Contact> contacts = new ArrayList<>();


    public AddressBook(String name) {
        this(name, new ArrayList<Contact>());
    }

    public AddressBook(String addressBookName, ArrayList<Contact> phonebook) {
        super();
        this.contacts = phonebook;
        this.addressBookName = addressBookName;
    }

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "AddressBook [addressBookName=" + addressBookName + ", phonebook=" + contacts + "]";
    }


    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
    }
    
    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void displayContactsSortedByName() {
        // Sort contacts by name
        Collections.sort(contacts, Comparator.comparing(Contact::getName));

        // Display the sorted list
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhoneNumber());
        }
    }
   
}



