package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.CommentaireBo;

public interface CommentaireService {
	public CommentaireBo insertion (CommentaireBo commentaireBo);
	public void deleteById(Integer id);
	public CommentaireBo getById(Integer id);
	public CommentaireBo update(CommentaireBo commentaireBo);
	public List<CommentaireBo> liste(Integer id);

}
