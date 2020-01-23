package it.mainp.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "comuniprovince")
public class ComuniProvince {
	
	@Id
	
	private long idComune;

	@Column (name = "nome_comune")

	private String nome;
	
	private String provincia;
    
	@OneToMany(mappedBy="comuniProvince", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	private List<AsiloNido> asiliNido;
		
	@OneToMany (mappedBy = "comuniProvince", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	private List <ResidenzaAnziani> residenzeAnziani;
	
	@OneToMany (mappedBy = "comuniProvince", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	private List <ResidenzaDisabili> residenzeDisabili;

	
	
	

	public ComuniProvince() {
	}

	public long getIdComune() {
		return idComune;
	}
	

	public void setIdComune(long idComune) {
		this.idComune = idComune;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public List<AsiloNido> getAsiliNido() {
		return asiliNido;
	}

	public void setAsiliNido(List<AsiloNido> asiliNido) {
		this.asiliNido = asiliNido;
	}

	public List<ResidenzaAnziani> getResidenzeAnziani() {
		return residenzeAnziani;
	}

	public void setResidenzeAnziani(List<ResidenzaAnziani> residenzeAnziani) {
		this.residenzeAnziani = residenzeAnziani;
	}

	public List<ResidenzaDisabili> getResidenzeDisabili() {
		return residenzeDisabili;
	}

	public void setResidenzeDisabili(List<ResidenzaDisabili> residenzeDisabili) {
		this.residenzeDisabili = residenzeDisabili;
	}


	
}
