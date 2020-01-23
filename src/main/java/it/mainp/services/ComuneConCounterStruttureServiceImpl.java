package it.mainp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.mainp.dto.ComuneConCounterStrutture;
import it.mainp.models.ComuniProvince;
import it.mainp.repositories.ComuniProvinceRepos;


@Service
public class ComuneConCounterStruttureServiceImpl implements ComuneConCounterStruttureService {

	@Autowired
	ComuniProvinceRepos comuniProvinceRepos;



	public List<ComuneConCounterStrutture> trovaComuni() {
		List<ComuniProvince> listaComuni = comuniProvinceRepos.findAll();
		List<ComuneConCounterStrutture> comuniConCounterLista = new ArrayList<ComuneConCounterStrutture>();
		for (ComuniProvince c : listaComuni) {
			ComuneConCounterStrutture comuneCounter = new ComuneConCounterStrutture();
			comuneCounter.setIdComune(c.getIdComune());
			comuneCounter.setNome(c.getNome());
			comuneCounter.setProvincia(c.getProvincia());
		    comuneCounter.setAsiliNido(c.getAsiliNido().size());
		    comuneCounter.setResidenzeAnziani(c.getResidenzeAnziani().size());
		    comuneCounter.setResidenzeDisabili(c.getResidenzeDisabili().size());
			comuniConCounterLista.add(comuneCounter);
		}
		return comuniConCounterLista;

	}

}
