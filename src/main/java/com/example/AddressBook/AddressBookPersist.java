package com.example.AddressBook;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookPersist {

	public void storeAddressBooks(AddressBook addressBook, String fileName) {
		File file = new File(fileName);
		Path filePath = Paths.get(fileName);
		if (!file.exists()) {
			try {
				Files.createFile(filePath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		List<Contact> contactList = null;
		try {
			contactList = addressBook.getContacts();
			for (int i = 0; i < contactList.size(); i++) {
				Files.writeString(filePath, contactList.get(i).getName() + "\n", StandardOpenOption.APPEND);
				Files.writeString(filePath, contactList.get(i).getPhoneNumber() + "\n", StandardOpenOption.APPEND);
			}
			// Write the friend list to the file
			System.out.println("Address book saved to " + filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static AddressBook readAddressBookFromFile(String filePath) {
		AddressBook addressBook = new AddressBook();
		ArrayList<Contact> contactList = new ArrayList<>();
		try {
			String text = Files.readString(Path.of(filePath)).strip();
			String[] input = text.split("\n");
			for (int i = 0; i < input.length; i = i + 2) {
				for (int j = i; j <= i + 1; j++) {
					Contact c = new Contact(input[j].trim(), input[j + 1].trim());
					contactList.add(c);
					break;
				}
			}
			addressBook.setContacts(contactList);
			// Write the friend list to the file
			System.out.println("Address read successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressBook;
	}

	public static AddressBook readAddressBooks(String fileName) {
		AddressBook addressBook = new AddressBook();
		ArrayList<Contact> contactList = new ArrayList<>();
		File file = new File(fileName);
		try {
			if (file.exists()) {
				String text = Files.readString(Path.of(fileName)).strip();
				if (!text.isEmpty()) {
					String[] input = text.split("\n");
					for (int i = 0; i < input.length; i = i + 2) {
						for (int j = i; j <= i + 1; j++) {
							Contact c = new Contact(input[j].trim(), input[j + 1].trim());
							contactList.add(c);
							break;
						}
					}
					addressBook.setContacts(contactList);
					// Write the friend list to the file
					System.out.println("Address read successfully");
				}

			} else {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return addressBook;

	}

	public static void getUniqueContact(List<AddressBook> addressBooks) {

		List<Contact> contactList1 = addressBooks.get(0).getContacts();
		List<Contact> contactList2 = addressBooks.get(1).getContacts();
		List<String> namelist1 = contactList1.stream().map(c -> c.getName()).distinct().collect(Collectors.toList());
		List<String> namelist2 = contactList2.stream().map(c -> c.getName()).distinct().collect(Collectors.toList());
		List<String> duplicatenames = namelist1.stream().filter(namelist2::contains).collect(Collectors.toList());
		namelist1.removeIf(duplicatenames::contains);
		namelist2.removeIf(duplicatenames::contains);
		List<String> finalstring = Stream.of(namelist1, namelist2).flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println("Unique elements of two address book");
		System.out.println((finalstring));

	}

}
