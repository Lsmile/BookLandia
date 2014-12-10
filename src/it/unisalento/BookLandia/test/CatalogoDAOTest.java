package it.unisalento.BookLandia.test;

import java.util.Vector;

import it.unisalento.BookLandia.dao.CatalogoDAO;
import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.model.Libro;

public class CatalogoDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Vector<Libro> v = CatalogoDAO.getInstance().getLibri();
//		String query = "SELECT Titolo, Prezzo, ISBN, CopieDisponibili,"
//				+ " Autori.Nome as Nome_Autore, Autori.Cognome as Cognome_Autore,"
//				+ " Case_Editrici.Nome as Casa_Editrice, Generi.Nome from Libri"
//				+ " INNER JOIN Generi ON Generi_Codice_Genere = Codice_Genere"
//				+ " INNER JOIN Case_Editrici ON Case_Editrici_ID_Casa_Editrice = ID_Casa_Editrice"
//				+ " INNER JOIN Autori ON Autori_Codice_Autore = Codice_Autore";
//		Vector<String[]> v = new Vector<String[]>();
//		v = DbConnection.getInstance().eseguiQuery(query);
//		System.out.println(v.get(1)[7]);
			
			
	}

}
