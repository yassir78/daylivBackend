package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommentaireDao;
import com.dayliv.dayliv.model.Commentaire;
import com.dayliv.dayliv.service.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    private CommentaireDao commentaireDao;
	@Override
	public List<Commentaire> findAll() {
		// TODO Auto-generated method stub
		return commentaireDao.findAll();
	}

}
