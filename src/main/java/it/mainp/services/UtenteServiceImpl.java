package it.mainp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.mainp.models.Utente;
import it.mainp.repositories.UtenteRepos;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	UtenteRepos utenteRepos;
	
	public Utente login(String username) {
			
	return utenteRepos.findByUsername(username);
	
	}
	
	public String registraUtente(Utente utente) {

		List<Utente> listaUtenti = utenteRepos.findAll();

		for (Utente u : listaUtenti) {
			if (utente.getIdUtente() == u.getIdUtente())
				return "L'utente è già stato registrato!";
		}
			utenteRepos.save(utente);
			return "L'utente è stato registrato con successo!";

	}

}
