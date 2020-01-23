package it.mainp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mainp.models.AsiloNido;
import it.mainp.models.ComuniProvince;
import it.mainp.models.ResidenzaAnziani;
import it.mainp.models.ResidenzaDisabili;
import it.mainp.repositories.AsiloNidoRepos;
import it.mainp.repositories.ComuniProvinceRepos;
import it.mainp.repositories.ResidenzaAnzianiRepos;
import it.mainp.repositories.ResidenzaDisabiliRepos;
import it.mainp.repositories.UtenteRepos;

@Service
public class ComuniProvinceServiceImpl implements ComuniProvinceService {

	@Autowired
	ComuniProvinceRepos comuniProvinceRepos;
	@Autowired
	UtenteRepos utenteRepos;
	@Autowired
	AsiloNidoRepos asiloNidoRepos;
	@Autowired
	ResidenzaAnzianiRepos residenzaAnzianiRepos;
	@Autowired
	ResidenzaDisabiliRepos residenzaDisabiliRepos;
	
	public List<ComuniProvince> trovaComuni() {

		List<ComuniProvince> listaComuni = comuniProvinceRepos.findAll();

		return listaComuni;

	}

	public ComuniProvince trovaComunePerId(long idComune) {

		ComuniProvince comuniProvince = comuniProvinceRepos.findByIdComune(idComune);

		return comuniProvince;

	}

        @Transactional
        public ComuniProvince modificaComune(ComuniProvince comuniProvince) {
        
		List<AsiloNido> listaAsiliComuneEsterno = comuniProvince.getAsiliNido();
		List<ResidenzaAnziani> listaResidenzaAnzianiComuneEsterno = comuniProvince.getResidenzeAnziani();
    	List<ResidenzaDisabili> listaResidenzaDisabiliComuneEsterno = comuniProvince.getResidenzeDisabili();
		ComuniProvince comuneConListaStruttureAggiornate = new ComuniProvince();
		comuneConListaStruttureAggiornate.setIdComune(comuniProvince.getIdComune());
		comuneConListaStruttureAggiornate.setNome(comuniProvince.getNome());
		comuneConListaStruttureAggiornate.setProvincia(comuniProvince.getProvincia());
		comuneConListaStruttureAggiornate.setAsiliNido(listaAsiliComuneEsterno);
		comuneConListaStruttureAggiornate.setResidenzeAnziani(listaResidenzaAnzianiComuneEsterno);
		comuneConListaStruttureAggiornate.setResidenzeDisabili(listaResidenzaDisabiliComuneEsterno);
		ComuniProvince comuneDaModificare = comuniProvinceRepos.findByIdComune(comuniProvince.getIdComune());
		List<AsiloNido> listaAsiliComuneInterno = comuneDaModificare.getAsiliNido();
		boolean x = false;
		for(AsiloNido aInterno : listaAsiliComuneInterno) {
		
			for(AsiloNido aEsterno : listaAsiliComuneEsterno) {
				
				if(aInterno.getIdAsilo()==aEsterno.getIdAsilo()) 
					x=true;
				
				else 
					x=false;
			}
			
			if (x == false) {
				asiloNidoRepos.deleteById(aInterno.getIdAsilo());	
			}
			
		}
		x=false;
		
		List<ResidenzaAnziani> listaResidenzaAnzianiComuneInterno = comuneDaModificare.getResidenzeAnziani();
		
		for(ResidenzaAnziani raInterno : listaResidenzaAnzianiComuneInterno) {
		
			for(ResidenzaAnziani raEsterno : listaResidenzaAnzianiComuneEsterno) {
				
				if(raInterno.getIdResidenzaAnziani()==raEsterno.getIdResidenzaAnziani())
					x=true;
				
				else 
					x=false;
			}
			
			if (x == false) {
				residenzaAnzianiRepos.deleteById(raInterno.getIdResidenzaAnziani());
		    	    			
			}
		}
		x=false;
		
		List<ResidenzaDisabili> listaResidenzaDisabiliComuneInterno = comuneDaModificare.getResidenzeDisabili();
		
		for(ResidenzaDisabili rdInterno : listaResidenzaDisabiliComuneInterno) {
		
			for(ResidenzaDisabili rdEsterno : listaResidenzaDisabiliComuneEsterno) {
				
				if(rdInterno.getIdResidenzaDisabili()==rdEsterno.getIdResidenzaDisabili())
					x=true;
				
				else 
					x=false;
			}
			
			if (x == false) {
				residenzaDisabiliRepos.deleteById(rdInterno.getIdResidenzaDisabili());
		    	    			
			}
		}
		
		comuniProvinceRepos.save(comuneConListaStruttureAggiornate);
		     return comuneConListaStruttureAggiornate;
	}
		
	}


       

