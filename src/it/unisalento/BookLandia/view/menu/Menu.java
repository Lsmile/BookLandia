package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	MenuListener Focus;
	JLabel Catalogo =  new JLabel ("Catalogo");
	JLabel Cerca = new JLabel ("Cerca");
	public Menu()
	{
		super();
		this.setLayout(new GridLayout(2,0));
		this.add(Catalogo);
		Catalogo.addFocusListener(Focus);
		this.add(Cerca);
		Cerca.addFocusListener(Focus);
	}
}
