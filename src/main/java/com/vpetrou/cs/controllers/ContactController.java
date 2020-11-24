package com.vpetrou.cs.controllers;

import com.vpetrou.cs.models.Contact;
import com.vpetrou.cs.repositories.ContactRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "Contact Management System")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @ApiOperation(value = "View all contacts")
    @RequestMapping(method = RequestMethod.GET, value = "/contacts")
    public Iterable<Contact> contact() {
        return contactRepository.findAll();
    }

    @ApiOperation(value = "Create a contact")
    @RequestMapping(method = RequestMethod.POST, value = "/contacts")
    public Contact save(
            @ApiParam(value = "Contact object to add in database table", required = true)
            @RequestBody
            @Valid Contact contact) {
        if (contactRepository.getEmailCount(contact.getEmail()) == 0) {
            contactRepository.save(contact);
            return contact;
        } else {
            return null;
        }
    }

    @ApiOperation(value = "View a contact")
    @RequestMapping(method = RequestMethod.GET, value = "/contacts/{id}")
    public Contact show(
            @ApiParam(value = "Contact id from which contact object will retrieve", required = true)
            @PathVariable String id) {
        return contactRepository.findOne(id);
    }

    @ApiOperation(value = "Update a contact")
    @RequestMapping(method = RequestMethod.POST, value = "/contacts/{id}")
    public Contact update(
            @ApiParam(value = "Contact object to update in database table", required = true)
            @RequestBody Contact contact) {
        Contact c = contactRepository.findOne(contact.getId());
        if (contact.getName() != null)
            c.setName(contact.getName());
        if (contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if (contact.getCity() != null)
            c.setCity(contact.getCity());
        if (contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if (contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        if (contact.getGender() != null)
            c.setGender(contact.getGender());
        if (contact.getDisabled() != null)
            c.setDisabled(contact.getDisabled());
        contactRepository.save(c);
        return contact;
    }


    @ApiOperation(value = "Delete a contact")
    @RequestMapping(method = RequestMethod.DELETE, value = "/contacts/{id}")
    public String delete(
            @ApiParam(value = "Contact id from which contact object will retrieve", required = true)
            @PathVariable String id) {
        Contact contact = contactRepository.findOne(id);
        contactRepository.delete(contact);
        return "";
    }

    @ApiOperation(value = "Delete all contacts")
    @RequestMapping(method = RequestMethod.DELETE, value = "/contacts/delete")
    public String deleteAll() {
        Iterable<Contact> contacts = contactRepository.findAll();
        contactRepository.delete(contacts);
        return "";
    }
}
