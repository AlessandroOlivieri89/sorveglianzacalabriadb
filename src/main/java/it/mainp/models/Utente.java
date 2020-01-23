package it.mainp.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUtente;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "id_ruolo_utente")
	@JsonBackReference
	private Ruolo ruolo;

	
	@OneToOne
	private ComuniProvince comuniProvince;
	



	public Utente() {
	}

	
	public ComuniProvince getComuniProvince() {
		return comuniProvince;
	}


	public long getIdUtente() {
		return idUtente;
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

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}



	
}
