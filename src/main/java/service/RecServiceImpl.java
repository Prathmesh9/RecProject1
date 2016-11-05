package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.RecDaoImpl;
import model.RecModel;

public class RecServiceImpl implements RecService{

	@Autowired
	RecDaoImpl recDaoImpl;
	
	public RecModel getEntry(String contentId) {
		return recDaoImpl.getEntry(contentId);
	}

}
