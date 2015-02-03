package it.unisalento.BookLandia.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.enums.UserType;

public class OrdiniDAO {
	
	public static OrdiniDAO instance;
	
	public static OrdiniDAO getInstance()
	{
		instance = null;
			instance = new OrdiniDAO();
		return instance;
		
	}
	
	public int getNumeroRecord()
	{
		String query = "SELECT COUNT(*) from ordinazioni";
		if (UserManager.getInstance().getUtente_connesso() == UserType.CLIENTE)
		{
			query += " INNER JOIN utente ON ID_Utente = Cliente_Utente_ID_Utente where ID_Utente = " + UserManager.getInstance().getCurUser().getID();
		}
		return Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]);
	}
	
	public Vector<String[]> getOrdinazioni()
	{
		String query = "SELECT ID_Ordinazione, libri.Titolo, autori.Nome, libri.Prezzo, "
						+ "utente.Nome, utente.Cognome, Data_Inserimento, Data_Completato, Data_Consegna, Stato "
						+ " FROM ordinazioni INNER JOIN libri ON Libri_ID = ID INNER JOIN autori ON Autori_Codice_Autore = Codice_Autore "
						+ "INNER JOIN utente ON ID_Utente = Cliente_Utente_ID_Utente";
		if (UserManager.getInstance().getUtente_connesso() == UserType.CLIENTE)
		{
			query += " where ID_Utente = " + UserManager.getInstance().getCurUser().getID();
		}
			
		return DbConnection.getInstance().eseguiQuery(query);
		
	}
	
	public boolean insertOrdinazione(int idLibro)
	{
		int idCliente = UserManager.getInstance().getCurUser().getID();
		DateFormat sqlFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String curDate = sqlFormatDate.format(date);
		String query = "INSERT INTO `booklandia`.`ordinazioni` (`ID_Ordinazione`, `Stato`, `Data_Inserimento`, `Cliente_Utente_ID_Utente`, `Data_Completato`,"
				+"`Data_Consegna`, `Libri_ID`) VALUES (0, '0', '"+curDate+"', "+idCliente+", NULL, NULL, "+idLibro+");";
		return DbConnection.getInstance().eseguiAggiornamento(query);
	}
	
}
