package ru.academits.dao;

import org.junit.Ignore;
import org.junit.Test;
import ru.academits.model.Contact;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContactDaoTest {
    private ContactDao contactDao = new ContactDaoImpl();

    @Test
    public void getAllContactsTest() {
        List<Contact> contactList = contactDao.getAllContacts();
        assertEquals(contactList.size(), 2);
        assertEquals(contactList.get(0).getPhone(), "9123456789");
        assertEquals(contactList.get(1).getPhone(), "9131234567");
    }

    @Ignore
    @Test
    public void getFilteredContactsTest() {
        //TODO
        /*List<Contact> contactList = contactDao.getFilteredContacts("913");
        assertEquals(contactList.size(), 1);
        assertEquals(contactList.get(0).getPhone(), "9131234567");*/
    }

    @Ignore
    @Test
    public void addTest() {
        //TODO
        /*Contact contact = new Contact();
        contact.setFirstName("Jim");
        contact.setLastName("Morrison");
        contact.setPhone("999-000");
        contactDao.add(contact);
        List<Contact> contactList = contactDao.getFilteredContacts("000");

        assertEquals(contactList.size(), 1);
        assertEquals(contactList.get(0).getLastName(), "Morrison");*/
    }

    @Ignore
    @Test
    public void deleteContactsTest() {
        //TODO
        /*int delCount = contactDao.deleteContacts(Arrays.asList(1, 2, 3));
        assertEquals(delCount, 2);*/
    }

    @Ignore
    @Test
    public void deleteContactsZeroDeletedTest() {
        //TODO
        /*int delCount = contactDao.deleteContacts(Arrays.asList(777, -1000));
        assertEquals(delCount, 0);*/
    }
}