package it.unisalento.BookLandia.view.ricerca;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCerca extends JPanel {
	
	JLabel Titolo = new JLabel("Titolo");
	CampiTesto TitoloTxt = new CampiTesto();
	JLabel Autore = new JLabel("Autore");
	CampiTesto AutoreTxt = new CampiTesto();
	JLabel Casa_Editrice = new JLabel("Casa Editrice");
	CampiTesto Casa_EditriceTxt = new CampiTesto();
	JLabel Genere = new JLabel("Genere");
	CampiTesto GenereTxt = new CampiTesto();
	JButton Cerca = new JButton("Cerca");
	
	public PanelCerca(){
		super();
		this.setLayout(new GridLayout(5,2));
		this.add(Titolo);
		this.add(TitoloTxt);
		this.add(Autore);
		this.add(AutoreTxt);
		this.add(Casa_Editrice);
		this.add(Casa_EditriceTxt);
		this.add(Genere);
		this.add(GenereTxt);
		this.add(Cerca);
		
	}
}
