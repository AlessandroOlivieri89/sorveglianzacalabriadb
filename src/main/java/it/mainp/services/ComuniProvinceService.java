package it.mainp.services;

import java.util.List;

import it.mainp.models.ComuniProvince;

public interface ComuniProvinceService {

	List<ComuniProvince> trovaComuni();

	ComuniProvince trovaComunePerId(long idComune);

	ComuniProvince modificaComune(ComuniProvince comuniProvince);


}
