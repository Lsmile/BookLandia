package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.business.GestoreDati;
import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.model.Libro;

import java.util.Vector;

public class RicercaDAO {
		String Base;
		String Estensione_Titolo;
		String Estensione_Autore;
		String Estensione_CasaEditrice;
		String Estensione_Genere;
		String query;
		Vector<Libro> Libri = new Vector<Libro>();
		Vector<String[]> RisultatoQuery = new Vector<String[]>();
		private static RicercaDAO instance;

		
		public static RicercaDAO getInstance() {
			   instance = null;
				   instance = new RicercaDAO();
			   return instance;
		   }
		
		//ritorna una matrice con i dati da rappresentare
		public RicercaDAO()
		{
			Base = "SELECT Titolo, Prezzo, ISBN, CopieDisponibili, "
					+ "Autori.Nome as Nome_Autore, Autori.Cognome "
					+ "as Cognome_Autore, Case_Editrici.Nome as Casa_Editrice, "
					+ "Generi.Nome from Libri INNER JOIN Generi ON Generi_Codice_Genere"
					+ " = Codice_Genere INNER JOIN Case_Editrici ON Case_Editrici_ID_Casa_Editrice = "
					+ "ID_Casa_Editrice INNER JOIN Autori ON Autori_Codice_Autore = Codice_Autore";
			
					
		}
		
		public int getNumeroLibri(GestoreDati Dati)
		{
			Base = "SELECT COUNT(Titolo, Autori.Nome as NomeAutore, Autori.Cognome as CognomeAutore) from Libri INNER JOIN Generi ON Generi_Codice_Genere"
					+ " = Codice_Genere INNER JOIN Case_Editrici ON Case_Editrici_ID_Casa_Editrice = "
					+ "ID_Casa_Editrice INNER JOIN Autori ON Autori_Codice_Autore = Codice_Autore";
			
			//Stringa per il Titolo
//			if (Dati.getTitolo().compareTo("") != 0)
//			{
//			Estensione_Titolo =  " where Titolo ='" + Dati.getTitolo()+"'";
//			}
//			else
//			{
//			Estensione_Titolo = "";
//			}
			
			//stringa per l'autore
			if (Dati.getAutore().compareTo("") != 0)
			{
			Estensione_Autore =  " where NomeAutore ='" + Dati.getAutore()+"' ";
			}
			else
			{
			Estensione_Autore = "";
			}
			
			//Stringa per il Genere
			if (Dati.getGenere().compareTo("") != 0)
			{
			Estensione_Genere =  " where Genere ='" + Dati.getGenere()+"'" + " ";
			}
			else
			{
			Estensione_Genere = "";
			}
			
			//Estensione per la casa editrice
			if (Dati.getCasaEditrice().compareTo("") != 0)
			{
			Estensione_CasaEditrice =  " where Casa_Editrice ='" + Dati.getTitolo()+"'";
			}
			else
			{
			Estensione_CasaEditrice = "";
			}
			query = Base + " " +  Estensione_Titolo + " " + Estensione_Autore + " "+ Estensione_CasaEditrice + " " + Estensione_Genere;
			return Integer.parseInt((DbConnection.getInstance().eseguiQuery(query).get(0)[0]));
		}

		public Vector<Libro> getLibri(GestoreDati Dati) {
			
			if (Dati.getTitolo().compareTo("") != 0)
			{
			Estensione_Titolo =  " where Titolo ='" + Dati.getTitolo()+"'" + " ";
			}
			else
			{
			Estensione_Titolo = "";
			}
			
			//stringa per l'autore
			if (Dati.getAutore().compareTo("") != 0)
			{
			Estensione_Autore =  "where Autore ='" + Dati.getAutore()+"' ";
			}
			else
			{
			Estensione_Autore = "";
			}
			
			//Stringa per il Genere
			if (Dati.getGenere().compareTo("") != 0)
			{
			Estensione_Genere =  " where Genere ='" + Dati.getGenere()+"'" + " ";
			}
			else
			{
			Estensione_Genere = "";
			}
			
			//Estensione per la casa editrice
			if (Dati.getCasaEditrice().compareTo("") != 0)
			{
			Estensione_CasaEditrice =  " where Casa_Editrice ='" + Dati.getTitolo()+"'" + " ";
			}
			else
			{
			Estensione_CasaEditrice = "";
			}
			query = Base + " " +  Estensione_Titolo + " " + Estensione_Autore;
			
			Libri.clear();
			RisultatoQuery = DbConnection.getInstance().eseguiQuery(query);
			for(int z = 0; z < RisultatoQuery.size(); z++)
			{
				// to do: convertire stringhe in numeri e aggiungere lo scaffale alla query
				Libri.add(new Libro(RisultatoQuery.get(z)[0], Double.parseDouble(RisultatoQuery.get(z)[1]),RisultatoQuery.get(z)[2],Integer.parseInt(RisultatoQuery.get(z)[3]),RisultatoQuery.get(z)[4], RisultatoQuery.get(z)[5], RisultatoQuery.get(z)[6], RisultatoQuery.get(z)[7],"tmpScaffale",0,0));
			}
			return Libri;
		}
}
