package it.mainp.dto;


public class ComuneConCounterStrutture {
	
	private long idComune;
	
	private String nome; 
	
	private String provincia;
	
	private long asiliNido;
	
	private long residenzeAnziani;
	
	private long residenzeDisabili;
	
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
	public long getAsiliNido() {
		return asiliNido;
	}
	public void setAsiliNido(long asiliNido) {
		this.asiliNido = asiliNido;
	}
	public long getResidenzeAnziani() {
		return residenzeAnziani;
	}
	public void setResidenzeAnziani(long residenzeAnziani) {
		this.residenzeAnziani = residenzeAnziani;
	}
	public long getResidenzeDisabili() {
		return residenzeDisabili;
	}
	public void setResidenzeDisabili(long residenzeDisabili) {
		this.residenzeDisabili = residenzeDisabili;
	}
	
}
