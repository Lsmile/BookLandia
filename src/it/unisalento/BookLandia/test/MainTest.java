package it.unisalento.BookLandia.test;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String query = "Select * from libri";
		String query = "Insert into Generi values ('Azione', 0);";
		DbConnection.getInstance().eseguiAggiornamento(query);
		DbConnection.getInstance().disconnetti();
	}

}
