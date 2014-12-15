package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.view.MainFrame;

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
		System.out.println("Funziono");
		if(event.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) event.getSource();
			System.out.println(bottone.getName());
			if(bottone.getName() == "Catalogo")
			{
				System.out.println("Cambio in catalogo e invece no");
				source.changeView(0);
			}
			
			if(bottone.getName() == "Cerca")
			{
				source.changeView(1);
			}
				source.setVisible(true);
		}
		
	}

}
