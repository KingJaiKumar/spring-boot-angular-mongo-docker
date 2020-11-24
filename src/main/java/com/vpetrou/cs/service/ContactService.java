package com.vpetrou.cs.service;


import com.vpetrou.cs.models.Contact;
import com.vpetrou.cs.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact getContactById(String contactId) {
        Contact obj = contactRepository.findOne(contactId);
        return obj;
    }

    @Override
    public List<Contact> getContactByName(String title) {
        List<Contact> list = new ArrayList<>();
        contactRepository.findByNameIgnoreCaseContaining(title).forEach(e -> list.add(e));
        return list;
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> list = new ArrayList<>();
        contactRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public synchronized boolean addContact(Contact contact) {
        if (contactRepository.getEmailCount(contact.getEmail()) == 0) {
            contactRepository.save(contact);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
