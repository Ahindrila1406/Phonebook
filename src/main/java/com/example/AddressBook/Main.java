package com.example.AddressBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	 public static void main(String[] args) throws IOException {
	       AddressBook addressBook1 = new AddressBook();
	       AddressBook addressBook2=new AddressBook();
	       AddressBookPersist addressBookPersist = new AddressBookPersist();
	    		   
//	        // Display friends sorted by name

	        BufferedReader bfn = new BufferedReader(
	                new InputStreamReader(System.in));
	        System.out.println("Enter the number of friends :");
	        int input = Integer.parseInt(bfn.readLine());
	        if(input>0){
	            for(int i=0;i<input;i++){
	                System.out.println("Enter name:");
	                String name=bfn.readLine();
	                System.out.println("Enter phonenumber:");
	                String phonenumber=bfn.readLine();
	                addressBook1.addFriend(name,phonenumber);
	            }
	        }
	        addressBook1.displayFriendsSortedByName();
	        
	        addressBookPersist.addAddressBook(addressBook1);

//	        // Save address books to files
//	        addressBook1.saveToFile(addressBook1);
	        addressBookPersist.readAddressBooks();

	        //addressBook1 = addressBook1.readAddressBookFromFile("src/main/resources/address_book1.txt");
	        System.out.println("Enter the second address book :");
	        System.out.println("Enter the number of friends :");
	        int input1 = Integer.parseInt(bfn.readLine());
	        if(input1>0){
	            for(int i=0;i<input1;i++){
	                System.out.println("Enter name:");
	                String name=bfn.readLine();
	                System.out.println("Enter phonenumber:");
	                String phonenumber=bfn.readLine();
	                addressBook2.addFriend(name,phonenumber);
	            }
	        }
	        addressBook2.displayFriendsSortedByName();
	        addressBookPersist.addAddressBook(addressBook2);
	        //addressBook2.saveToFilefor2(addressBook2);
	        //addressBook2 = addressBook2.readAddressBookFromFile("src/main/resources/address_book2.txt");
	        addressBookPersist.readAddressBooks();
	        List<AddressBook> addressBookList = new ArrayList<AddressBook>();  
	        addressBookList.add(addressBook1);
	        addressBookList.add(addressBook2);
	        List<Contact> contactList1=addressBook1.getFriends();
	        List<Contact> contactList2=addressBook2.getFriends();
	        List<String> namelist1=contactList1.stream().map(c->c.getName()).collect(Collectors.toList());
	        List<String> namelist2=contactList2.stream().map(c->c.getName()).collect(Collectors.toList());
	        List<String> duplicatenames=namelist1.stream().filter(namelist2::contains).collect(Collectors.toList());
	        namelist1.removeIf(duplicatenames::contains);
	        namelist2.removeIf(duplicatenames::contains);
	        List<String> finalstring=Stream.of(namelist1,namelist2).flatMap(Collection::stream).collect(Collectors.toList());
	        System.out.println("Unique elements of two address book");
	        System.out.println((finalstring));
	    }

}
