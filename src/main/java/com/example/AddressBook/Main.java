package com.example.AddressBook;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws OptionalDataException {
		
		
		Scanner scanner = new Scanner(System.in);
        //AddressBook addressBook = new AddressBook();
        AddressBookPersist addressBookPersist = new AddressBookPersist();
        ArrayList<Contact> contactList = new ArrayList<>();


        while (true) {
        	//AddressBook addressBook = new AddressBook();
//            System.out.println("1. Add Contact");
//            System.out.println("2. Exit");
////            System.out.println("2. Display Contacts");
////            System.out.println("3. Search Contact");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume the newline

//            switch (choice) {
//                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    contactList.add(newContact);
                    if (name.equalsIgnoreCase("exit")) {
                        break;
                     }
                    System.out.println("Enter the name of the Address book");
                	String addressBookName = scanner.nextLine();
                	AddressBook addressBook = new AddressBook(addressBookName,contactList);
                	addressBookPersist.addAddressBook(addressBook);
                    System.out.println("Contact added successfully.\n");
                    addressBookPersist.readAddressBooks();
                    
                   
                    
                    break;
//                case 2:
//                    System.out.println("Exiting the address book. Goodbye!");
//                    System.exit(0);
////
//                case 3:
//                   addressBook.displayContacts();
//                   break;
//
//                case 3:
//                    System.out.print("Enter name to search: ");
//                    String searchName = scanner.nextLine();
//                    Contact foundContact = addressBook.searchContact(searchName);
//                    if (foundContact != null) {
//                        System.out.println("Contact found:\n" + foundContact);
//                    } else {
//                        System.out.println("Contact not found.\n");
//                    }
//                    break;

               

//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.\n");
//                    break;
            }
        }
//        

		
//		Contact c = null;
//
//        System.out.println("Enter user details. Type 'exit' to stop.");
//
//            while (true) {
//                // Read user input for name
//                System.out.print("Enter contact name: ");
//                String name = scanner.nextLine();
//
//                if (name.equalsIgnoreCase("exit")) {
//                    break;
//                }
//
//                // Read user input for phone number
//                System.out.print("Enter phone number: ");
//                String phoneNumber = scanner.nextLine();
//                c = new Contact(name,phoneNumber);
//               
////                addressBook = new AddressBook(addressBookName);
//
//                // Write the user details to the file
//                oos.writeObject(c);
//            }
//            System.out.println("User details written");
//
//        }
//
//    catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        scanner.close();
//    }
//
//        
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/AAA.dat"))) {
//        	System.out.println("Address book details");
//            while (true) {
//                try {
//                	Contact user = (Contact) ois.readObject();
//                    System.out.println( user);
//                } catch (EOFException e) {
//                    // End of file reached
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        
//        
//    }
    }

	

