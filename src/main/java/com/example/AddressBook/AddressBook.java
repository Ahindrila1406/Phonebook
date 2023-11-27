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
    private static final String FILE_NAME = "src/main/resources/AAA.txt";


    private String addressBookName;
    private ArrayList<Contact> friends = new ArrayList<>();


    public AddressBook(String name) {
        this(name, new ArrayList<Contact>());
    }

    public AddressBook(String addressBookName, ArrayList<Contact> phonebook) {
        super();
        this.friends = phonebook;
        this.addressBookName = addressBookName;
    }

    public AddressBook() {
        this.friends = new ArrayList<>();
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public ArrayList<Contact> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Contact> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "AddressBook [addressBookName=" + addressBookName + ", phonebook=" + friends + "]";
    }


    public void addFriend(String name, String phoneNumber) {
        Contact friend = new Contact(name, phoneNumber);
        friends.add(friend);
    }
    
    public void addFriend(Contact c) {
        friends.add(c);
    }

    public void displayFriendsSortedByName() {
        // Sort friends by name
        Collections.sort(friends, Comparator.comparing(Contact::getName));

        // Display the sorted list
        for (Contact friend : friends) {
            System.out.println("Name: " + friend.getName() + ", Phone: " + friend.getPhoneNumber());
        }
    }
   
}



