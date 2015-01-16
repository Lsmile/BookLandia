package it.unisalento.BookLandia.business;

public class GestoreDati {
	String Titolo;
	String Genere;
	String Autore;
	String CasaEditrice;

	public String getTitolo() {
		return Titolo;
	}

	public String getGenere() {
		return Genere;
	}

	public String getAutore() {
		return Autore;
	}

	public String getCasaEditrice() {
		return CasaEditrice;
	}
	
	
	//costruttore per la ricerca
	public GestoreDati(String Titolo, String Genere, String Autore, String CasaEditrice)
	{
	this.Titolo = Titolo;
	this.Genere = Genere;
	this.Autore = Autore;
	this.CasaEditrice = CasaEditrice;
	}
	
	
}
