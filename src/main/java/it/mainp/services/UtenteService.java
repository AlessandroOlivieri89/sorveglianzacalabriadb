package it.mainp.services;

import it.mainp.models.Utente;

public interface UtenteService {

	Utente login(String username);

	String registraUtente(Utente utente);

}
