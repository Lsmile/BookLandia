package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

import java.util.Vector;

public class AutoreDAO {
	private static AutoreDAO instance;
	
	public static AutoreDAO getInstance()
	{
		if(instance == null)
		{
			instance = new AutoreDAO();
		}
		return instance;
	}
	
	public Vector<String> getNomiAutori()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Nome FROM autori");
		Vector<String> listaAutori = new Vector<String>();
		for(int z = 0; z < risultato.size(); z++)
		{
			listaAutori.add(risultato.get(z)[0]);
		}
		return listaAutori;
		
	}
	
	public int getIdFromName(String name)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Codice_Autore FROM autori where Nome = '"+name+"';");
		int id = Integer.parseInt(risultato.get(0)[0]);
		return id;
	}
	
	public void inserisciAutore(String nome)
	{
		DbConnection.getInstance().eseguiAggiornamento("INSERT INTO `booklandia`.`autori` (`Nome`, `Codice_Autore`) VALUES ('"+nome+"', 0);");
	}
}
