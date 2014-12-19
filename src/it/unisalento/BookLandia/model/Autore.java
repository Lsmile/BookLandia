package it.unisalento.BookLandia.model;

public class Autore {
	String Nome;
	String Cognome;
	
	public Autore(String Nome, String Cognome)
	{
		this.Nome = Nome;
		this.Cognome = Cognome;
	}
	
	public String getAutore()
	{
		return Nome + " " + Cognome;
	}
}
