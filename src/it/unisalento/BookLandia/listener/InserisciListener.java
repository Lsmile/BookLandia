package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.GestoreLibri;
import it.unisalento.BookLandia.view.catalogo.InserisciPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InserisciListener implements ActionListener{

	InserisciPanel source;
	
	InserisciListener(InserisciPanel source)
	{
		this.source = source;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton button = (JButton)event.getSource();
			if(button.getName() == "Inserisci")
			{
				String titolo = source.getTitoloTextField().getText();
				float prezzo = Float.parseFloat(source.getTitoloTextField().getText());
				String ISBN = source.getISBNTextField().getText();
				int copieDisponibili = Integer.parseInt(source.getCopieTextField().getText());
				int idAutore = source.getAutoreList().getSelectedIndex();
				int idGenere =  source.getGenereList().getSelectedIndex();
				int idCasaEditrice = source.getCasaEditriceList().getSelectedIndex();
				int idScaffale = source.getScaffaleList().getSelectedIndex();
				GestoreLibri.getInstance().InserisciLibro(titolo, prezzo, ISBN, copieDisponibili, idAutore, idGenere, idCasaEditrice, idScaffale);
			}
		}
	}

}
