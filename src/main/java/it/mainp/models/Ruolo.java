package it.mainp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ruolo")
public class Ruolo {

	@Id
	@GeneratedValue
	private long idRuolo;
	private String tipo;

	public Ruolo() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getIdRuolo() {
		return idRuolo;
	}

	


	
}
