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
		Vector<String[]> risultato = VenditaDAO.getInstance().getLibro(source.getLibroID());
		LibroVendita = new Libro(risultato.get(0)[0], risultato.get(0)[1], risultato.get(0)[2], risultato.get(0)[3],risultato.get(0)[4], Double.parseDouble(risultato.get(0)[5]), source.getLibroID(), source.getQuantità());
		if(source.getUtenteID() != 0)
		{
		risultato = VenditaDAO.getInstance().getUtente(source.getUtenteID());
		buyUser = new Utente(risultato.get(0)[0], risultato.get(0)[1], source.getUtenteID());
		finestra.sellView(LibroVendita, buyUser);
		}
		else
		finestra.sellView(LibroVendita);
		}
		
		if(bottone.getName() == "Registra")
		{
			if(buyUser == null)
			{
				VenditaDAO.getInstance().RegistraVendita(LibroVendita.getQuantità(), LibroVendita.getID());
			}
			if(buyUser != null)
			{
				VenditaDAO.getInstance().RegistraVendita(LibroVendita.getQuantità(), LibroVendita.getID(), buyUser.getID());
				System.out.println("Qui arrivo");
			}
			finestra.changeView(4);
		}
		
		}
	}

}
