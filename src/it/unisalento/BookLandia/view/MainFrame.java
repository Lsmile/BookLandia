package it.unisalento.BookLandia.view;

import it.unisalento.BookLandia.view.catalogo.PanelCatalogo;
import it.unisalento.BookLandia.view.menu.Menu;
import it.unisalento.BookLandia.view.northpan.NorthPanel;
import it.unisalento.BookLandia.view.ordini.OrdinePanel;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	Container Contenitore;
	PanelCatalogo Catalogo = new PanelCatalogo();
	OrdinePanel Ordine = new OrdinePanel();
	PanelCerca Cerca = new PanelCerca();
	Menu leftMenu = new Menu(this);
	
	
	public MainFrame()
	{
		super("BookLandia");
		this.setBounds(0, 0, 1000, 1000);
		Contenitore = this.getContentPane();
		Contenitore.setLayout(new BorderLayout());
		Contenitore.add(Catalogo, BorderLayout.CENTER);
		Contenitore.add(new NorthPanel(), BorderLayout.NORTH);
		Contenitore.add(leftMenu, BorderLayout.WEST);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public void changeView(int Selezione)
	{
		BorderLayout layout = (BorderLayout) Contenitore.getLayout();
		this.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		switch (Selezione)
		{
		case 0: Contenitore.add(Catalogo, BorderLayout.CENTER);
		break;
		case 1: Contenitore.add(Cerca, BorderLayout.CENTER);
		break;
		case 2: Contenitore.add(Ordine, BorderLayout.CENTER);
		break;
	}
		
	}
}
