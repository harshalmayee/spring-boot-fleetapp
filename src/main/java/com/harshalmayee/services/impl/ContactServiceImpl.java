package com.harshalmayee.services.impl;

import com.harshalmayee.models.Contact;
import com.harshalmayee.repositories.ContactRepository;
import com.harshalmayee.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void addNewContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(int id) {
        Optional<Contact> optional=contactRepository.findById(id);
        Contact contact=null;
        if(optional.isPresent()){
            contact=optional.get();
        }else{
            throw new RuntimeException("Contact Not Found For :"+id);
        }
        return contact;
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }
}
