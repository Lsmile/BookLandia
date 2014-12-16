package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.view.MainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuListener implements ActionListener {
	MainFrame source;
	public MenuListener(MainFrame finestra)
	{
		source = finestra;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) event.getSource();
			if(bottone.getName() == "Catalogo")
			{
				source.changeView(0);
			}
			
			if(bottone.getName() == "Cerca")
			{
				source.changeView(1);
			}
			if(bottone.getName() == "Ordini")
			{
				source.changeView(2);
			}
				source.setVisible(true);
		}
		
	}

}
