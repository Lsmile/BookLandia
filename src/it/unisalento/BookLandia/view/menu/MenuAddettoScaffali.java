package it.unisalento.BookLandia.view.menu;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class MenuAddettoScaffali extends JPanel {
	public MenuAddettoScaffali()
	{
		super();
		this.setLayout(new GridLayout(4,0));
		this.add(new BottoneMenu ("Catalogo"));
		this.add(new BottoneMenu ("Cerca"));
		this.add(new BottoneMenu ("Ordini"));
		this.add(new BottoneMenu ("Inserisci Libro"));
	}
}
