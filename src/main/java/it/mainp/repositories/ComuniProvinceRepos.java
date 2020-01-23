package it.mainp.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import it.mainp.models.ComuniProvince;

public interface ComuniProvinceRepos extends JpaRepository<ComuniProvince, Long> {

	public ComuniProvince findByIdComune(long idComune);
	
}
