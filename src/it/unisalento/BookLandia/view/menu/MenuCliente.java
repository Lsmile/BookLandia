package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;
import it.unisalento.BookLandia.view.MainFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;


public class MenuCliente extends  JPanel{
	BottoneMenu Catalogo = new BottoneMenu ("Catalogo");
	BottoneMenu Cerca = new BottoneMenu ("Cerca");
	BottoneMenu Ordini = new BottoneMenu ("Ordini");
	MenuListener listener;
	MainFrame window;
	public MenuCliente(MainFrame window)
	{
		super();
		this.window = window;
		
		listener = new MenuListener(this.window);
		
		//do un nome ai bottoni
		Catalogo.setName("Catalogo");
		Cerca.setName("Cerca");
		Ordini.setName("Ordini");
		
		//aggiungo gli action listener
		Catalogo.addActionListener(listener);
		Cerca.addActionListener(listener);
		Ordini.addActionListener(listener);
		
		this.setLayout(new GridLayout(3,0));
		this.add(Catalogo);
		this.add(Cerca);
		this.add(Ordini);
	}
}
