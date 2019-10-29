package ru.academits.service;

import org.junit.Test;
import ru.academits.dao.ContactDaoImpl;
import ru.academits.model.Contact;
import ru.academits.model.ContactValidation;
import ru.academits.model.ContactsDeletion;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService = new ContactService(new ContactDaoImpl());

    @Test
    public void getAllContactsTest() {
        List<Contact> contactList = contactService.getAllContacts();
        assertEquals(contactList.size(), 2);
        assertEquals(contactList.get(0).getPhone(), "9123456789");
        assertEquals(contactList.get(1).getPhone(), "9131234567");
    }

    @Test
    public void getFilteredContactsTest() {
        List<Contact> contactList = contactService.getFilteredContacts("913");
        assertEquals(contactList.size(), 1);
        assertEquals(contactList.get(0).getPhone(), "9131234567");
    }

    @Test
    public void addContactTest() {
        Contact contact = new Contact();
        contact.setFirstName("Alain");
        contact.setLastName("Prost");
        contact.setPhone("111-222-333");
        ContactValidation validation = contactService.addContact(contact);
        List<Contact> contactList = contactService.getFilteredContacts("Pro");

        assertTrue(validation.isValid());
        assertEquals(contactList.size(), 1);
        assertEquals(contactList.get(0).getFirstName(), "Alain");
    }

    @Test
    public void deleteContactsTest() {
        ContactsDeletion deletion = contactService.deleteContacts(Arrays.asList(2L, 1L, 4L, 10L, 1234567890L));
        assertEquals(deletion.getDeleteNumber(), 2);
    }

    @Test
    public void deleteContactsZeroDeletedTest() {
        ContactsDeletion deletion = contactService.deleteContacts(Arrays.asList(888L, 999L, 1010L));
        assertEquals(deletion.getDeleteNumber(), 0);
        assertEquals(deletion.getError(), "Ни одного контакта не удалено.");
    }
}