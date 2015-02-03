package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.RegistraClientiDAO;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.RegistrazioneUtente.RegistraClientePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RegistraUtenteListener implements ActionListener {
	
	RegistraClientePanel source;
	MainFrame root;
	Boolean UserFlag = true, PassFlag = true, CodiceFiscaleFlag = true, NomeFlag = true, CognomeFlag = true;
	
	public RegistraUtenteListener(RegistraClientePanel source, MainFrame root)
	{
		this.source = source;
		this.root = root;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(RegistraClientiDAO.checkUsername(source.getUsername()) && source.getUsername().length() >= 3)
		{
			UserFlag = false;
			JOptionPane.showMessageDialog(null, "Username già esistente");
		}
		else
			UserFlag = true;
		
		if(source.getUsername().length() < 3)
		{
			UserFlag = false;
			JOptionPane.showMessageDialog(null, "Inserisci un nome utente di almeno 3 caratteri");
		}
		else
			UserFlag = true;
		
		
		if (source.getPassword().length() <= 8)
		{
			PassFlag = false;
			JOptionPane.showMessageDialog(null, "Inserisci una password di almeno 8 caratteri");
		}
		else
			PassFlag = true;
		
		if (source.getCodiceFiscale().length() != 16)
		{
			CodiceFiscaleFlag = false;
			JOptionPane.showMessageDialog(null, "Il codice fiscale non ha 16 caratteri!!");
		}
		else
			CodiceFiscaleFlag = true;
		
		if (RegistraClientiDAO.CheckCodiceFiscale(source.getCodiceFiscale()))
		{
			CodiceFiscaleFlag = false;
			JOptionPane.showMessageDialog(null, "Il codice fiscale esiste già in Database");
		}
		else
			CodiceFiscaleFlag = true;
		
		if (source.getNome().length() < 1)
		{
			NomeFlag = false;
			JOptionPane.showMessageDialog(null, "Non hai inserito il tuo nome!!");
		}
		
		if (source.getCognome().length() < 1)
		{
			CognomeFlag = false;
			JOptionPane.showMessageDialog(null, "Non hai inserito il tuo cognome!!");
		}
		
		if (UserFlag == true && PassFlag == true && CodiceFiscaleFlag == true && NomeFlag == true && CognomeFlag == true)
		{
		RegistraClientiDAO.RegistraCliente(source.getUsername(), source.getPassword(), source.getNome(), source.getCognome(), source.getCodiceFiscale());
		JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
		root.changeView(0);
		}
	}

}
