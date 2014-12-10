package it.unisalento.BookLandia.model;

public class Libro {
	String Titolo = null;
	Double Prezzo;
	String ISBN;
	int CopieDisponibili;
	Autore autore;
	Casa_Editrice casa_Editrice;
	Genere genere;
	Scaffale scaffale;
	
	public Libro(String Titolo, Double Prezzo, String ISBN, int CopieDisponibili, String nome_autore, String cognome_autore, String casa_Editrice, String genere, String settore_scaffale, int numero_scaffale, int numero_libreria)
	{
		this.Titolo = Titolo;
		this.Prezzo = Prezzo;
		this.ISBN = ISBN;
		this.CopieDisponibili = CopieDisponibili;
		this.autore = new Autore(nome_autore,cognome_autore);
		this.casa_Editrice = new Casa_Editrice(casa_Editrice);
		this.genere = new Genere(genere);
		this.scaffale = new Scaffale(settore_scaffale, numero_scaffale, numero_libreria);
	}
	
	public String getTitolo() {
		return Titolo;
	}

	public Double getPrezzo() {
		return Prezzo;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getCopieDisponibili() {
		return CopieDisponibili;
	}

	public String getAutore() {
		return autore.getAutore();
	}

	public String getCasa_Editrice() {
		return casa_Editrice.getCasa_Editrice();
	}

	public String getGenere() {
		return genere.getGenere();
	}

	public Scaffale getScaffale() {
		return scaffale;
	}
}
