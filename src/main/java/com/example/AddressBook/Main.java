package com.example.AddressBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		AddressBook addressBook1 = new AddressBook();
		AddressBook addressBook2 = new AddressBook();
		AddressBookPersist addressBookPersist = new AddressBookPersist();

		BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of friends :");
		int input = Integer.parseInt(bfn.readLine());
		if (input > 0) {
			for (int i = 0; i < input; i++) {
				System.out.println("Enter name:");
				String name = bfn.readLine();
				System.out.println("Enter phonenumber:");
				String phonenumber = bfn.readLine();
				addressBook1.addContact(name, phonenumber);
			}
		}

		System.out.println("========== Display the list of friends sorted by their name ==========");
		addressBook1.displayContactsSortedByName();
		addressBookPersist.storeAddressBooks(addressBook1, "src/main/resources/addressbook1.txt");

		addressBook1 = addressBookPersist.readAddressBooks("src/main/resources/addressbook1.txt");

		System.out.println("Enter the second address book :");
		System.out.println("Enter the number of friends :");
		int input1 = Integer.parseInt(bfn.readLine());
		if (input1 > 0) {
			for (int i = 0; i < input1; i++) {
				System.out.println("Enter name:");
				String name = bfn.readLine();
				System.out.println("Enter phonenumber:");
				String phonenumber = bfn.readLine();
				addressBook2.addContact(name, phonenumber);
			}
		}
		System.out.println("========== Display the list of friends sorted by their name ==========");
		addressBook2.displayContactsSortedByName();
		addressBookPersist.storeAddressBooks(addressBook2, "src/main/resources/addressbook2.txt");
		addressBook2 = addressBookPersist.readAddressBooks("src/main/resources/addressbook2.txt");
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		addressBookList.add(addressBook1);
		addressBookList.add(addressBook2);
		System.out.println("========== Unique Friends from Two Address Books ==========");
		addressBookPersist.getUniqueContact(addressBookList);

	}

}
