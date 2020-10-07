package org.openclassroom.escalade.business;

import org.openclassroom.escalade.model.CommentaireBo;

public interface CommentaireService {
	public CommentaireBo insertion (CommentaireBo commentaireBo);
	public void deleteById(Integer id);
	public CommentaireBo getById(Integer id);
	public CommentaireBo update(CommentaireBo commentaireBo);

}
