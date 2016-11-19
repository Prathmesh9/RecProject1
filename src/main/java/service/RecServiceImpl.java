package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.RecDaoImpl;
import dao.RedisDaoImpl;
import model.RecModel;

public class RecServiceImpl implements RecService{

	@Autowired
	RecDaoImpl recDaoImpl;
	
	@Autowired
	RedisDaoImpl redisDaoImpl;
	
	public RecModel getEntry(String contentId) {
		return recDaoImpl.getEntry(contentId);
	}
	
	public void addVisitor(RecModel rm) {
		redisDaoImpl.addVisitorView(rm);
		redisDaoImpl.addVisitorDownload(rm);
		redisDaoImpl.addContentID(rm);
	}
	
	public void createContentIDMap(){
		redisDaoImpl.createContentIDMap("VISITOR_ID_VIEW_SET","one");
		redisDaoImpl.createContentIDMap("VISITOR_ID_DOWNLOAD_SET","two");
	}

}
