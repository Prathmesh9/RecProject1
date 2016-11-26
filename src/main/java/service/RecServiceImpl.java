package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;

import implimentation.RecImpl;
import implimentation.RedisImpl;
import model.RecModel;

public class RecServiceImpl implements RecService{

	@Autowired
	RecImpl recImpl;
	
	@Autowired
	RedisImpl redisImpl;
	
	public RecModel getEntry(String contentId) {
		return recImpl.getEntry(contentId);
	}
	
	public void addVisitor(RecModel rm) {
		System.out.println("visitor_id: "+rm.getmVisitorID()+" visitor mview:"+rm.getmView());
		redisImpl.addVisitorView(rm);
		redisImpl.addVisitorDownload(rm);
		redisImpl.addContentID(rm);
	}
	
	public void createContentIDMap(){
		redisImpl.createContentIDMap();
	}
	
	public Set<String> getSuggestion(RecModel rm){
		return redisImpl.getSuggestion(rm.getmContentID(), rm.getmVisitorID());
		
	}
	public void addToContentMap(RecModel rm){
		redisImpl.addToContentMap(rm);
	}
	
	public void onStartUp() {
		FileReader fr;
		String[] entryData;
		String temp = "visitor_id";
		int i;
		try {
			fr = new FileReader("/home/bridgeit/contentDb.csv");
			BufferedReader br = new BufferedReader(fr);
			String entry;
			entry = br.readLine();
			entryData = entry.split("\\,");

			for (i = 0; i < entryData.length; i++) {
				System.out.print(i + " " + entryData[i] + " ");
			}

			while (entry != null) {
				entryData = entry.split("\\,");
				System.out.println(entry);
				for (i = 0; i < entryData.length; i++) {
					entryData[i] = entryData[i].replace("\"", "");
				}

				if (!(entryData[0].equals(temp))) {
					RecModel rm = new RecModel(entryData[0], entryData[1], entryData[2], entryData[3], entryData[4],
							entryData[5]);
					this.addVisitor(rm);
				}
				entry = br.readLine();
			}
			System.out.println("Start map");
			redisImpl.createContentIDMap();
			System.out.println();
			System.out.println("Exit");
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		// return "redirect:/get";
	}


}
