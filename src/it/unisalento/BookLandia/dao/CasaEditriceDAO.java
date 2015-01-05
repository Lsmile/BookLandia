package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

import java.util.Vector;

public class CasaEditriceDAO {
	private static CasaEditriceDAO instance;
	
	public static CasaEditriceDAO getInstance()
	{
			if(instance == null)
			{
				instance = new CasaEditriceDAO();
			}
		return instance;
	}
	
	public Vector<String> getNomiCaseEditrici()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Nome FROM case_editrici");
		Vector<String> listaCaseEditrici = new Vector<String>();
		for(int z = 0; z < risultato.size(); z++)
		{
			listaCaseEditrici.add(risultato.get(z)[0]);
		}
		return listaCaseEditrici;
	}
}
