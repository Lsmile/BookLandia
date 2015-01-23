package it.unisalento.BookLandia.dao;

import java.util.Vector;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class LibroDAO {
	private static LibroDAO instance;
	
	public static LibroDAO getInstance()
	{
		if(instance == null)
		{
			instance = new LibroDAO();
		}
		return instance;
	}
	
	public int getNumLibri()
	{
		String query = "SELECT * from libri";
		Vector<String[]> risultati = DbConnection.getInstance().eseguiQuery(query);
		return risultati.size();
	}
	
	public String[] getLibro(int id)
	{
		String query = "SELECT * from libri where ID = "+id+";";
		Vector<String[]> risultati = DbConnection.getInstance().eseguiQuery(query);
		return risultati.get(0);
	}
	
	public void InserisciLibro(String titolo, float prezzo, String ISBN, int Copie, int idAutore, int idGenere, int idCasaEditrice, int idScaffale)
	{
		DbConnection.getInstance().eseguiAggiornamento("INSERT INTO `booklandia`.`libri` (`Titolo`, `Prezzo`, `ID`, `ISBN`, `Case_Editrici_ID_Casa_Editrice`, `Generi_Codice_Genere`, `Autori_Codice_Autore`, `CopieDisponibili`, `Scaffali_ID_Scaffale`) VALUES ('"+titolo+"', '"+prezzo+"', '0' , '"+ISBN+"', '"+idCasaEditrice+"', '"+idGenere+"', '"+idAutore+"', '"+Copie+"', '"+idScaffale+"');");
	}
	
	public void modificaLibro(int id, String titolo, float prezzo, String ISBN, int Copie, int idAutore, int idGenere, int idCasaEditrice, int idScaffale)
	{
		String query = "update libri set titolo = '"+titolo+"', prezzo ="+prezzo+" , ISBN = '"+ISBN+"', Case_Editrici_ID_Casa_Editrice = "+idCasaEditrice+", Generi_Codice_Genere = "+idGenere+", Autori_Codice_Autore = "+idAutore+",CopieDisponibili = "+Copie+",Scaffali_ID_Scaffale = "+idScaffale+" where id = "+id;
		DbConnection.getInstance().eseguiAggiornamento(query);
	}
}
