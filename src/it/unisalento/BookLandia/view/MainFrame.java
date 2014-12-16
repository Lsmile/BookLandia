package it.unisalento.BookLandia.view;

import it.unisalento.BookLandia.view.catalogo.PanelCatalogo;
import it.unisalento.BookLandia.view.menu.Menu;
import it.unisalento.BookLandia.view.northpan.NorthPanel;
import it.unisalento.BookLandia.view.ordini.OrdinePanel;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	Container Contenitore;
	PanelCatalogo Catalogo = new PanelCatalogo();
	OrdinePanel Ordine = new OrdinePanel();
	PanelCerca Cerca = new PanelCerca();
	Menu leftMenu = new Menu(this);
	BorderLayout Layout = new BorderLayout();
	JPanel panelInFront;
	
	
	public MainFrame()
	{
		super("BookLandia");
		this.setBounds(0, 0, 1000, 1000);
		Contenitore = this.getContentPane();
		Contenitore.setLayout(Layout);
		Contenitore.add(Catalogo, BorderLayout.CENTER);
		Contenitore.add(new NorthPanel(), BorderLayout.NORTH);
		Contenitore.add(leftMenu, BorderLayout.WEST);
		
		panelInFront = Catalogo;
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public void changeView(int Selezione)
	{
		Contenitore.remove(panelInFront);
		switch (Selezione)
		{
		case 0: Contenitore.add(Catalogo, BorderLayout.CENTER);
		panelInFront = Catalogo;
		break;
		case 1: Contenitore.add(Cerca, BorderLayout.CENTER);
		panelInFront = Cerca;
		break;
		case 2: Contenitore.add(Ordine, BorderLayout.CENTER);
		panelInFront = Ordine;
		break;
	}
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
		
	}
}
