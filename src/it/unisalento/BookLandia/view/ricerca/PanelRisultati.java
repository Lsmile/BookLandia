package it.unisalento.BookLandia.view.ricerca;

import it.unisalento.BookLandia.model.Catalogo;
import it.unisalento.BookLandia.view.catalogo.ButtonPanel;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelRisultati extends JPanel {
	
	String Dati;
	private static PanelRisultati instance;
	
	public static PanelRisultati getInstance(String Dati) {
		   if(instance == null)
			   instance = new PanelRisultati(Dati);
		   return instance;
	   }
	
	
	public PanelRisultati(String Dati) { 
		//è importante che riceva l'istanza del pannello cerca per poterne prelevare le informazioni
		this.add(new JLabel("Risultati della ricerca"));
		  // crea il modello di dati 
		 RisultatiModel dataModel = new RisultatiModel(Dati); 
		  // crea la tabella 
		  JTable t = new JTable(dataModel); 

		  
		  // aggiunge la tabella ad uno ScollPane 
		 JScrollPane scrollpane = new JScrollPane(t); 
		 scrollpane.setPreferredSize(new Dimension(800,500));
		  // aggiunge lo ScrollPane alpannello 
		 add(scrollpane);   
		 
		 this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		 ButtonPanel b = new ButtonPanel();
		 b.addButton(t.getRowCount());
		 add(b);
		} 
}
