package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List <String> lista;
		
	public Parole() {
		lista = new LinkedList<String>();
		//ArrayList ci mette molto a cancellare un dato
	}
	
	public void addParola(String p) {
			lista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(lista);
		
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public void cancella (String p) {
		lista.remove(p);
	}

}
