package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.VenditaDAO;
import it.unisalento.BookLandia.model.Libro;
import it.unisalento.BookLandia.model.Utente;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.Vendita.RegistraVenditaPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VenditaListener implements ActionListener {
	Libro LibroVendita;
	Utente buyUser;
	RegistraVenditaPanel source;
	MainFrame finestra;
	
	public VenditaListener(RegistraVenditaPanel source, MainFrame finestra)
	{
		this.source = source;
		this.finestra = finestra;
	}
	
	

	public VenditaListener(Libro LibroVendita, MainFrame finestra) {
		this.LibroVendita = LibroVendita;
		this.finestra = finestra;
	}



	public VenditaListener(Libro libroVendita, Utente buyUser, MainFrame finestra) {
		this.LibroVendita = libroVendita;
		this.buyUser = buyUser;
		this.finestra = finestra;
	}



	@Override
	public void actionPerformed(ActionEvent sorgente) {
		if(sorgente.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) sorgente.getSource();
		if(bottone.getName() == "Avanti")
		{
			Boolean IdLibroFlag, Quantit‡Flag;
			
		if(source.getLibroID() == 0)
		{
			JOptionPane.showMessageDialog(null, "Non Ë stato inserito l'ID del libro");
			IdLibroFlag = false;
		}
			
		else if(!VenditaDAO.getInstance().checkLibroID(source.getLibroID()))
		{
			JOptionPane.showMessageDialog(null, "L'ID del libro inserito non Ë presente nel Database");
			IdLibroFlag = false;
		}
			
		
		else
			IdLibroFlag = true;
		if(source.getQuantit‡() == 0)
		{
			JOptionPane.showMessageDialog(null, "Non Ë stata inserita la quantit‡");
			Quantit‡Flag = false;
		}
		else if(!VenditaDAO.getInstance().checkQuantit‡(source.getQuantit‡(), source.getLibroID()))
		{
			JOptionPane.showMessageDialog(null, "Non sono disponibili abbastanza copie");
			Quantit‡Flag = false;
		}
		else
			Quantit‡Flag = true;
		if(IdLibroFlag && Quantit‡Flag)
		{
		Vector<String[]> risultato = VenditaDAO.getInstance().getLibro(source.getLibroID());
		LibroVendita = new Libro(risultato.get(0)[0], risultato.get(0)[1], risultato.get(0)[2], risultato.get(0)[3],risultato.get(0)[4], Double.parseDouble(risultato.get(0)[5]), source.getLibroID(), source.getQuantit‡());
		if(source.getUtenteID() != 0)
		{
		risultato = VenditaDAO.getInstance().getUtente(source.getUtenteID());
		buyUser = new Utente(risultato.get(0)[0], risultato.get(0)[1], source.getUtenteID());
		finestra.sellView(LibroVendita, buyUser);
		}
		else
		finestra.sellView(LibroVendita);
		}
		}
		
		if(bottone.getName() == "Registra")
		{
			if(buyUser == null)
			{
				VenditaDAO.getInstance().RegistraVendita(LibroVendita.getQuantit‡(), LibroVendita.getID(), LibroVendita.getPrezzo());
			}
			if(buyUser != null)
			{
				VenditaDAO.getInstance().RegistraVendita(LibroVendita.getQuantit‡(), LibroVendita.getID(), buyUser.getID(), LibroVendita.getPrezzo());
			}
			if(VenditaDAO.getInstance().ModificaQuantit‡(LibroVendita.getQuantit‡(), LibroVendita.getID()));
			JOptionPane.showMessageDialog(null, "Vendita Registrata con successo");
			finestra.changeView(4);
		}
		
		}
	}

}
