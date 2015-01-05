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
}
