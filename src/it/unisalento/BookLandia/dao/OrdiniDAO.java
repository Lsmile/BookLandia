package it.unisalento.BookLandia.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.dbinterface.DbConnection;

public class OrdiniDAO {
	
	public static int getNumeroRecord()
	{
		String query = "SELECT COUNT(*) from ordinazioni";
		return Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]);
	}
	
	public static Vector<String[]> getOrdinazioni()
	{
		String query = "SELECT ID_Ordinazione, libri.Titolo, autori.Nome, libri.Prezzo, "
						+ "utente.Nome, utente.Cognome, Data_Inserimento, Data_Completato, Data_Consegna, Stato "
						+ " FROM ordinazioni INNER JOIN libri ON Libri_ID = ID INNER JOIN autori ON Autori_Codice_Autore = Codice_Autore "
						+ "INNER JOIN utente ON ID_Utente = Cliente_Utente_ID_Utente";
		return DbConnection.getInstance().eseguiQuery(query);
		
	}
	
	public static boolean insertOrdinazione(int idLibro)
	{
		int idCliente = UserManager.getInstance().getCurUser().getID();
		DateFormat sqlFormatDate = new SimpleDateFormat("yyyy-mm-gg");
		Date date = new Date();
		String curDate = sqlFormatDate.format(date);
		String query = "INSERT INTO `booklandia`.`ordinazioni` (`ID_Ordinazione`, `Stato`, `Data_Inserimento`, `Cliente_Utente_ID_Utente`, `Data_Completato`,"
				+"`Data_Consegna`, `Libri_ID`) VALUES (0, '0', "+curDate+", "+idCliente+", NULL, NULL, "+idLibro+");";
		return DbConnection.getInstance().eseguiAggiornamento(query);
	}
	
}
