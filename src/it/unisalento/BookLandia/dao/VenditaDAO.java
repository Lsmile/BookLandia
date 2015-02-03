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
		String query = "INSERT INTO vendite (`Vendite_Codice_Vendita`, `ID_Cliente`, `Data`, `Quantità`, `Libri_ID`) VALUES (0,"
				+ " NULL, '"
				+ gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH)+"'," +
				"'" + quantità +"'," +  "'" + id + "');";
		DbConnection.getInstance().eseguiAggiornamento(query);
		
	}

	public void RegistraVendita(int quantità, int id, int idCliente) {
		GregorianCalendar gc = new GregorianCalendar();
		String query = "INSERT INTO vendite (`Vendite_Codice_Vendita`, `ID_Cliente`, `Data`, `Quantità`, `Libri_ID`) VALUES (0,"
				+ " '" + idCliente + "', '"
				+ gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH)+"'," +
				"'" + quantità +"'," +  "'" + id + "');";
		DbConnection.getInstance().eseguiAggiornamento(query);
	}
	
	public int getNumeroVenditeConUtente()
	{
		String query = "Select COUNT(*) FROM vendite INNER JOIN utente ON vendite.ID_Cliente = utente.ID_Utente;";
		return Integer.parseInt((DbConnection.getInstance().eseguiQuery(query).get(0)[0]));
			
	}
	
	public int getNumeroVenditeAnonime()
	{
		String query = "Select COUNT(*) FROM vendite where ID_Cliente IS NULL;";
		return Integer.parseInt((DbConnection.getInstance().eseguiQuery(query).get(0)[0]));
			
	}
	
	public Vector<String[]> getVenditeConUtente()
	{
		String query ="SELECT Titolo, autori.nome,  utente.Nome, Utente.Cognome,  Data, Quantità FROM libri INNER JOIN autori ON Codice_Autore = Autori_Codice_Autore INNER JOIN vendite ON ID = Libri_ID INNER JOIN utente ON vendite.ID_Cliente = utente.ID_Utente;";
		return DbConnection.getInstance().eseguiQuery(query);
	}
	
	public Vector<String[]> getVenditeAnonime()
	{
		String query ="SELECT Titolo, autori.nome, Data, Quantità FROM libri INNER JOIN autori ON Codice_Autore = Autori_Codice_Autore INNER JOIN vendite ON ID = Libri_ID where ID_Cliente IS NULL";
		return DbConnection.getInstance().eseguiQuery(query);
	}
}
