package Vendita;

import java.awt.GridLayout;

import it.unisalento.BookLandia.model.Libro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistraPanel extends JPanel {
	Libro LibroVendita;
	JButton Registra = new JButton("Registra Vendita");
	
private static RegistraPanel instance;
	
	public static RegistraPanel getInstance(Libro Lbr)
	{
		if(instance == null)
		{
			instance = new RegistraPanel(Lbr);
		}
		return instance;
	}
	
	public RegistraPanel(Libro LibroVnd)
	{
		this.LibroVendita = LibroVnd;
		this.setLayout(new GridLayout(7,0));
		this.add(new JLabel("Titolo : " + LibroVendita.getTitolo()));
		this.add(new JLabel("Autore: " + LibroVendita.getAutore()));
		this.add(new JLabel("Casa Editrice: " + LibroVendita.getCasa_Editrice()));
		this.add(new JLabel("Genere: " + LibroVendita.getGenere()));
		this.add(new JLabel("ISBN: " + LibroVendita.getISBN()));
		this.add(new JLabel("Prezzo: " + LibroVendita.getPrezzo()));
		this.add(Registra);
	}
}
