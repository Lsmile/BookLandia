package it.unisalento.BookLandia.view.catalogo;

import java.util.Vector;

import it.unisalento.BookLandia.model.Catalogo;
import it.unisalento.BookLandia.model.Libro;

import javax.swing.table.AbstractTableModel;

public class Modello extends AbstractTableModel {
	Vector v = Catalogo.getInstance().getCatalogo();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		// TODO Auto-generated method stub
		// seleziona il libro
		Libro b = (Libro) v.elementAt(riga); 
		 // la stringa corrispondente alla colonna 
		 switch (colonna){    
		 case 0: return b.getTitolo();  
		 case 1: return b.getAutore();
		 case 2: return b.getCopieDisponibili();
		 case 3: return b.getPrezzo();
		 case 4: return b.getCasa_Editrice();
		 case 5: return b.getGenere();
		 default: return ""; 
	}
	}

}
