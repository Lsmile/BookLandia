package it.unisalento.BookLandia.view.northpan;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.enums.EnumUtils;
import it.unisalento.BookLandia.listener.NorthPanelListener;
import it.unisalento.BookLandia.view.MainFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NorthPanel extends JPanel {
	private JButton loginButton; //bottone per far comparire i campi di login
	private JButton RegistrationButton;
	private JTextField username;	//campo di testo username
	private JPasswordField password; 	//campo di testo password
	private JButton confirmButton; //bottone di conferma credenziali di login
	private JButton Indietro;
	NorthPanelListener listener; //listener comune per tutto il pannello
	
	private JLabel youAreLogged;
	private JButton logoutButton;
	
	private MainFrame frame; //frame necessario per i cambiamenti nel login
	
	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public NorthPanel(MainFrame source)
	{
		listener = new NorthPanelListener(this,source);
		
		loginButton = new JButton(new ImageIcon("assets/utente.png"));
		loginButton.setName("Login");
		loginButton.addActionListener(listener);
		
		username = new JTextField();
		username.setColumns(10);
		username.setText("username");
		password = new JPasswordField();
		password.setColumns(10);
		password.setText("password");
		password.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				password.setText("");
			}
		});
		
		confirmButton = new JButton(new ImageIcon("assets/accedi.png"));
		confirmButton.setName("Entra");
		confirmButton.addActionListener(listener);
		
		Indietro = new JButton(new ImageIcon("assets/indietro.png"));
		Indietro.setName("Indietro");
		Indietro.addActionListener(listener);
		
		youAreLogged = new JLabel("");//mostrerà le informazioni di nome, cognome e tipo dell'utente corrente, va settata sul momento
		logoutButton = new JButton("Logout");
		logoutButton.setName("Logout");
		logoutButton.addActionListener(listener);
		
		add(loginButton);
		
		RegistrationButton = new JButton(new ImageIcon("assets/registrati.png"));
		RegistrationButton.setName("Registration");
		RegistrationButton.addActionListener(listener);
		
		add(RegistrationButton);
	}
	
	public void loginView()//change the view to login form
	{
		remove(loginButton);
		remove(RegistrationButton);
		add(username);
		add(password);
		add(confirmButton);
		add(Indietro);
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
	}
	
	public void loginDone()//change the view to login
	{
		remove(username);
		remove(password);
		remove(confirmButton);
		remove(Indietro);
		//in breve l'istruzione sotto costruisce la stringa con le informazioni che servono
		youAreLogged.setText("Ciao "+UserManager.getInstance().getCurUser().getNome()+" "+UserManager.getInstance().getCurUser().getCognome()+", ti sei autenticato come "+EnumUtils.getStringFromType(UserManager.getInstance().getUtente_connesso()));
		add(youAreLogged);
		add(logoutButton);
		
		revalidate();
		repaint();
	}

	public void logoutDone() {
		youAreLogged.setText("");
		remove(youAreLogged);
		remove(logoutButton);
		username.setText("username");
		password.setText("password");
		add(username);
		add(password);
		add(confirmButton);
		add(Indietro);
		
		revalidate();
		repaint();
	}
	
	public void Back() {
		remove(username);
		remove(password);
		remove(confirmButton);
		remove(Indietro);
		username.setText("username");
		password.setText("password");
		add(loginButton);
		add(RegistrationButton);
		
		revalidate();
		repaint();
	}
	
	
}
