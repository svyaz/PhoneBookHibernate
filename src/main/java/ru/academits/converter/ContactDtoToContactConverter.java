package ru.academits.converter;

import org.springframework.stereotype.Service;
import ru.academits.dto.ContactDto;
import ru.academits.model.Contact;

@Service
public class ContactDtoToContactConverter extends AbstractConverter<ContactDto, Contact> {
    @Override
    public Contact convert(ContactDto contactDto) {
        Contact contact = new Contact();

        contact.setId(contactDto.getId());
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setPhone(contactDto.getPhone());

        return contact;
    }
}
