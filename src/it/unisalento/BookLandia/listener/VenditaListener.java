package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.VenditaDAO;
import it.unisalento.BookLandia.model.Libro;
import it.unisalento.BookLandia.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Vendita.RegistraVenditaPanel;

public class VenditaListener implements ActionListener {
	Libro LibroVendita;
	RegistraVenditaPanel source;
	MainFrame finestra;
	
	public VenditaListener(RegistraVenditaPanel source, MainFrame finestra)
	{
		this.source = source;
		this.finestra = finestra;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Vector<String[]> risultato = VenditaDAO.getInstance().getLibro(source.getLibroID());
		LibroVendita = new Libro(risultato.get(0)[0], risultato.get(0)[1], risultato.get(0)[2], risultato.get(0)[3],risultato.get(0)[4], Double.parseDouble(risultato.get(0)[5]), source.getLibroID());
		System.out.println(LibroVendita.getGenere());
		finestra.sellView(LibroVendita);
	}

}
