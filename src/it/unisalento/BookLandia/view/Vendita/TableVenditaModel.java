package it.unisalento.BookLandia.view.Vendita;



import it.unisalento.BookLandia.dao.VenditaDAO;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableVenditaModel extends AbstractTableModel {
	Vector<String[]> v = VenditaDAO.getInstance().getVenditeConUtente();
	Vector<String[]> a = VenditaDAO.getInstance().getVenditeAnonime();
	int NumeroVenditeConUtente = VenditaDAO.getInstance().getNumeroVenditeConUtente();
	int NumeroVenditeAnonime = VenditaDAO.getInstance().getNumeroVenditeAnonime();
	//Titolo, autori.nome,  utente.Nome, Utente.Cognome,  Data, Quantità
	String[] ColName =  {"Titolo","Autore","Acquirente","Data","Quantità", "Totale"}; 
	
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
		return NumeroVenditeConUtente + NumeroVenditeAnonime;
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
		if(riga < NumeroVenditeConUtente)
		{
		if(colonna == 2)
			return v.get(riga)[2] + " " +  v.get(riga)[3];
		if(colonna > 2)
			return v.get(riga)[colonna + 1];
		return v.get(riga)[colonna];
		}
		else
		{
			if (colonna < 2)
			return a.get(riga - NumeroVenditeConUtente)[colonna];
			if(colonna == 2)
				return " ";
			if(colonna > 2)
			return a.get(riga - NumeroVenditeConUtente)[colonna - 1];

		}
		return null;
		
			
		 // la stringa corrispondente alla colonna 
	}
}
