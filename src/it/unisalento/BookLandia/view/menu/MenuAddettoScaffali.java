package it.unisalento.BookLandia.view.menu;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuAddettoScaffali extends JPanel {
	public MenuAddettoScaffali()
	{
		super();
		this.setLayout(new GridLayout(4,0));
		this.add(new JLabel ("Catalogo"));
		this.add(new JLabel ("Cerca"));
		this.add(new JLabel ("Ordini"));
		this.add(new JLabel ("Inserisci Libro"));
	}
}
