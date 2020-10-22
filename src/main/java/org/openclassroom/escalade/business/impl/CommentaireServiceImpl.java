package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.CommentaireService;
import org.openclassroom.escalade.dao.CommentaireDao;
import org.openclassroom.escalade.model.CommentaireBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	private CommentaireDao commentaireDao;
	
	@Transactional
	@Override
	public CommentaireBo insertion(CommentaireBo commentaireBo) {
		
		return commentaireDao.insertion(commentaireBo);
	}

	@Override
	public void deleteById(Integer id) {
		commentaireDao.deleteById(id);
		
	}

	@Override
	public CommentaireBo getById(Integer id) {
		
		return commentaireDao.getById(id);
	}

	@Override
	public CommentaireBo update(CommentaireBo commentaireBo) {
		
		return commentaireDao.update(commentaireBo);
	}

	@Override
	public List<CommentaireBo> liste(Integer id) {
		
		return commentaireDao.liste(id);
	}

}
