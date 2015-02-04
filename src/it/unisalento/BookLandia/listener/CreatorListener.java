package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.dao.CasaEditriceDAO;
import it.unisalento.BookLandia.dao.GenereDAO;
import it.unisalento.BookLandia.dao.ScaffaleDAO;
import it.unisalento.BookLandia.view.bookManagement.InserisciPanel;
import it.unisalento.BookLandia.view.creators.AutoreCreator;
import it.unisalento.BookLandia.view.creators.CasaEditriceCreator;
import it.unisalento.BookLandia.view.creators.GenereCreator;
import it.unisalento.BookLandia.view.creators.ScaffaliCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CreatorListener implements ActionListener {

	AutoreCreator autCreator;
	GenereCreator genCreator;
	CasaEditriceCreator casCreator;
	ScaffaliCreator scaCreator;
	
	
	public CreatorListener(AutoreCreator autoreCreator, GenereCreator genereCreator, CasaEditriceCreator casaedCreator,ScaffaliCreator scaffaleCreator)
	{
		autCreator = autoreCreator;
		genCreator = genereCreator;
		casCreator = casaedCreator;
		scaCreator = scaffaleCreator;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
				if(event.getSource() instanceof JButton)
				{
					JButton button = (JButton)event.getSource();
					if(button.getName() == "CreaAutore")
					{
						AutoreDAO.getInstance().inserisciAutore(autCreator.getNome().getText());
						JOptionPane.showMessageDialog(null, "Autore "+autCreator.getNome().getText()+" inserito con successo" );
						autCreator.Update();
					}
					if(button.getName() == "CreaGenere")
					{
						GenereDAO.getInstance().inserisciGenere(genCreator.getNome().getText());
						JOptionPane.showMessageDialog(null, "Genere "+genCreator.getNome().getText()+" inserito con successo" );
						genCreator.Update();
					}
					if(button.getName() == "CreaCasaEditrice")
					{
						CasaEditriceDAO.getInstance().inserisciGenere(casCreator.getNome().getText());
						JOptionPane.showMessageDialog(null, "Casa Editrice "+casCreator.getNome().getText()+" inserito con successo" );
						casCreator.Update();
					}
					if(button.getName() == "CreaScaffale")
					{
						ScaffaleDAO.getInstance().inserisciScaffale(scaCreator.getNome().getText(),(int)scaCreator.getSpinner1().getValue(),(int)scaCreator.getSpinner2().getValue());
						JOptionPane.showMessageDialog(null, "Scaffale "+scaCreator.getNome().getText()+" inserito con successo" );
						scaCreator.Update();
					}
				}
	}
}
