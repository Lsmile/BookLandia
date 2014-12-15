package it.unisalento.BookLandia.view.menu;

import java.awt.GridLayout;

import javax.swing.JPanel;


public class MenuCliente extends  JPanel{
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
