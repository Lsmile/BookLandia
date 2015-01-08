package Vendita;

import java.awt.GridLayout;

import it.unisalento.BookLandia.listener.VenditaListener;
import it.unisalento.BookLandia.model.Libro;
import it.unisalento.BookLandia.model.Utente;
import it.unisalento.BookLandia.view.MainFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistraPanel extends JPanel {
	Libro LibroVendita;
	VenditaListener Listener;
	
	JButton Registra = new JButton("Registra Vendita");
	
private static RegistraPanel instance;
	
	public static RegistraPanel getInstance(Libro Lbr, MainFrame finestra)
	{
		instance = null;
			instance = new RegistraPanel(Lbr, finestra);
		return instance;
	}
	
	public RegistraPanel(Libro LibroVnd, MainFrame finestra)
	{
		this.LibroVendita = LibroVnd;
		Listener = new VenditaListener(LibroVnd, finestra);
		this.setLayout(new GridLayout(5,2));
		this.add(new JLabel("Titolo : " + LibroVendita.getTitolo()));
		this.add(new JLabel("Autore: " + LibroVendita.getAutore()));
		this.add(new JLabel("Casa Editrice: " + LibroVendita.getCasa_Editrice()));
		this.add(new JLabel("Genere: " + LibroVendita.getGenere()));
		this.add(new JLabel("ISBN: " + LibroVendita.getISBN()));
		this.add(new JLabel("Prezzo: " + LibroVendita.getPrezzo()));
		this.add(new JLabel("Quantità acquistata: " + LibroVendita.getQuantità()));
		this.add(new JLabel("Totale: " + LibroVendita.getPrezzo() * LibroVendita.getQuantità() + "€"));
		Registra.setName("Registra");
		Registra.addActionListener(Listener);
		this.add(Registra);
	}

	public RegistraPanel(Libro LibroVendita, Utente buyUser, MainFrame finestra) {
		this.setLayout(new GridLayout(7,1));
		Listener = new VenditaListener(LibroVendita, buyUser, finestra);
		this.add(new JLabel("Titolo : " + LibroVendita.getTitolo()));
		this.add(new JLabel("Autore: " + LibroVendita.getAutore()));
		this.add(new JLabel("Casa Editrice: " + LibroVendita.getCasa_Editrice()));
		this.add(new JLabel("Genere: " + LibroVendita.getGenere()));
		this.add(new JLabel("ISBN: " + LibroVendita.getISBN()));
		this.add(new JLabel("Prezzo: " + LibroVendita.getPrezzo()));	
		this.add(new JLabel("Acquirente: "+buyUser.getNome() + " " + buyUser.getCognome()));
		this.add(new JLabel("Quantità acquistata: " + LibroVendita.getQuantità()));
		this.add(new JLabel("Totale: " + LibroVendita.getPrezzo() * LibroVendita.getQuantità() + "€"));
		Registra.setName("Registra");
		Registra.addActionListener(Listener);
		this.add(Registra);
		
	}

	public static RegistraPanel getInstance(Libro libroVendita, Utente buyUser, MainFrame finestra) {
		{
			instance = null;
				instance = new RegistraPanel(libroVendita, buyUser, finestra);
			return instance;
	}
}
}
