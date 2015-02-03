package it.unisalento.BookLandia.view.Vendita;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unisalento.BookLandia.listener.VenditaListener;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.ricerca.CampiTesto;

public class RegistraVenditaPanel extends JPanel {
	CampiTesto IdLibro = new CampiTesto();
	CampiTesto IdCliente = new CampiTesto();
	CampiTesto Quantit‡ = new CampiTesto();
	JLabel IdLibroLbl = new JLabel("Id Libro");
	JLabel IdClienteLbl = new JLabel ("Id Cliente (Opzionale)");
	JLabel Quantit‡Lbl = new JLabel ("Quantit‡");
	JButton Avanti = new JButton("Avanti");
	
	
	public RegistraVenditaPanel(MainFrame finestra)
	{
		super();
		VenditaListener listener = new VenditaListener(this, finestra);
		this.setLayout(new GridLayout(4,2));
		this.add(IdLibroLbl);
		this.add(IdLibro);
		this.add(IdClienteLbl);
		this.add(IdCliente);
		this.add(Quantit‡Lbl);
		this.add(Quantit‡);
		Avanti.setName("Avanti");
		this.add(Avanti);
		Avanti.addActionListener(listener);
		
	}
	
	public int getLibroID()
	{
		if (IdLibro.getText().compareTo("") == 0)
			return 0;
		else
		return Integer.parseInt(IdLibro.getText());
	}
	
	public int getUtenteID()
	{
		if(IdCliente.getText().compareTo("") == 0)
		{
			return 0;
		}
		else
		return Integer.parseInt(IdCliente.getText());
		
	}
	
	public int getQuantit‡()
	{
		if (Quantit‡.getText().compareTo("") == 0)
			return 0;
		else
		try
		{
		return Integer.parseInt(Quantit‡.getText());
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Quantit‡ di libri richiesta non supportata");
			return 0;
		}
		
	}
	

}
