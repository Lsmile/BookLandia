package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuAddettoVendite extends JPanel {
	MenuListener Focus;
	JLabel Catalogo = new JLabel ("Catalogo");
	JLabel Cerca = new JLabel ("Cerca");
	JLabel Ordini = new JLabel ("Ordini");
	JLabel Registra_Vendita = new JLabel ("Registra Vendita");
	public MenuAddettoVendite()
	{
		super();
		this.setLayout(new GridLayout(3,0));
		this.add(Catalogo);
		Catalogo.addFocusListener(Focus);
		this.add(Cerca);
		this.add(Ordini);
		this.add(Registra_Vendita);
	}
}
