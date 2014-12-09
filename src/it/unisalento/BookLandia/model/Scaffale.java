package it.unisalento.BookLandia.model;

public class Scaffale {
	String settore;
	int numeroScaffale;
	int numeroLibreria;
	
	public Scaffale(String settore, int numeroScaffale, int numeroLibreria)
	{
		this.numeroLibreria = numeroLibreria;
		this.numeroScaffale = numeroScaffale;
		this.settore = settore;
	}
}
