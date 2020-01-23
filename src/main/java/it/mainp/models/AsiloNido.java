package it.mainp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name= "strutture_asili")
public class AsiloNido {

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private long idAsilo;
	
	@Column (name = "nome_asilo")
	private String nome;
	
	private String indirizzo;
	
	private int telefono;
	
	private long numeroStanze;
	
	@ManyToOne
	@JoinColumn (name = "asiloIdComune")
	@JsonBackReference
	private ComuniProvince comuniProvince;
	

	public AsiloNido() {
		
	}

	

	public long getIdAsilo() {
		return idAsilo;
	}
	



	public void setIdAsilo(long idAsilo) {
		this.idAsilo = idAsilo;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ComuniProvince getComuniProvince() {
		return comuniProvince;
	}

	public void setComuniProvince(ComuniProvince comuniProvince) {
		this.comuniProvince = comuniProvince;
	}

	public long getNumeroStanze() {
		return numeroStanze;
	}

	public void setNumeroStanze(long numeroStanze) {
		this.numeroStanze = numeroStanze;
	}

	
}
