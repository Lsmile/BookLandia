package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CercaListener implements ActionListener {
	
	MainFrame source;
	PanelCerca DatiSource;
	
	public CercaListener(MainFrame source, PanelCerca DatiSource)
	{
		this.source = source;
		this.DatiSource = DatiSource;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		source.searchView(DatiSource.getInfo());
		
	}

}
