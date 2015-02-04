package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.dao.LibroDAO;
import it.unisalento.BookLandia.dao.OrdiniDAO;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.ordini.VistaOrdini;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OrdinaListener implements ActionListener {
	

	JTable source;
	VistaOrdini vistaordini;

	public OrdinaListener(JTable source, VistaOrdini ordini)
	{
		this.source = source;
		vistaordini = ordini;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) event.getSource();
			String name = bottone.getName();
			//int Position = Integer.parseInt(name.substring(name.length()-1, name.length())); //ultimo carattere
			//String action = name.substring(0, name.length()-1);
			String action = name.replaceAll("[0123456789]", "");
			int Position = Integer.parseInt(name.toLowerCase().replaceAll("[abcdefghijklmnopqrstuvxwyz]", ""));
			
			if(action.equalsIgnoreCase("ordina"))
			{
				
				if(UserManager.getInstance().getUtente_connesso() == UserType.CLIENTE)
				{
					int riga = Position;
					int colonna = 0;
					int id = (int)source.getValueAt(riga, colonna);
					if(LibroDAO.getInstance().esauriteCopie(id))
					{
						OrdiniDAO.getInstance().insertOrdinazione(id);
						JOptionPane.showMessageDialog(null, "Inserito ordine per libro "+  LibroDAO.getInstance().getLibro(id)[0] );
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sono ancora disponibili copie del libro, contatta un venditore per procedere all'acquisto");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Entra come utente registrato per ordinare" );
				}
			}
			else if(action.equalsIgnoreCase("arrivato"))
			{
				int riga = Position;
				int colonna = 0;
				int id = Integer.parseInt((String) source.getValueAt(riga, colonna));
				
				OrdiniDAO.getInstance().libroArrivato(id);
				
				vistaordini.Refresh();
				JOptionPane.showMessageDialog(null, "Libro segnalato come arrivato" );
				
			}
			else if(action.equalsIgnoreCase("cancella"))
			{
				
				int riga = Position;
				int colonna = 0;
				int id = Integer.parseInt((String) source.getValueAt(riga, colonna));
				
				OrdiniDAO.getInstance().cancellaOrdinazione(id);
				
				vistaordini.Refresh();
				JOptionPane.showMessageDialog(null, "Ordine cancellato" );
				
			}
			else if(action.equalsIgnoreCase("completa"))
			{
				int riga = Position;
				int colonna = 0;
				int id = Integer.parseInt((String) source.getValueAt(riga, colonna));
				
				OrdiniDAO.getInstance().concludiOrdinazione(id);
				
				vistaordini.Refresh();
				JOptionPane.showMessageDialog(null, "Ordine concluso");
				
			}
		}
	}

	
}
