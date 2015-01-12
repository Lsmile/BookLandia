package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.RegistraClientiDAO;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.RegistrazioneUtente.RegistraClientePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraUtenteListener implements ActionListener {
	
	RegistraClientePanel source;
	MainFrame root;
	
	public RegistraUtenteListener(RegistraClientePanel source, MainFrame root)
	{
		this.source = source;
		this.root = root;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		RegistraClientiDAO.RegistraCliente(source.getUsername(), source.getPassword(), source.getNome(), source.getCognome(), source.getCodiceFiscale());
		root.changeView(6);
	}

}
