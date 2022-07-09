package com.sokalski;

import java.util.ArrayList;

// Able to store, modify, remove and query contact names.
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts() {
        System.out.println("CONTACT LIST: ");
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + "." + this.myContacts.get(i).getName() + " --> "
                    + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >=0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position < 0) {
            System.out.println(oldContact.getName() + " not found");
            return false;
        }

        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " replaced with " + newContact.getName());
        return true;
    }

    public boolean deleteContact(Contact contact) {
        int position = findContact(contact);
        if(position < 0) {
            System.out.println(contact.getName() + " not found");
            return false;
        }

        this.myContacts.remove(contact);
        System.out.println(contact.getName() + " deleted");
        return true;
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) return contact.getName();
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) return this.myContacts.get(position);
        return null;
    }

}
