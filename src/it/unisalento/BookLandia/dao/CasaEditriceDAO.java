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
	
	public int getIdFromName(String name)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Id_Casa_Editrice FROM case_editrici where Nome = '"+name+"';");
		int id = Integer.parseInt(risultato.get(0)[0]);
		return id;
	}

	public int getPositionFromId(int id)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Casa_Editrice FROM case_editrici");
		for(int z = 0; z < risultato.size(); z++)
		{
			String p = String.valueOf(id);
			String k = risultato.get(z)[0];
			if(k.equalsIgnoreCase(p))
				return z;
		}
		return 0;
	}
	
	
	public void inserisciGenere(String nome) {
		DbConnection.getInstance().eseguiAggiornamento("INSERT INTO `booklandia`.`case_editrici` (`Nome`, `ID_Casa_Editrice`) VALUES ('"+nome+"', 0);");
		
	}
}
