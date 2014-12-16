package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;
import it.unisalento.BookLandia.view.MainFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MenuAddettoVendite extends JPanel {
	BottoneMenu Catalogo = new BottoneMenu ("Catalogo");
	BottoneMenu Cerca = new BottoneMenu ("Cerca");
	BottoneMenu Ordini = new BottoneMenu ("Ordini");
	BottoneMenu Registra_Vendita = new BottoneMenu ("Registra Vendita");
	MenuListener listener;
	public MenuAddettoVendite(MainFrame window)
	{
		super();
		this.setLayout(new GridLayout(4,0));
		
		//istanzio il listener
		listener = new MenuListener(window);
		
		//do un nome ai bottoni
		Catalogo.setName("Catalogo");
		Cerca.setName("Cerca");
		Ordini.setName("Ordini");
		Registra_Vendita.setName("Registra_Vendita");
		
		//aggiungo i listener
		Catalogo.addActionListener(listener);
		Cerca.addActionListener(listener);
		Ordini.addActionListener(listener);
		Registra_Vendita.addActionListener(listener);
		this.add(Catalogo);
		this.add(Cerca);
		this.add(Ordini);
		this.add(Registra_Vendita);
	}
}
