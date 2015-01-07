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
	int Quantità;
	int ID;
	
	public Libro(String Titolo, Double Prezzo, String ISBN, int CopieDisponibili, String nome_autore, String casa_Editrice, String genere, String settore_scaffale, int numero_scaffale, int numero_libreria)
	{
		this.Titolo = Titolo;
		this.Prezzo = Prezzo;
		this.ISBN = ISBN;
		this.CopieDisponibili = CopieDisponibili;
		this.autore = new Autore(nome_autore);
		this.casa_Editrice = new Casa_Editrice(casa_Editrice);
		this.genere = new Genere(genere);
		this.scaffale = new Scaffale(settore_scaffale, numero_scaffale, numero_libreria);
	}
	
	public Libro(String Titolo, String Autore, String Casa_Editrice,  String genere,String ISBN, double Prezzo, int ID, int Quantità)
	{
		this.Titolo = Titolo;
		this.autore = new Autore(Autore);
		this.genere = new Genere(genere);
		this.casa_Editrice = new Casa_Editrice(Casa_Editrice);
		this.ISBN = ISBN;
		this.Prezzo = Prezzo;
		this.ID = ID;
		this.Quantità = Quantità;
	};
	
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
	
	public int getID()
	{
		return ID;
	}
	
	public int getQuantità()
	{
		return Quantità;
	}
}
