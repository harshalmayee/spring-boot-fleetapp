package com.harshalmayee.services;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();

    public void addNewContact(Contact contact);

    public Contact getContactById(int id);

    void delete(int id);
}
