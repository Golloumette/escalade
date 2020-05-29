package org.openclassroom.escalade.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.model.SiteBo;
import org.springframework.stereotype.Service;
@Service
public class SiteServiceImpl implements SiteService {

		// TODO Auto-generated method stub
		public List<SiteBo> liste() {
			List<SiteBo> siteBos = new ArrayList<SiteBo>();
			
			SiteBo siteBo = new SiteBo();
			siteBo.setId(1);
			siteBo.setNom("La reunion");
			siteBo.setLieu("Saint Denis");
			siteBos.add(siteBo);

			siteBo = new SiteBo();
			siteBo.setId(2);
			siteBo.setNom("France");
			siteBo.setLieu("Paris");
			siteBos.add(siteBo);
			
			return siteBos;
			
		}

	

}
