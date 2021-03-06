package it.unisalento.BookLandia.view.catalogo;

import it.unisalento.BookLandia.view.ordini.ButtonPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
		 
		 
		 
		 this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		 ButtonPanel b = new ButtonPanel(t);
		 b.addButton(t.getRowCount());
		 add(b);
		} 

}
