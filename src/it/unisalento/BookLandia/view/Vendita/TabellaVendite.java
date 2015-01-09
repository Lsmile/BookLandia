package it.unisalento.BookLandia.view.Vendita;

import it.unisalento.BookLandia.dao.VenditaDAO;
import it.unisalento.BookLandia.view.catalogo.ButtonPanel;
import it.unisalento.BookLandia.view.catalogo.ModelloCliente;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabellaVendite extends JPanel {
	ScrollPanelTabella Table = new ScrollPanelTabella();
	int NumeroVendite;
	Vector<String[]> VettoreInfo = new Vector<String[]>();
	public TabellaVendite()
	{
		// crea il modello di dati 
				 TableVenditaModel dataModel = new TableVenditaModel(); 
				  // crea la tabella 
				  JTable t = new JTable(dataModel); 

				  
				  // aggiunge la tabella ad uno ScollPane 
				 JScrollPane scrollpane = new JScrollPane(t); 
				 scrollpane.setPreferredSize(new Dimension(800,500));
				  // aggiunge lo ScrollPane alpannello 
				 add(scrollpane);   
		
	}
}
