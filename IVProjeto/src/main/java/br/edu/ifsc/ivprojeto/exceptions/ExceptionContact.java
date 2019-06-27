package br.edu.ifsc.ivprojeto.exceptions;

public class ExceptionContact extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExceptionContact() {
		super("Deu pau no login");
		System.out.println("Criei a excessão");
	}

}
