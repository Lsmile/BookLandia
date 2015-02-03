package it.unisalento.BookLandia.model;

import it.unisalento.BookLandia.dao.CatalogoDAO;

import java.util.Vector;

public class Catalogo {
	Vector<Libro> Libri = null;
	private static Catalogo instance;
	
	public Catalogo()
	{
		Libri = CatalogoDAO.getInstance().getLibri();
	}
	
	public Vector<Libro> getCatalogo()
	{
		return Libri;
	}
	
	public static Catalogo getInstance() {
		   instance = null;
			   instance = new Catalogo();
		   return instance;
	   }
	
	
}
