package it.unisalento.BookLandia.model;

import it.unisalento.BookLandia.dao.UtenteDAO;
import it.unisalento.BookLandia.enums.UserType;

public class Utente {

	private int ID;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String codice_fiscale;
	

	public Utente(int iD, String nome, String cognome, String username,
			String password) {
		super();
		ID = iD;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	
	public UserType login() {
		int ID = UtenteDAO.getInstance().login(username, password);
		if(ID==-1) return UserType.NESSUNO;
		this.ID = ID;
		UserType userType = UtenteDAO.getInstance().getType(this.ID);
		this.nome = UtenteDAO.getInstance().getName(this.ID);
		this.cognome = UtenteDAO.getInstance().getSurname(this.ID);
		return userType;
	}
	
	public Utente() {
		
	}

	public Utente(String nome, String cognome, int utenteID) {
		this.nome = nome;
		this.cognome = cognome;
		this.ID = utenteID;
	}
}
