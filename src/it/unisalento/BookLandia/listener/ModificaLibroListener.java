package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.GestoreLibri;
import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.dao.CasaEditriceDAO;
import it.unisalento.BookLandia.dao.GenereDAO;
import it.unisalento.BookLandia.dao.LibroDAO;
import it.unisalento.BookLandia.dao.ScaffaleDAO;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.bookManagement.InserisciPanel;
import it.unisalento.BookLandia.view.bookManagement.ModificaLibroPanel;
import it.unisalento.BookLandia.view.creators.AutoreCreator;
import it.unisalento.BookLandia.view.creators.CasaEditriceCreator;
import it.unisalento.BookLandia.view.creators.GenereCreator;
import it.unisalento.BookLandia.view.creators.ScaffaliCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ModificaLibroListener implements ActionListener{

	ModificaLibroPanel source;
	MainFrame root;
	
	public ModificaLibroListener(ModificaLibroPanel source, MainFrame root)
	{
		this.source = source;
		this.root = root;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton button = (JButton)event.getSource();
			if(button.getName() == "Modifica")
			{
				boolean invalidInput = false;
				if(source.getTitoloTextField().getText().length() < 1)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Inserisci un titolo per il libro");
				}
				if(source.getPrezzoTextField().getText().length() < 1)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Inserisci un prezzo per il libro");
				}
				if(source.getISBNTextField().getText().length() < 1)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Inserisci l'ISBN del libro");
				}
				if(source.getCopieTextField().getText().length() < 1)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Inserisci il numero di copie del libro");
				}
				if(source.getAutoreList().getSelectedValue() == null)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Seleziona un autore o inseriscine uno nuovo");
				}
				if(source.getGenereList().getSelectedValue() == null)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Seleziona un genere o inseriscine uno nuovo");
				}
				if(source.getCasaEditriceList().getSelectedValue() == null)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Seleziona una casa editrice o inseriscine una nuova");
				}
				if(source.getScaffaleList().getSelectedValue() == null)
				{
					invalidInput = true;
					JOptionPane.showMessageDialog(null, "Seleziona uno scaffale o inseriscine uno nuovo");
				}
				if(!invalidInput)
				{
				
					int id = source.getIdSelected();
				
					String titolo = source.getTitoloTextField().getText();
					float prezzo = Float.parseFloat(source.getPrezzoTextField().getText().replace(",", "."));
					String ISBN = ((String) source.getISBNTextField().getText()).replace(".", "");
					int copieDisponibili = Integer.parseInt(source.getCopieTextField().getText());
					int idAutore = AutoreDAO.getInstance().getIdFromName((String)source.getAutoreList().getSelectedValue());
					int idGenere =  GenereDAO.getInstance().getIdFromName((String)source.getGenereList().getSelectedValue());
					int idCasaEditrice = CasaEditriceDAO.getInstance().getIdFromName((String)source.getCasaEditriceList().getSelectedValue());
					int idScaffale = ScaffaleDAO.getInstance().getIdFromName((String)source.getScaffaleList().getSelectedValue());
					GestoreLibri.getInstance().ModificaLibro(id, titolo, prezzo, ISBN, copieDisponibili, idAutore, idGenere, idCasaEditrice, idScaffale);
				
					JOptionPane.showMessageDialog(null, "Libro "+titolo+" modificato con successo" );
				}
			}
			else if(button.getName() == "NuovoAutore")
			{
				AutoreCreator creator = new AutoreCreator(root);
			}
			else if(button.getName() == "NuovoGenere")
			{
				GenereCreator creator = new GenereCreator(root);
			}
			else if(button.getName() == "NuovaCasaEditrice")
			{
				CasaEditriceCreator creator = new CasaEditriceCreator(root);
			}
			else if(button.getName() == "NuovoScaffale")
			{
				ScaffaliCreator creator = new ScaffaliCreator(root);
			}
			else if(button.getName() == "Cerca")
			{
				if(((Number)source.getIdTextField().getValue()).intValue() > LibroDAO.getInstance().getNumLibri())
					JOptionPane.showMessageDialog(null, "Libro non presente");
				else
				{
					String libro[] = LibroDAO.getInstance().getLibro(((Number)source.getIdTextField().getValue()).intValue());
				
					JOptionPane.showMessageDialog(null, "Selezionato "+libro[0]);
					
					source.SelezionaLibro(libro[0],Float.parseFloat(libro[1]), libro[3], Integer.parseInt(libro[4]), Integer.parseInt(libro[5]), Integer.parseInt(libro[6]), Integer.parseInt(libro[7]), Integer.parseInt(libro[8]));//2 manca perché è l'ID
				}
				
			}
		}
	}

}
