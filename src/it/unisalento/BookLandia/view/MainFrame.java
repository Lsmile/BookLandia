package it.unisalento.BookLandia.view;

import it.unisalento.BookLandia.business.GestoreDati;
import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.model.Libro;
import it.unisalento.BookLandia.model.Utente;
import it.unisalento.BookLandia.view.catalogo.InserisciPanel;
import it.unisalento.BookLandia.view.catalogo.PanelCatalogo;
import it.unisalento.BookLandia.view.menu.Menu;
import it.unisalento.BookLandia.view.menu.MenuAddettoScaffali;
import it.unisalento.BookLandia.view.menu.MenuAddettoVendite;
import it.unisalento.BookLandia.view.menu.MenuCliente;
import it.unisalento.BookLandia.view.northpan.NorthPanel;
import it.unisalento.BookLandia.view.ordini.OrdinePanel;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;
import it.unisalento.BookLandia.view.ricerca.PanelRisultati;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Vendita.RegistraPanel;
import Vendita.RegistraVenditaPanel;
import Vendita.TabellaVendite;

public class MainFrame extends JFrame {
	Container Contenitore;
	PanelCatalogo Catalogo = new PanelCatalogo();
	OrdinePanel Ordine = new OrdinePanel();
	PanelCerca Cerca = new PanelCerca(this);
	InserisciPanel Inserisci = new InserisciPanel();
	TabellaVendite VenditePanel = new TabellaVendite();
	RegistraVenditaPanel Registra_Vendita = new RegistraVenditaPanel(this);
	Menu leftMenu = new Menu(this);
	MenuAddettoScaffali leftMenuScaffali = new MenuAddettoScaffali(this);
	MenuAddettoVendite leftMenuVendite = new MenuAddettoVendite(this);
	MenuCliente leftMenuCliente = new MenuCliente(this);
	BorderLayout Layout = new BorderLayout();
	
	JPanel panelInFront;
	
	
	public MainFrame()
	{
		super("BookLandia");
		this.setBounds(0, 0, 1000, 1000);
		Contenitore = this.getContentPane();
		Contenitore.setLayout(Layout);
		Contenitore.add(Catalogo, BorderLayout.CENTER);
		Contenitore.add(new NorthPanel(this), BorderLayout.NORTH);
		Contenitore.add(leftMenu, BorderLayout.WEST);
		
		panelInFront = Catalogo;
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public void changeView(int Selezione)
	{
		Contenitore.remove(panelInFront);
		switch (Selezione)
		{
		case 0: Contenitore.add(Catalogo, BorderLayout.CENTER);
		panelInFront = Catalogo;
		break;
		case 1: Contenitore.add(Cerca, BorderLayout.CENTER);
		panelInFront = Cerca;
		break;
		case 2: Contenitore.add(Ordine, BorderLayout.CENTER);
		panelInFront = Ordine;
		break;
		case 3: Contenitore.add(Inserisci, BorderLayout.CENTER);
		panelInFront = Inserisci;
		break;
		case 4: Contenitore.add(Registra_Vendita, BorderLayout.CENTER);
		panelInFront = Registra_Vendita;
		break;
		case 5:Contenitore.add(VenditePanel, BorderLayout.CENTER);
		panelInFront = VenditePanel;
		break;
	    }
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
		
	}
	
	public void searchView(GestoreDati Dati)
	{
		Contenitore.remove(panelInFront);
		panelInFront = PanelRisultati.getInstance(Dati);
		Contenitore.add(panelInFront, BorderLayout.CENTER);
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
	}
	
	public void sellView(Libro Dati)
	{
			Contenitore.remove(panelInFront);
			panelInFront = RegistraPanel.getInstance(Dati, this);
			Contenitore.add(panelInFront, BorderLayout.CENTER);
			revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
			repaint();	//
	}
		
	public void selectMenu(UserType user) //cambia il menu a sinistra a seconda dell'utente che si è loggato
	{
		switch(user)//diamo per scontato per il momento che vada rimosso il leftMenu perché si accede solo da utente non registrato
		{//nel logout poi andrà fatta una selezione dell'utente corrente per sapere quale panel va rimosso, quindi la rimozione va fatta prima del cambiamento di tipo utente
			case CLIENTE:
				Contenitore.remove(leftMenu);
				Contenitore.add(leftMenuCliente, BorderLayout.WEST);
				break;
			case VENDITE:
				Contenitore.remove(leftMenu);
				Contenitore.add(leftMenuVendite, BorderLayout.WEST);
				break;
			case SCAFFALI:
				Contenitore.remove(leftMenu);
				Contenitore.add(leftMenuScaffali, BorderLayout.WEST);
				break;
			case NESSUNO:
				if(UserManager.getInstance().getUtente_connesso() == UserType.CLIENTE)
				{
					Contenitore.remove(leftMenuCliente);
				}
				if(UserManager.getInstance().getUtente_connesso() == UserType.SCAFFALI)
				{
					Contenitore.remove(leftMenuScaffali);
				}
				if(UserManager.getInstance().getUtente_connesso() == UserType.VENDITE)
				{
					Contenitore.remove(leftMenuVendite);
				}
				Contenitore.add(leftMenu, BorderLayout.WEST);
				break;
		}
		
		Contenitore.revalidate();
		Contenitore.repaint();
	}

	public void sellView(Libro libroVendita, Utente buyUser) {
		Contenitore.remove(panelInFront);
		panelInFront = RegistraPanel.getInstance(libroVendita, buyUser, this);
		Contenitore.add(panelInFront, BorderLayout.CENTER);
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
		
	}
}
