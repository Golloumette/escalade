package org.openclassroom.escalade.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.dao.SiteDao;
import org.openclassroom.escalade.model.SiteBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SiteServiceImpl implements SiteService {
@Autowired
private SiteDao siteDao;		
		public List<SiteBo> liste() {
					
			return siteDao.liste();
			
			
					
		}
		public List<SiteBo> liste(Integer id) {
			
			return siteDao.liste(id);
		}
		@Transactional
		public SiteBo insertion (SiteBo siteBo) {
			return siteDao.insertion(siteBo);
		}
		@Override
		@Transactional
		public SiteBo update(SiteBo siteBo) {
		
			return siteDao.update(siteBo);
		}
		@Override
		public SiteBo getById(Integer id) {
			
			return siteDao.getById(id);
		}
		@Override
		@Transactional
		public void deleteById(Integer id) {	
			 siteDao.deleteById(id);
		}
		@Override
		public List<SiteBo> liste(String nom) {
			// TODO Auto-generated method stub
			return siteDao.liste(nom);
		}
		@Override
		public List<SiteBo> liste(String lieu, Integer nbSecteur, Byte cotation) {
			List<SiteBo> siteBos= new ArrayList<SiteBo>();
			List<Object[]> vars  = siteDao.listeCotation(lieu, nbSecteur, cotation);
			for (Object[] var: vars) {
			SiteBo siteBo = this.getById((int) var[0]);
			siteBos.add(siteBo);
			}
			
			
			return siteBos;
		}

	

}
