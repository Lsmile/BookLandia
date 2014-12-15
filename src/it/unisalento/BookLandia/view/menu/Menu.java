package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	BottoneMenu Catalogo =  new BottoneMenu (new ImageIcon("assets/catalogo.png"));
	BottoneMenu Cerca = new BottoneMenu (new ImageIcon("assets/cerca.png"));
	public Menu()
	{
		super();
		this.setLayout(new GridLayout(2,0));
		this.add(Catalogo);
		this.add(Cerca);
	}
}
