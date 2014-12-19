package it.unisalento.BookLandia.view.ricerca;

import it.unisalento.BookLandia.dao.CatalogoDAO;
import it.unisalento.BookLandia.dao.RicercaDAO;
import it.unisalento.BookLandia.model.Catalogo;
import it.unisalento.BookLandia.model.Libro;
import it.unisalento.BookLandia.model.Ricerca;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class RisultatiModel extends AbstractTableModel {
	String[] ColName =  {"Titolo","Autore", "Prezzo", "Casa Editrice", "Genere", "Copie Disponibili" };
	Vector v =  new Vector();
	String Dati;
	
	
	public RisultatiModel(String Dati)
	{
		this.Dati = Dati;
		v = null;
		v =  Ricerca.getInstance(Dati).getRicerca();
	}
	
	/** ritorna il nome della colonna */ 
	public String getColumnName(int col) { 
	 return ColName[col]; 
	} 

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ColName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return RicercaDAO.getInstance().getNumeroLibri(Dati);
	}
	
	/** ritorna il tipo dei valori
	 * serve per allineare correttamente i numeri */
	 public Class getColumnClass(int col) {
	 return getValueAt(0, col).getClass();
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
		 case 2: return b.getGenere();
		 case 3: return b.getPrezzo();
		 case 4: return b.getCasa_Editrice();
		 case 5: return b.getCopieDisponibili();
		 default: return ""; 
	}
	}

}
