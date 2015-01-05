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
}
