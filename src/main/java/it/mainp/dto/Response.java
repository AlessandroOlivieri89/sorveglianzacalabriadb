package it.mainp.dto;

public class Response {
	
	private LoggedUtente utenteLoggato;

	private boolean isCorrect = true;
	
	public LoggedUtente getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(LoggedUtente utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}


	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Response() {

	}

}
