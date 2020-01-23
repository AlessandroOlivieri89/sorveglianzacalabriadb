package it.mainp.dto;

import it.mainp.models.Ruolo;

public class LoggedUtente {
	private String username;
	
	private long idComune;
	
	private Ruolo ruolo;
	
	

	public LoggedUtente() {

	}

	
	public long getIdComune() {
		return idComune;
	}


	public void setIdComune(long idComune) {
		this.idComune = idComune;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
