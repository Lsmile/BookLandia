package it.unisalento.BookLandia.view.ricerca;

import it.unisalento.BookLandia.business.GestoreDati;
import it.unisalento.BookLandia.listener.CercaListener;
import it.unisalento.BookLandia.view.MainFrame;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCerca extends JPanel {
	
	//è necessario che il pannello conservi l'istenza della finestra principale per poter far apparire la ricerca effettuata
	MainFrame source;
	
	//stato interno
	
	
	
	JLabel Titolo = new JLabel("Titolo");
	CampiTesto TitoloTxt = new CampiTesto();
	JLabel Autore = new JLabel("Autore");
	CampiTesto AutoreTxt = new CampiTesto();
	JLabel Casa_Editrice = new JLabel("Casa Editrice");
	CampiTesto Casa_EditriceTxt = new CampiTesto();
	JLabel Genere = new JLabel("Genere");
	CampiTesto GenereTxt = new CampiTesto();
	JButton Cerca = new JButton("Cerca");
	
	public PanelCerca(MainFrame source){
		super();
		
		TitoloTxt.setText("");
		AutoreTxt.setText("");
		
		CercaListener Listener = new CercaListener(source, this);
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
		Cerca.addActionListener(Listener);
		
	}
	
	public GestoreDati getInfo()
	{
		return new GestoreDati(TitoloTxt.getText(),GenereTxt.getText(), AutoreTxt.getText(), Casa_EditriceTxt.getText());
	}
}
