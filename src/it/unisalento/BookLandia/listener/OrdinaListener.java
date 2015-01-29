package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OrdinaListener implements ActionListener {
	


	public OrdinaListener()
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) event.getSource();
			int bookPosition = Integer.parseInt(bottone.getName());
		}
	}

}
