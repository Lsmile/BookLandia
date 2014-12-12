package it.unisalento.BookLandia.view.northpan;


import it.unisalento.BookLandia.listener.NorthPanelListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NorthPanel extends JPanel {
	private JButton loginButton; //bottone per far comparire i campi di login
	private JTextField username;	//campo di testo username
	private JPasswordField password; 	//campo di testo password
	private JButton confirmButton; //bottone di conferma credenziali di login
	NorthPanelListener listener; //listener comune per tutto il pannello
	
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

	public NorthPanel()
	{
		listener = new NorthPanelListener(this);
		
		loginButton = new JButton();
		loginButton.setText("Accedi come utente");
		loginButton.setName("Login");
		loginButton.addActionListener(listener);
		
		username = new JTextField();
		username.setColumns(10);
		username.setText("username");
		password = new JPasswordField();
		password.setColumns(10);
		password.setText("password");
		
		confirmButton = new JButton();
		confirmButton.setText("Accedi");
		confirmButton.setName("Entra");
		confirmButton.addActionListener(listener);
		
		add(loginButton);
	}
	
	public void loginView()//change the view to login
	{
		remove(loginButton);
		add(username);
		add(password);
		add(confirmButton);
		revalidate();// servono per rivalidare e ridisegnare il pannello per i suoi cambiamenti
		repaint();	//
	}
	
	
}
