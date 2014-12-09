package it.unisalento.BookLandia.model;

import it.unisalento.BookLandia.dao.CatalogoDAO;

import java.util.Vector;

public class Catalogo {
	Vector<Libro> Libri = null;
	
	public Catalogo()
	{
		Libri = CatalogoDAO.getInstance().getLibri();
	}
}
