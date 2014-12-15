package it.unisalento.BookLandia.view;

import it.unisalento.BookLandia.view.catalogo.PanelCatalogo;
import it.unisalento.BookLandia.view.menu.Menu;
import it.unisalento.BookLandia.view.northpan.NorthPanel;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	Container Contenitore;
	
	
	public MainFrame()
	{
		super("BookLandia");
		this.setBounds(0, 0, 1000, 1000);
		Contenitore = this.getContentPane();
		Contenitore.setLayout(new BorderLayout());
		Contenitore.add(new PanelCatalogo(), BorderLayout.CENTER);
		Contenitore.add(new NorthPanel(), BorderLayout.NORTH);
		
		Menu leftMenu = new Menu(this);
		Contenitore.add(leftMenu, BorderLayout.WEST);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public void changeView(int Selezione)
	{
		
		switch (Selezione)
		{
		case 0: Contenitore.add(new PanelCatalogo(), BorderLayout.CENTER);
		break;
		case 1: Contenitore.add(new PanelCerca(), BorderLayout.CENTER);
		break;
	}
}
}
