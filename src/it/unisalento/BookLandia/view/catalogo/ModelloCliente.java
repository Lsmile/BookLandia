package it.unisalento.BookLandia.view.catalogo;

import it.unisalento.BookLandia.dao.CatalogoDAO;
import it.unisalento.BookLandia.model.Catalogo;
import it.unisalento.BookLandia.model.Libro;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class ModelloCliente extends AbstractTableModel {
		Vector v = Catalogo.getInstance().getCatalogo();
		String[] ColName =  {"Titolo","Autore", "Genere", "Prezzo", "Casa Editrice",  "Copie Disponibili" }; 
		
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
			return CatalogoDAO.getInstance().getNumeroLibri();
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
			 case 5: 
				 {if (b.getCopieDisponibili() == 0)
				 return "Non Disponibile";
			 else return b.getCopieDisponibili();
				 }
			 default: return ""; 
		}
		}
}
