package it.mainp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mainp.dto.Response;
import it.mainp.dto.LoggedUtente;
import it.mainp.models.Utente;
import it.mainp.services.UtenteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/utente")
public class UtenteController {
	@Autowired
	UtenteService utenteService;

	@PostMapping("/login")
	public Response exist(@RequestHeader ("username")String username, @RequestHeader("password") String password) {
		if (utenteService.login(username) != null) {
			Utente utenteRepos = utenteService.login(username);
			if (utenteRepos.getPassword().equals(password)) {
				Response responsePositiva = new Response();
				LoggedUtente utenteLoggato = new LoggedUtente();
				utenteLoggato.setIdComune(utenteRepos.getComuniProvince().getIdComune());
				utenteLoggato.setUsername(utenteRepos.getUsername());
				utenteLoggato.setRuolo(utenteRepos.getRuolo());
				responsePositiva.setCorrect(true);
			    responsePositiva.setUtenteLoggato(utenteLoggato);
				return responsePositiva;
			} else {
				Response combinazioneUtente = new Response();
				combinazioneUtente.setCorrect(false);
				return combinazioneUtente;
			}
		}
		
		Response combinazioneUtente = new Response();
		combinazioneUtente.setCorrect(false);
		return combinazioneUtente;
		
	}
	
	@PostMapping("/nuovo")
	public String registraUtente(@RequestBody Utente utente) {
		return utenteService.registraUtente(utente);
		
	}

}
