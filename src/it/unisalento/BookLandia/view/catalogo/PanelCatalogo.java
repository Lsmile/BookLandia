package it.unisalento.BookLandia.view.catalogo;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class PanelCatalogo extends JPanel {
	public PanelCatalogo() { 
		  // crea il modello di dati 
		 ModelloCliente dataModel = new ModelloCliente(); 
		  // crea la tabella 
		  JTable t = new JTable(dataModel); 

		  
		  // aggiunge la tabella ad uno ScollPane 
		 JScrollPane scrollpane = new JScrollPane(t); 
		 scrollpane.setPreferredSize(new Dimension(800,500));
		  // aggiunge lo ScrollPane alpannello 
		 add(scrollpane);   
		} 

}
