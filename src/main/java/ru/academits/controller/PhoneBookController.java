package ru.academits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.academits.converter.ContactDtoToContactConverter;
import ru.academits.converter.ContactToContactDtoConverter;
import ru.academits.dto.ContactDto;
import ru.academits.model.ContactValidation;
import ru.academits.model.ContactsDeletion;
import ru.academits.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping(value = "/phonebook")
public class PhoneBookController {
    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    private final ContactService contactService;
    private final ContactDtoToContactConverter contactDtoToContactConverter;
    private final ContactToContactDtoConverter contactToContactDtoConverter;

    public PhoneBookController(ContactService contactService,
                               ContactDtoToContactConverter contactDtoToContactConverter,
                               ContactToContactDtoConverter contactToContactDtoConverter) {
        this.contactService = contactService;
        this.contactDtoToContactConverter = contactDtoToContactConverter;
        this.contactToContactDtoConverter = contactToContactDtoConverter;
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactDto> getAllContacts() {
        logger.info("Called getAllContacts");
        return contactToContactDtoConverter.convert(contactService.getAllContacts());
    }

    @RequestMapping(value = "/get/filter", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactDto> getFilteredContacts(@RequestParam String s) {
        // s - filter string
        logger.info("Called getFilteredContacts(" + s + ")");
        return contactToContactDtoConverter.convert(contactService.getFilteredContacts(s));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ContactValidation addContact(@RequestBody ContactDto contact) {
        logger.info("Called addContact(" + contact + ")");
        return contactService.addContact(contactDtoToContactConverter.convert(contact));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ContactsDeletion deleteContacts(@RequestBody List<Long> idsList) {
        logger.info("Called deleteContacts(" + idsList + ")");
        return contactService.deleteContacts(idsList);
    }
}
