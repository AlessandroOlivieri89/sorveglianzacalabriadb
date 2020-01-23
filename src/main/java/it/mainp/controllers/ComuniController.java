package it.mainp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mainp.dto.ComuneConCounterStrutture;
import it.mainp.dto.LoggedUtente;
import it.mainp.models.ComuniProvince;
import it.mainp.services.ComuneConCounterStruttureService;
import it.mainp.services.ComuniProvinceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class ComuniController {

	@Autowired
	ComuniProvinceService comuniProvinceService;
	@Autowired
	ComuneConCounterStruttureService comuneConCounterStruttureService;

	@GetMapping("comuni")
	public List<ComuneConCounterStrutture> tuttiComuniConCounter() {
		List<ComuneConCounterStrutture> tuttiComuni = comuneConCounterStruttureService.trovaComuni();
		return tuttiComuni;




	}

	@PostMapping("comuni/{idComune}")
	public ComuniProvince trovaComunePerId(@RequestBody LoggedUtente utenteLoggato,
			@PathVariable(value = "idComune") long idComune) {
		if (utenteLoggato.getIdComune() == 0) {
			ComuniProvince comunePerIdAmministratore = comuniProvinceService.trovaComunePerId(idComune);
			return comunePerIdAmministratore;
			
		} else if (utenteLoggato.getIdComune() == idComune) {
			ComuniProvince comunePerId = comuniProvinceService.trovaComunePerId(idComune);
			return comunePerId;
		}
		return null;

	}

	@PutMapping("comuni/{idComune}")
	public ComuniProvince aggiornaStrutturePerComune(@RequestBody ComuniProvince comuniProvince) {

		return comuniProvinceService.modificaComune(comuniProvince);

	}

}
