package it.unisalento.BookLandia.view.ordini;

import it.unisalento.BookLandia.view.catalogo.ButtonPanel;
import it.unisalento.BookLandia.view.catalogo.ModelloCliente;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaOrdini extends JPanel {
	public VistaOrdini()
	{
	// crea il modello di dati 
			 ModelloTabellaOrdine dataModel = new ModelloTabellaOrdine(); 
			  // crea la tabella 
			  JTable t = new JTable(dataModel); 

			  
			  // aggiunge la tabella ad uno ScollPane 
			 JScrollPane scrollpane = new JScrollPane(t); 
			 scrollpane.setPreferredSize(new Dimension(800,500));
			  // aggiunge lo ScrollPane alpannello 
			 add(scrollpane);   
			 
			 this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
			 ButtonPanel b = new ButtonPanel(t); // andrà creato un altro pannello simile però con cancella e modifica
			 b.addButton(t.getRowCount());
			 add(b);
}
}
