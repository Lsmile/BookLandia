package it.unisalento.BookLandia.view.ordini;

import java.util.Vector;

import it.unisalento.BookLandia.dao.OrdiniDAO;

import javax.swing.table.AbstractTableModel;

public class ModelloTabellaOrdine extends AbstractTableModel {
	
	Vector<String[]> Dati = OrdiniDAO.getOrdinazioni();
	String[] ColName =  {"ID","Titolo" ,"Autore", "Prezzo", "Nome", "Cognome", "Data Richiesta", "Data Arrivo", "Data Completamento", "Stato" }; 
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ColName.length;
	}
	
	public String getColumnName(int col) { 
		 return ColName[col]; 
		} 

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return OrdiniDAO.getNumeroRecord();
	}

	@Override
	public Object getValueAt(int Riga, int Colonna) {
		// TODO Auto-generated method stub
		//colonna in cui è espresso lo stato registrato in DB come un intero
		if(Colonna == 9)
		{
			if (Integer.parseInt(Dati.get(Riga)[9]) == 0)
				return "In corso";
			if (Integer.parseInt(Dati.get(Riga)[9]) == 1)
				return "Completato";
		}
		return Dati.get(Riga)[Colonna];
	}

}
