package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

import java.util.Vector;

public class ScaffaleDAO {
	private static ScaffaleDAO instance;
	
	public static ScaffaleDAO getInstance()
	{
		if(instance == null)
		{
			instance = new ScaffaleDAO();
		}
		return instance;
	}
	
	public Vector<String> getSettoriScaffali()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Settore FROM scaffali");
		Vector<String> listaSettori = new Vector<String>();
		for(int z = 0; z < risultato.size(); z++)
		{
			listaSettori.add(risultato.get(z)[0]);
		}
		return listaSettori;
	}
	
	public int getIdFromName(String name)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Id_Scaffale FROM scaffali where Settore = '"+name+"';");
		int id = Integer.parseInt(risultato.get(0)[0]);
		return id;
	}

	public void inserisciScaffale(String nome,int numeroScaffale, int numeroLibreria) {
		String query = "INSERT INTO `booklandia`.`scaffali` (`Settore`, `NumeroScaffale`, `ID_Scaffale`, `NumeroLibreria`) VALUES('"+nome+"','"+numeroScaffale+"','0','"+numeroLibreria+"');";
		DbConnection.getInstance().eseguiAggiornamento(query);
	}
	
	public int getPositionFromId(int id)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Scaffale FROM scaffali");
		for(int z = 0; z < risultato.size(); z++)
		{
			String p = String.valueOf(id);
			String k = risultato.get(z)[0];
			if(k.equalsIgnoreCase(p))
				return z;
		}
		return 0;
	}
	
}
