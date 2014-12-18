package it.unisalento.BookLandia.model;

import it.unisalento.BookLandia.dao.RicercaDAO;

import java.util.Vector;

public class Ricerca {
	
	Vector<Libro> Libri = null;
	private static Ricerca instance;
	
	public static Ricerca getInstance(String Dati) {
		// TODO Auto-generated method stub
		if(instance == null)
			   instance = new Ricerca(Dati);
		   return instance;
	}
	
	public Ricerca(String Dati)
	{
		Libri = RicercaDAO.getInstance().getLibri(Dati);
	}
	
	public Vector<Libro> getRicerca()
	{
		return Libri;
	}

}
