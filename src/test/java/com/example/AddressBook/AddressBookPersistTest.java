package com.example.AddressBook;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressBookPersistTest {

    AddressBookPersist addressBookPersist;
    @BeforeEach
    public  void init(){
        addressBookPersist=new AddressBookPersist();
    }
    @Test
    void storeAddressBooks() {
        AddressBook addressBook=new AddressBook();
        ArrayList<Contact> contactlist=new ArrayList<>();
        Contact c1=new Contact("Bob","567");
        Contact c2=new Contact("Mary","567");
        Contact c3=new Contact("Jane","567");
        contactlist.add(c1);
        contactlist.add(c2);
        contactlist.add(c3);
        addressBook.setContacts(contactlist);
        addressBookPersist.storeAddressBooks(addressBook,"test.txt");
    }

    @Test
    void readAddressBookFromFile() {
        assertNotNull(AddressBookPersist.readAddressBooks("src/main/resources/addressbook1.txt"));
    }


    @Test
    void getUniqueContact() {
        AddressBook addressBook=new AddressBook();
        ArrayList<Contact> contactlist=new ArrayList<>();
        Contact c1=new Contact("Bob","567");
        Contact c2=new Contact("Mary","567");
        Contact c3=new Contact("Jane","567");
        contactlist.add(c1);
        contactlist.add(c2);
        contactlist.add(c3);
        addressBook.setContacts(contactlist);
        AddressBook addressBook1=new AddressBook();
        ArrayList<Contact> contactlist1=new ArrayList<>();
        Contact c4=new Contact("Mary","567");
        Contact c5=new Contact("John","567");
        Contact c6=new Contact("Jane","567");
        contactlist1.add(c4);
        contactlist1.add(c5);
        contactlist1.add(c6);
        addressBook1.setContacts(contactlist1);
        List<AddressBook> addressBookList=new ArrayList<>();
        addressBookList.add(addressBook);
        addressBookList.add(addressBook1);
        addressBookPersist.getUniqueContact(addressBookList);
    }
}