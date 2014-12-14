package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuCliente extends  JPanel{
	MenuListener Focus;
	JLabel Catalogo = new JLabel ("Catalogo");
	JLabel Cerca = new JLabel ("Cerca");
	JLabel Ordini = new JLabel ("Ordini");
	public MenuCliente()
	{
		super();
		this.setLayout(new GridLayout(3,0));
		this.add(Catalogo);
		this.add(Cerca);
		this.add(Ordini);
	}
}
