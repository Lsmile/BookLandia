package it.unisalento.BookLandia.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class VenditaDAO {
private static VenditaDAO instance;
	
	public static VenditaDAO getInstance()
	{
		instance = null;
			instance = new VenditaDAO();
		return instance;
	}
	
	public Vector<String[]> getLibro(int ID)
	{
		String query = "SELECT Titolo, autori.Nome, case_editrici.Nome, generi.Nome, ISBN, Prezzo "
					+ "FROM libri INNER JOIN autori ON Autori_Codice_Autore = Codice_Autore "
					+ "INNER JOIN case_Editrici ON Case_Editrici_ID_Casa_Editrice = ID_Casa_Editrice "
					+ "INNER JOIN generi ON Generi_Codice_Genere = Codice_Genere "
					+ "WHERE ID =" + ID + ";";
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery(query);
		return risultato;
	}
	
	public Vector<String[]> getUtente(int ID)
	{
		String query = "SELECT Nome, Cognome FROM utente where ID_Utente = '" + ID + "'";
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery(query);
		return risultato;
	}

	public void RegistraVendita(int quantità, int id) {
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println("Giorno: " + gc.get(Calendar.DAY_OF_MONTH) );
		System.out.println("Mese: " + gc.get(Calendar.MONTH) );
		System.out.println("Anno: " + gc.get(Calendar.YEAR) );
		String query = "INSERT INTO vendite (`Vendite_Codice_Vendita`, `ID_Cliente`, `Data`, `Quantità`, `Libri_ID`) VALUES (0,"
				+ " '4', '"
				+ gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH)+"'," +
				"'" + quantità +"'," +  "'" + id + "');";
		DbConnection.getInstance().eseguiAggiornamento(query);
		
	}

	public void RegistraVendita(int quantità, int id, int idCliente) {
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println("Giorno: " + gc.get(Calendar.DAY_OF_MONTH) );
		System.out.println("Mese: " + gc.get(Calendar.MONTH) );
		System.out.println("Anno: " + gc.get(Calendar.YEAR) );
		String query = "INSERT INTO vendite (`Vendite_Codice_Vendita`, `ID_Cliente`, `Data`, `Quantità`, `Libri_ID`) VALUES (0,"
				+ " '" + idCliente + "', '"
				+ gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH)+"'," +
				"'" + quantità +"'," +  "'" + id + "');";
		DbConnection.getInstance().eseguiAggiornamento(query);
	}
	
}
