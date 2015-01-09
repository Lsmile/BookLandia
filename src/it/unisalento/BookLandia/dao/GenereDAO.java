package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

import java.util.Vector;

public class GenereDAO {
	private static GenereDAO instance;
	
	public static GenereDAO getInstance()
	{
		if(instance == null)
		{
			instance = new GenereDAO();
		}
		return instance;
	}
	
	public Vector<String> getNomiGeneri()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Nome FROM generi");
		Vector<String> listaGeneri = new Vector<String>();
		for(int z = 0; z < risultato.size(); z++)
		{
			listaGeneri.add(risultato.get(z)[0]);
		}
		return listaGeneri;
		
	}
	
	public int getIdFromName(String name)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Codice_Genere FROM generi where Nome = '"+name+"';");
		int id = Integer.parseInt(risultato.get(0)[0]);
		return id;
	}
	
	public void inserisciGenere(String nome)
	{
		DbConnection.getInstance().eseguiAggiornamento("INSERT INTO `booklandia`.`generi` (`Nome`, `Codice_Genere`) VALUES ('"+nome+"', 0);");
	}
}
