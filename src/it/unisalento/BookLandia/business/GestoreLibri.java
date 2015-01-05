package it.unisalento.BookLandia.business;

import it.unisalento.BookLandia.dao.LibroDAO;
import it.unisalento.BookLandia.dbinterface.DbConnection;

public class GestoreLibri {
	private static GestoreLibri instance;
	
	public static GestoreLibri getInstance()
	{
		if(instance == null)
		{
			instance = new GestoreLibri();
		}
		return instance;
		
	}
	
	public void InserisciLibro(String titolo, float prezzo, String ISBN, int Copie, int idAutore, int idGenere, int idCasaEditrice, int idScaffale)
	{
		LibroDAO.getInstance().InserisciLibro(titolo, prezzo, ISBN, Copie, idAutore, idGenere, idCasaEditrice, idScaffale);
	}
}
