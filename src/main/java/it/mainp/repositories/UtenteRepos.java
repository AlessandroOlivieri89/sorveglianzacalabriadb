package it.mainp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import it.mainp.models.Utente;

public interface UtenteRepos extends JpaRepository<Utente, Long>{

	Utente findByUsername(String username);
	

}
