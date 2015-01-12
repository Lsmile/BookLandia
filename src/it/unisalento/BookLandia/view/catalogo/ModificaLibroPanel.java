package it.unisalento.BookLandia.view.catalogo;

import java.awt.GridLayout;
import java.text.NumberFormat;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.dao.CasaEditriceDAO;
import it.unisalento.BookLandia.dao.GenereDAO;
import it.unisalento.BookLandia.dao.ScaffaleDAO;
import it.unisalento.BookLandia.listener.ModificaLibroListener;
import it.unisalento.BookLandia.view.MainFrame;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ModificaLibroPanel extends JPanel {
	MainFrame source;
	
	ModificaLibroListener listener;
	
	JLabel titoloLabel;
	JTextField titoloTextField;
	
	JLabel prezzoLabel;
	JFormattedTextField prezzoTextField;
	
	JLabel ISBNLabel;
	JFormattedTextField ISBNTextField;
	
	JLabel CopieLabel;
	JTextField CopieTextField;
	
	JLabel autoreLabel;
	JPanel autorePanel;
	JScrollPane autorePanelScroll;
	JList autoreList;
	JButton nuovoAutoreButton;
	
	JLabel genereLabel;
	JPanel generePanel;
	JScrollPane generePanelScroll;
	JList genereList;
	JButton nuovoGenereButton;
	
	JLabel casaEditriceLabel;
	JPanel casaEditricePanel;
	JScrollPane casaEditricePanelScroll;
	JList casaEditriceList;
	JButton nuovaCasaEditriceButton;
	
	JLabel scaffaleLabel;
	JPanel scaffalePanel;
	JScrollPane scaffalePanelScroll;
	JList scaffaleList;
	JButton nuovoScaffaleButton;
	
	JButton inserisci;
	
	NumberFormat formatoPrezzo;
	NumberFormat formatoISBN;
	
	public ModificaLibroPanel(MainFrame source)
	{
		this.source = source;
		
		listener = new ModificaLibroListener(this);
		
		formatoPrezzo = NumberFormat.getNumberInstance();
		formatoPrezzo.setMinimumFractionDigits(2);
		formatoPrezzo.setMaximumFractionDigits(2);
		
		formatoISBN = NumberFormat.getIntegerInstance();
		formatoISBN.setMinimumIntegerDigits(11);
		formatoISBN.setMaximumIntegerDigits(11);
		
		titoloLabel = new JLabel("Titolo");
		titoloTextField = new JTextField();
		
		prezzoLabel = new JLabel("Prezzo");
		prezzoTextField = new JFormattedTextField(formatoPrezzo);
		
		ISBNLabel = new JLabel("ISBN");
		ISBNTextField = new JFormattedTextField(formatoISBN);
		
		CopieLabel = new JLabel("Copie Disponibili");
		CopieTextField = new JTextField();
		
		autoreLabel = new JLabel("Autore");
		autoreList = new JList<String>(AutoreDAO.getInstance().getNomiAutori());
		nuovoAutoreButton = new JButton("Inserisci Nuovo");
		nuovoAutoreButton.setName("NuovoAutore");
		nuovoAutoreButton.addActionListener(listener);
		autorePanel = new JPanel();
		autorePanel.add(autoreList);
		autorePanel.add(nuovoAutoreButton);
		autorePanelScroll = new JScrollPane(autorePanel);
		
		genereLabel = new JLabel("Genere");
		genereList = new JList<String>(GenereDAO.getInstance().getNomiGeneri());
		nuovoGenereButton = new JButton("Inserisci Nuovo");
		nuovoGenereButton.setName("NuovoGenere");
		nuovoGenereButton.addActionListener(listener);
		generePanel = new JPanel();
		generePanel.add(genereList);
		generePanel.add(nuovoGenereButton);
		generePanelScroll = new JScrollPane(generePanel);
		
		casaEditriceLabel = new JLabel("Casa Editrice");
		casaEditriceList = new JList<String>(CasaEditriceDAO.getInstance().getNomiCaseEditrici());
		nuovaCasaEditriceButton = new JButton("Inserisci Nuovo");
		nuovaCasaEditriceButton.setName("NuovaCasaEditrice");
		nuovaCasaEditriceButton.addActionListener(listener);
		casaEditricePanel = new JPanel();
		casaEditricePanel.add(casaEditriceList);
		casaEditricePanel.add(nuovaCasaEditriceButton);
		casaEditricePanelScroll = new JScrollPane(casaEditricePanel);
		
		scaffaleLabel = new JLabel("Casa Editrice");
		scaffaleList = new JList<String>(ScaffaleDAO.getInstance().getSettoriScaffali());
		nuovoScaffaleButton = new JButton("Inserisci Nuovo");
		nuovoScaffaleButton.setName("NuovoScaffale");
		nuovoScaffaleButton.addActionListener(listener);
		scaffalePanel = new JPanel();
		scaffalePanel.add(scaffaleList);
		scaffalePanel.add(nuovoScaffaleButton);
		scaffalePanelScroll = new JScrollPane(scaffalePanel);
		
		inserisci = new JButton("Inserisci");
		inserisci.setName("Inserisci");
		inserisci.addActionListener(listener);
		
		
		this.setLayout(new GridLayout(9,2));
		add(titoloLabel);
		add(titoloTextField);
		add(prezzoLabel);
		add(prezzoTextField);
		add(ISBNLabel);
		add(ISBNTextField);
		add(CopieLabel);
		add(CopieTextField);
		add(autoreLabel);
		add(autorePanelScroll);
		add(genereLabel);
		add(generePanelScroll);
		add(casaEditriceLabel);
		add(casaEditricePanelScroll);
		add(scaffaleLabel);
		add(scaffalePanelScroll);
		
		add(inserisci);
	}
}
