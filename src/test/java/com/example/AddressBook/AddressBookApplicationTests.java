package com.example.AddressBook;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;

@SpringBootTest
class AddressBookApplicationTests {

	 private Contact c1, c2, c3, c4, c5, c6, c7;
	    private AddressBookPersist addressBookPersist;

	    @Before
	    public void setUp() {
	        addressBookPersist = new AddressBookPersist();
	        createNewContacts();
	    }

	    public static void main(String[] args) {
	    	AddressBookApplicationTests test = new AddressBookApplicationTests();
	        test.setUp();
	        test.sortFriendsByTheirNames();
	        //test.uniqueFriendsFromTwoAddressBooks();
	        //test.uniqueFriendsFromThreeAddressBooks();
	    }

//	    @Test
//	    public void uniqueFriendsFromTwoAddressBooks() {
//	        System.out.println("========== Unique Friends from Two Address Books ==========");
//
//	        addTwoAddressBooks();
//
//	        List<AddressBook> addressBooks = addressBookPersist.getAddressBooks();
//	        printInput(addressBooks);
//
//	        // Get unique contacts from two AddressBooks
//	        Set<Contact> uniqueContacts = AddressBook.getUniqueContacts(addressBooks);
//
//	        printOutput(addressBooks, uniqueContacts);  
//
//	        // The unique contacts from these two address books should be c1 and c4
//	        Set<Contact> expected = new HashSet<Contact>(Arrays.asList(c1, c4));
//
//	        assertTrue(uniqueContacts.equals(expected));
//	    }

//	    @Test
//	    public void uniqueFriendsFromThreeAddressBooks() {
//	        System.out.println("========== Unique Friends from Three Address Books ==========");
//
//	        addThreeAddressBooks();
//
//	        List<AddressBook> addressBooks = addressBookPersist.getAddressBooks();
//	        printInput(addressBooks);       
//
//	        // Get unique contacts from three AddressBooks
//	        Set<Contact> uniqueContacts = AddressBook.getUniqueContacts(addressBooks);
//
//	        printOutput(addressBooks, uniqueContacts);
//
//	        // The unique contacts from three address books should be c1, c4 and c5, c6, c7
//	        Set<Contact> expected = new HashSet<Contact>(Arrays.asList(c4, c5, c6, c7));
//
//	        assertTrue(uniqueContacts.equals(expected));
//	    }

	    @Test
	    public void sortFriendsByTheirNames() {
	        System.out.println("========== Display the list of friends sorted by their name ==========");

	        AddressBook addressBook = new AddressBook("ab1");
	        addressBook.addFriend(c5);
	        addressBook.addFriend(c1);
	        addressBook.addFriend(c4);
	        addressBook.addFriend(c2);
	        addressBook.addFriend(c3);


	        System.out.println("==Input==");
	        System.out.println("Friends:");
	        for (Contact contact : addressBook.getFriends()) {
	            System.out.println(contact);
	        }
	        System.out.println();
	        
	        System.out.println("==Output==");
	        System.out.println("Friends:");

	        Collections.sort(addressBook.getFriends(), Comparator.comparing(Contact::getName));

	        // Display the sorted list
	        for (Contact friend : addressBook.getFriends()) {
	            System.out.println("Name: " + friend.getName() + ", Phone: " + friend.getPhoneNumber());
	        }
	        System.out.println("\n");

	        // Sorted list
	        assertTrue("Bob".equals(addressBook.getFriends().get(0).getName()));
	        assertTrue("Jane".equals(addressBook.getFriends().get(1).getName()));
	        assertTrue("John".equals(addressBook.getFriends().get(2).getName()));
	        assertTrue("Mary".equals(addressBook.getFriends().get(3).getName()));
	        assertTrue("Ruby".equals(addressBook.getFriends().get(4).getName()));

	    }

	    private void createNewContacts() {
	        c1 = new Contact("Bob", "02 9218 5479");
	        c2 = new Contact("Mary", "04 9218 5479");
	        c3 = new Contact("Jane", "02 9 605 3147");
	        c4 = new Contact("John", "02 605 3147");
	        c5 = new Contact("Ruby", "03 9 605 3147");
	        c6 = new Contact("Paul", "03 9 605 3147");
	        c7 = new Contact("Zee", "03 9 605 3147");

	    }

	    private void addTwoAddressBooks() {
	        //addressBookPersist.removeAllAddressBooks();

	        AddressBook addressBook1 = new AddressBook();
		    AddressBook addressBook2=new AddressBook();

	        // AddContacts to the addressBooks
		    addressBook1.addFriend(c1);
		    addressBook1.addFriend(c2);
		    addressBook1.addFriend(c3);

		    addressBook2.addFriend(c2);
		    addressBook2.addFriend(c4);
		    addressBook2.addFriend(c3);

	        addressBookPersist.addAddressBook(addressBook1);
	        addressBookPersist.addAddressBook(addressBook2);
	    }


//	    private void printInput(List<AddressBook> addressBooks){
//	        System.out.println("==Input==");
//
//	        for (AddressBook addressBook : addressBooks) {
//	            System.out.println("Address Book: " + addressBook.getName());
//	            System.out.println("Friends:");
//	            for (Contact c : addressBook.getContacts()) {
//	                System.out.println(c.getName());
//	            }
//	            System.out.println("");
//
//	        }
//	    }
//
//	    private void printOutput(List<AddressBook> addressBooks,Set<Contact> uniqueContacts){
//	        System.out.println("==Output==");
//	        System.out.print("Address Books: ");
//	        String names = "";
//	        for (AddressBook addressBook : addressBooks) {
//	            names += addressBook.getName() + ", ";
//	        }
//
//	        if (names.length() > 0) {
//	            System.out.println(names.substring(0, names.lastIndexOf(",")));
//	        }
//	        for (Contact c : uniqueContacts) {
//	            System.out.println(c.getName());
//	        }
//	        System.out.println("\n");
//	    }


}
