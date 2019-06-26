package br.edu.ifsc.ivprojeto.db;

import java.util.ArrayList;

import br.edu.ifsc.ivprojeto.entities.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactsList implements ContactsDBInterface {

	private static ObservableList<Contact> contacts;

	@Override
	public Contact getContact(String firstName, String lastName, String number) {
		contacts = getContact();
		for (Contact contact : contacts)
			if (contact.getFirstName().contentEquals(firstName) && contact.getLastName().contentEquals(lastName)
					&& contact.getNumber().contentEquals(number))
				return contact;
		return null;
	}

	@Override
	public ObservableList<Contact> getContact() {
		if (contacts == null) {
			contacts = FXCollections.observableArrayList(new ArrayList<Contact>());
			contacts.add(new Contact("admin", "admin", "651561651"));
			contacts.add(new Contact("admin1", "admin1", "65423534"));
		}
		return contacts;
	}

	@Override
	public void addContact(String firstName, String lastName, String number) {
		getContact().add(new Contact(firstName, lastName, number));

	}

}
