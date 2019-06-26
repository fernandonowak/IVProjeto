package br.edu.ifsc.ivprojeto.db;

import br.edu.ifsc.ivprojeto.entities.Contact;
import javafx.collections.ObservableList;

public interface ContactsDBInterface {
	
	public Contact getContact(String firstName, String lastName, String number);
	
	public ObservableList<Contact> getContact();
	
	public void addContact(String firstName, String lastName, String number);	

}