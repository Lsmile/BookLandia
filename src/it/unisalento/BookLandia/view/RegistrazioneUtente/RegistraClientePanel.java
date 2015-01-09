package it.unisalento.BookLandia.view.RegistrazioneUtente;

import java.awt.GridLayout;

import it.unisalento.BookLandia.listener.RegistraUtenteListener;
import it.unisalento.BookLandia.view.ricerca.CampiTesto;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class RegistraClientePanel extends JPanel {
JLabel UserNameLbl = new JLabel("Username: ");
JLabel PasswordLbl = new JLabel("Password: ");
JLabel NomeLbl = new JLabel("Nome: ");
JLabel CognomeLbl = new JLabel("Cognome");
JLabel Codice_FiscaleLbl = new JLabel("Codice Fiscale:");
CampiTesto UserNameTxt = new CampiTesto();
JPasswordField PasswordTxt = new JPasswordField();
CampiTesto NomeTxt = new CampiTesto();
CampiTesto CognomeTxt = new CampiTesto();
CampiTesto Codice_FiscaleTxt = new CampiTesto();
JButton Registra = new JButton("Registra");
RegistraUtenteListener listener = new RegistraUtenteListener(this);

public RegistraClientePanel()
{
	super();
	this.setLayout(new GridLayout(6,2));
	listener = new RegistraUtenteListener(this);
	this.add(UserNameLbl);
	this.add(UserNameTxt);
	this.add(PasswordLbl);
	this.add(PasswordTxt);
	this.add(NomeLbl);
	this.add(NomeTxt);
	this.add(CognomeLbl);
	this.add(CognomeTxt);
	this.add(Codice_FiscaleLbl);
	this.add(Codice_FiscaleTxt);
	
	Registra.addActionListener(listener);
	this.add(Registra);
}

public String getUsername()
{
	return UserNameTxt.getText();
}

@SuppressWarnings("deprecation")
public String getPassword()
{
	return PasswordTxt.getText();
}

public String getNome()
{
	return NomeTxt.getText();
}

public String getCognome()
{
	return CognomeTxt.getText();
}

public String getCodiceFiscale()
{
	return Codice_FiscaleTxt.getText();
}


}
