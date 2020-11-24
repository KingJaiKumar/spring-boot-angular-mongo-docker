package com.vpetrou.cs.service;


import com.vpetrou.cs.models.Contact;

import java.util.List;

public interface IContactService {
     List<Contact> getAllContacts();
     Contact getContactById(String contactId);
     List<Contact> getContactByName(String name);
     boolean addContact(Contact contact);
     void updateContact(Contact contact);
     void deleteContact(Contact contact);
}
