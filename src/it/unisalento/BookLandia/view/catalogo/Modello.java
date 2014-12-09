package it.unisalento.BookLandia.view.catalogo;

import java.util.Vector;

import it.unisalento.BookLandia.dao.CatalogoDAO;
import it.unisalento.BookLandia.model.Libro;

import javax.swing.table.AbstractTableModel;

public class Modello extends AbstractTableModel {
	Vector v = null;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return CatalogoDAO.getColonne();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return CatalogoDAO.getNumber();
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		// TODO Auto-generated method stub
		// seleziona il libro
		Libro b = (Libro) v.elementAt(riga); 
		 // la stringa corrispondente alla colonna 
		 switch (colonna){    
		 case 0: return b.title;    
		 case 1: return b.author;    
		 case 2:return b.quantity;
		  case 3: return b.price; 
		  case 4: return b.price * b.quantity; 
		  default: return ""; 
	}
	}

}
