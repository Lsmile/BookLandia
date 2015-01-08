package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.view.catalogo.InserisciPanel;
import it.unisalento.BookLandia.view.creators.AutoreCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CreatorListener implements ActionListener {

	AutoreCreator autCreator;
	
	
	InserisciPanel source;
	
	public CreatorListener(AutoreCreator autoreCreator, InserisciPanel source)
	{
		autCreator = autoreCreator;
		this.source = source;
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
				}
	}
}
