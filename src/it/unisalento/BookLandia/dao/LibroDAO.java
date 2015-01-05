package it.unisalento.BookLandia.dao;

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
	
	public void InserisciLibro(String titolo, float prezzo, String ISBN, int Copie, int idAutore, int idGenere, int idCasaEditrice, int idScaffale)
	{
		DbConnection.getInstance().eseguiQuery("INSERT INTO `booklandia`.`libri` (`Titolo`, `Prezzo`, `ISBN`, `Case_Editrici_ID_Casa_Editrice`, `Generi_Codice_Genere`, `Autori_Codice_Autore`, `CopieDisponibili`, `Scaffali_ID_Scaffale`) VALUES ('"+titolo+"', '"+prezzo+"', '"+ISBN+"', '"+idCasaEditrice+"', '"+idGenere+"', '"+idAutore+"', '"+Copie+"', '"+idScaffale+"');");
	}
}
