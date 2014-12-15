package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MenuCliente extends  JPanel{
	MenuListener Focus;
	BottoneMenu Catalogo = new BottoneMenu ("Catalogo");
	BottoneMenu Cerca = new BottoneMenu ("Cerca");
	BottoneMenu Ordini = new BottoneMenu ("Ordini");
	public MenuCliente()
	{
		super();
		this.setLayout(new GridLayout(3,0));
		this.add(Catalogo);
		this.add(Cerca);
		this.add(Ordini);
	}
}
