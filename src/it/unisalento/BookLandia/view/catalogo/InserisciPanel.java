package it.unisalento.BookLandia.view.catalogo;

import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InserisciPanel extends JPanel {
	JLabel titoloLabel;
	JTextField titoloTextField;
	
	JLabel prezzoLabel;
	JFormattedTextField prezzoTextField;
	
	JLabel ISBNLabel;
	JTextField ISBNTextField;
	
	JLabel CopieLabel;
	JTextField CopieTextField;
	
	JLabel autoreLabel;
	JTextField autoreTextField;
	
	JLabel genereLabel;
	JTextField genereTextField;
	
	JLabel casaEditriceLabel;
	JTextField casaEditriceTextField;
	
	JButton inserisci;
	
	NumberFormat formatoPrezzo;
	NumberFormat formatoISBN;
	
	public InserisciPanel()
	{

		formatoPrezzo = NumberFormat.getNumberInstance();
		formatoPrezzo.setMinimumFractionDigits(2);
		formatoPrezzo.setMaximumFractionDigits(2);
		
		formatoISBN = NumberFormat.getIntegerInstance();
		formatoISBN.setMinimumIntegerDigits(13);
		formatoISBN.setMaximumIntegerDigits(13);
		
		titoloLabel = new JLabel("Titolo");
		titoloTextField = new JTextField();
		
		prezzoLabel = new JLabel("Prezzo");
		prezzoTextField = new JFormattedTextField(formatoPrezzo);
		
		ISBNLabel = new JLabel("ISBN");
		ISBNTextField = new JTextField();
		
		CopieLabel = new JLabel("Copie Disponibili");
		CopieTextField = new JTextField();
		
		autoreLabel = new JLabel("Autore");
		autoreTextField = new JTextField();
		
		genereLabel = new JLabel("Genere");
		genereTextField = new JTextField();
		
		casaEditriceLabel = new JLabel("Casa Editrice");
		casaEditriceTextField = new JTextField();
		
		inserisci = new JButton("Inserisci");
		
		
		
		this.setLayout(new GridLayout(8,2));
		add(titoloLabel);
		add(titoloTextField);
		add(prezzoLabel);
		add(prezzoTextField);
		add(ISBNLabel);
		add(ISBNTextField);
		add(CopieLabel);
		add(CopieTextField);
		add(autoreLabel);
		add(autoreTextField);
		add(genereLabel);
		add(genereTextField);
		add(casaEditriceLabel);
		add(casaEditriceTextField);
		
		add(inserisci);
	}
}
