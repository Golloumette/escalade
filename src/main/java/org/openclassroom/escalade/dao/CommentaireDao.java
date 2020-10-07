package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.CommentaireBo;

public interface CommentaireDao {

	public CommentaireBo insertion(CommentaireBo commentaireBo);

	public void deleteById(Integer id);

	public CommentaireBo update(CommentaireBo commentaireBo);

	public CommentaireBo getById(Integer id);

	public List<CommentaireBo> commentaire();
	
	public List<CommentaireBo> liste(Integer id);

}
