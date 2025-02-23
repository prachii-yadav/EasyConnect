package com.scm.scm20.services;

import java.util.List;

import com.scm.scm20.entities.Contact;
import com.scm.scm20.entities.User;

public interface ContactService {

    //save contacts
   Contact save(Contact contact);

   //update contact
   Contact update(Contact contact);

   //get contacts
   List<Contact> getAll();

   //get contact by id
   Contact getById(String id);

   //delete contact
   void delete(String id);

   //search contact
   List<Contact> search(String name,String email,String phoneNumber);

   //get contacts by userId
   List<Contact> getByUserId(String userId);

    //get contacts by user
   List<Contact> getByUser(User user);

   

   

}
