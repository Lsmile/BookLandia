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
	int idSelected = 0;
	
	MainFrame source;
	
	ModificaLibroListener listener;
	
	JLabel idLabel;
	JFormattedTextField idTextField;
	JButton idButton;
	NumberFormat idFormat;
	JLabel curBookLabel;
	
	
	
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
		
		listener = new ModificaLibroListener(this,source);
		
		idFormat = NumberFormat.getNumberInstance();
		idTextField = new JFormattedTextField(idFormat);
		idLabel = new JLabel("Id del libro");
		idButton = new JButton("Cerca");
		idButton.setName("Cerca");
		idButton.addActionListener(listener);
		curBookLabel = new JLabel("Libro in modifica: ");
		
		
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
		
		scaffaleLabel = new JLabel("Scaffale");
		scaffaleList = new JList<String>(ScaffaleDAO.getInstance().getSettoriScaffali());
		nuovoScaffaleButton = new JButton("Inserisci Nuovo");
		nuovoScaffaleButton.setName("NuovoScaffale");
		nuovoScaffaleButton.addActionListener(listener);
		scaffalePanel = new JPanel();
		scaffalePanel.add(scaffaleList);
		scaffalePanel.add(nuovoScaffaleButton);
		scaffalePanelScroll = new JScrollPane(scaffalePanel);
		
		inserisci = new JButton("Modifica");
		inserisci.setName("Modifica");
		inserisci.addActionListener(listener);
		
		
		this.setLayout(new GridLayout(11,2));
		add(idLabel);
		add(idTextField);
		add(idButton);
		add(curBookLabel);
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
	
	public JFormattedTextField getIdTextField() {
		return idTextField;
	}

	public void SelezionaLibro(String titolo,float prezzo,String ISBN,int idCasaEditrice,int idGenere,int idAutore,int copieDisponibili,int idScaffale)
	{
		idSelected = Integer.parseInt(idTextField.getText());
		
		titoloTextField.setText(titolo);
		prezzoTextField.setValue(prezzo);
		ISBNTextField.setValue(Long.parseLong(ISBN));
		CopieTextField.setText(""+copieDisponibili);
		
		autoreList.setSelectedIndex(AutoreDAO.getInstance().getPositionFromId(idAutore));
		genereList.setSelectedIndex(GenereDAO.getInstance().getPositionFromId(idGenere));
		casaEditriceList.setSelectedIndex(CasaEditriceDAO.getInstance().getPositionFromId(idCasaEditrice));
		scaffaleList.setSelectedIndex(ScaffaleDAO.getInstance().getPositionFromId(idScaffale));
	}
	public int getIdSelected() {
		return idSelected;
	}

	public void Update()//aggiorna le liste di autori, generi, ecc.
	{
		autoreList = new JList(AutoreDAO.getInstance().getNomiAutori());
		autorePanel.removeAll();
		autorePanel.add(autoreList);
		autorePanel.add(nuovoAutoreButton);
		autorePanel.revalidate();
		autorePanel.repaint();
		
		genereList = new JList(GenereDAO.getInstance().getNomiGeneri());
		generePanel.removeAll();
		generePanel.add(genereList);
		generePanel.add(nuovoGenereButton);
		generePanel.revalidate();
		generePanel.repaint();
		
		casaEditriceList = new JList(CasaEditriceDAO.getInstance().getNomiCaseEditrici());
		casaEditricePanel.removeAll();
		casaEditricePanel.add(casaEditriceList);
		casaEditricePanel.add(nuovaCasaEditriceButton);
		casaEditricePanel.revalidate();
		casaEditricePanel.repaint();
		
		scaffaleList = new JList(ScaffaleDAO.getInstance().getSettoriScaffali());
		scaffalePanel.removeAll();
		scaffalePanel.add(scaffaleList);
		scaffalePanel.add(nuovoScaffaleButton);
		scaffalePanel.revalidate();
		scaffalePanel.repaint();
	}

	public JTextField getTitoloTextField() {
		return titoloTextField;
	}

	public JFormattedTextField getPrezzoTextField() {
		return prezzoTextField;
	}

	public JFormattedTextField getISBNTextField() {
		return ISBNTextField;
	}

	public JTextField getCopieTextField() {
		return CopieTextField;
	}

	public JList getAutoreList() {
		return autoreList;
	}

	public JList getGenereList() {
		return genereList;
	}

	public JList getCasaEditriceList() {
		return casaEditriceList;
	}

	public JList getScaffaleList() {
		return scaffaleList;
	}
}
