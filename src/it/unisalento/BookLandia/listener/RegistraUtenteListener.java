package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.view.RegistrazioneUtente.RegistraClientePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraUtenteListener implements ActionListener {
	
	RegistraClientePanel source;
	
	public RegistraUtenteListener(RegistraClientePanel source)
	{
		this.source = source;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("I work");
		
	}

}
