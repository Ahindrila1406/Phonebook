package com.example.AddressBook;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddressBookPersist {

    private List<AddressBook> addressBooks;

    public AddressBookPersist() {
        addressBooks = new ArrayList<AddressBook>();
        addressBooks = readAddressBooks(); // reads from previous runs      
    }

    public void addAddressBook(AddressBook addressbook) {
        if(!addressBooks.contains(addressbook)){
            addressBooks.add(addressbook);
            storeAddressBooks(addressBooks);
        }

    }

    public void removeAddressBook(AddressBook addressbook) {
        if(addressBooks.contains(addressbook)){
            addressBooks.remove(addressbook);
            storeAddressBooks(addressBooks);
        }

    }

    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

    public void setAddressBooks(List<AddressBook> addressBooks) {
        this.addressBooks = addressBooks;
        storeAddressBooks(addressBooks);

    }   

    public void removeAllAddressBooks(){
        addressBooks.clear();
        storeAddressBooks(addressBooks);

    }   

    public void storeAddressBooks(List<AddressBook> addressBooks) {
        try {
        	for(AddressBook addressBook:addressBooks)
        	{
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/abc.dat"));
            oos.writeObject(addressBook);
            oos.close();
        } }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<AddressBook> readAddressBooks() {
        List<AddressBook> addressBooks = new ArrayList<AddressBook>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    "src/main/resources/abc.dat"));
            if(ois.readObject() != null){
                addressBooks = (List<AddressBook>) ois.readObject();
            }
            ois.close();
        } catch (EOFException ex) {

        	System.out.println("");
        }catch (FileNotFoundException ex) {
            System.out.println("No address books stored");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addressBooks;
    }
}
    

