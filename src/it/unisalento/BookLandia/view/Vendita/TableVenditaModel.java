package it.unisalento.BookLandia.view.Vendita;



import it.unisalento.BookLandia.dao.VenditaDAO;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableVenditaModel extends AbstractTableModel {
	Vector<String[]> v = VenditaDAO.getInstance().getVendite();
	//Titolo, autori.nome,  utente.Nome, Utente.Cognome,  Data, Quantità
	String[] ColName =  {"Titolo","Autore","Acquirente","Data","Quantità"}; 
	
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
		return VenditaDAO.getInstance().getNumeroVendite() - 1;
	}
	
	/** ritorna il tipo dei valori
	 * serve per allineare correttamente i numeri */
	 public Class getColumnClass(int col) {
	 return getValueAt(0, col).getClass();
	 }

	@Override
	public String getValueAt(int riga, int colonna) {
		// TODO Auto-generated method stub
		// seleziona il libro
		return v.get(riga)[colonna];
		 // la stringa corrispondente alla colonna 
	}
}
