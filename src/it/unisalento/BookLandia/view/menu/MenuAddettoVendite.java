package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MenuAddettoVendite extends JPanel {
	MenuListener Focus;
	BottoneMenu Catalogo = new BottoneMenu ("Catalogo");
	BottoneMenu Cerca = new BottoneMenu ("Cerca");
	BottoneMenu Ordini = new BottoneMenu ("Ordini");
	BottoneMenu Registra_Vendita = new BottoneMenu ("Registra Vendita");
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
