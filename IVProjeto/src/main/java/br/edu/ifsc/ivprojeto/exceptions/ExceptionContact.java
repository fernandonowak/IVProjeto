package br.edu.ifsc.ivprojeto.exceptions;

public class ExceptionContact extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExceptionContact() {
		super("Erro ao adicionar contato");
		System.out.println("Criei a excessão");
	}

}
