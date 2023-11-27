package com.example.AddressBook;
import java.io.EOFException;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookPersist {

    private AddressBook addressBook;
    private List<AddressBook> addressBooks = new ArrayList<AddressBook>();

    public AddressBookPersist() {
        addressBook = new AddressBook();
        addressBook = readAddressBooks(); // reads from previous runs      
    }

    public void addAddressBook(AddressBook addressbook) {
        if(!addressBooks.contains(addressbook)){
            addressBooks.add(addressbook);
            storeAddressBooks(addressbook);
        }

    }

    public void removeAddressBook(AddressBook addressbook) {
        if(addressBooks.contains(addressbook)){
            addressBooks.remove(addressbook);
            storeAddressBooks(addressbook);
        }

    }

    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

//    public void setAddressBooks(List<AddressBook> addressBooks) {
//        this.addressBooks = addressBooks;
//        storeAddressBooks(addressBooks);
//
//    }   
//
//    public void removeAllAddressBooks(){
//        addressBooks.clear();
//        storeAddressBooks(addressBooks);
//
//    }   

    public void storeAddressBooks(AddressBook addressBook) {

        Path filePath = Paths.get("src/main/resources/abc.txt");
        List<Contact> contactList=null;
        try  {
            contactList=addressBook.getFriends();
            for(int i=0;i<contactList.size();i++) {
                Files.writeString(filePath, contactList.get(i).getName()+ "\n", StandardOpenOption.APPEND);
                Files.writeString(filePath, contactList.get(i).getPhoneNumber()+ "\n", StandardOpenOption.APPEND);
            }
            // Write the friend list to the file
            System.out.println("Address book saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    public static AddressBook readAddressBookFromFile(String filePath) {
        AddressBook addressBook=new AddressBook();
        ArrayList<Contact> contactList=new ArrayList<>();
        try  {
            String text=Files.readString(Path.of(filePath)).strip();
            String[] input=text.split("\n");
            for(int i=0;i<input.length;i=i+2){
                for(int j=i;j<=i+1;j++){
                    Contact c=new Contact(input[j].trim(),input[j+1].trim());
                    contactList.add(c);
                    break;
                }
            }
            addressBook.setFriends(contactList);
            // Write the friend list to the file
            System.out.println("Address read successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBook;
    }

    public AddressBook readAddressBooks() {
    	 AddressBook addressBook=new AddressBook();
         ArrayList<Contact> contactList=new ArrayList<>();
         try  {
             String text=Files.readString(Path.of("src/main/resources/abc.txt")).strip();
             if(!text.isEmpty())
             {
             String[] input=text.split("\n");
             for(int i=0;i<input.length;i=i+2){
                 for(int j=i;j<=i+1;j++){
                     Contact c=new Contact(input[j].trim(),input[j+1].trim());
                     contactList.add(c);
                     break;
                 }
             }
             addressBook.setFriends(contactList);
             // Write the friend list to the file
             System.out.println("Address read successfully");
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
         return addressBook;
    	
}
		
		
    
}
    
