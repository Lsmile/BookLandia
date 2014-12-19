package it.unisalento.BookLandia.model;

import it.unisalento.BookLandia.business.GestoreDati;
import it.unisalento.BookLandia.dao.RicercaDAO;

import java.util.Vector;

public class Ricerca {
	
	Vector<Libro> Libri = null;
	private static Ricerca instance;
	
	public static Ricerca getInstance(GestoreDati Dati) {
		// TODO Auto-generated method stub
		instance = null;
			   instance = new Ricerca(Dati);
		   return instance;
	}
	
	public Ricerca(GestoreDati dati)
	{
		Libri = RicercaDAO.getInstance().getLibri(dati);
	}
	
	public Vector<Libro> getRicerca()
	{
		return Libri;
	}

}
