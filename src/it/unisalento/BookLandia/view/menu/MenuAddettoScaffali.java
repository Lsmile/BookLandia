package it.unisalento.BookLandia.view.menu;

import it.unisalento.BookLandia.listener.MenuListener;
import it.unisalento.BookLandia.view.MainFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MenuAddettoScaffali extends JPanel {
	MainFrame window;
	BottoneMenu Catalogo = new BottoneMenu ("Catalogo");
	BottoneMenu Cerca = new BottoneMenu ("Cerca");
	BottoneMenu Ordini = new BottoneMenu ("Ordini");
	BottoneMenu Inserisci_Libro = new BottoneMenu("Inserisci Libro");
	BottoneMenu Modifica_Libro = new BottoneMenu("Modifica Libro");
	MenuListener listener;
	public MenuAddettoScaffali(MainFrame window)
	{
		super();
		this.setLayout(new GridLayout(5,0));
		
		//istanzio il listener
		listener = new MenuListener(window);
		
		//do un nome ai bottoni
		Catalogo.setName("Catalogo");
		Cerca.setName("Cerca");
		Ordini.setName("Ordini");
		Inserisci_Libro.setName("Inserisci_Libro");
		Modifica_Libro.setName("Modifica_Libro");
		
		//aggiungo i listener
		Catalogo.addActionListener(listener);
		Cerca.addActionListener(listener);
		Ordini.addActionListener(listener);
		Inserisci_Libro.addActionListener(listener);
		Modifica_Libro.addActionListener(listener);
		this.add(Catalogo);
		this.add(Cerca);
		this.add(Ordini);
		this.add(Inserisci_Libro);
		this.add(Modifica_Libro);
	}
}
