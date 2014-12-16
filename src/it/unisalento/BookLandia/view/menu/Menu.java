package it.unisalento.BookLandia.view.menu;
import it.unisalento.BookLandia.listener.MenuListener;
import it.unisalento.BookLandia.view.MainFrame;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Menu extends JPanel {
	BottoneMenu Catalogo =  new BottoneMenu (new ImageIcon("assets/catalogo.png"));
	BottoneMenu Cerca = new BottoneMenu (new ImageIcon("assets/cerca.png"));
	MenuListener menulistener;
	MainFrame window;
	
	public Menu(MainFrame Window)
	{
		super();
		this.window = Window;
		menulistener = new MenuListener(window);
		this.setLayout(new GridLayout(2,0));
		
		//do un nome ai bottoni
		Catalogo.setName("Catalogo");
		Cerca.setName("Cerca");
		
		//setto i listener
		Catalogo.addActionListener(menulistener);
		Cerca.addActionListener(menulistener);
		
		//aggiungo al panel i bottoni
		this.add(Catalogo);
		this.add(Cerca);
		
	}

}
