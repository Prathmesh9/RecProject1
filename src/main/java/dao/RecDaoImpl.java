package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import model.RecModel;

@Repository
public class RecDaoImpl implements RecDao{

	public RecModel getEntry(String contentId) {
		FileReader fr;
		String[] entryData;
		int i;
		RecModel record = null;
		try {

			/*-----Read File-----*/
			fr = new FileReader("/home/bridgeit/Prathmesh/PrathmeshC/contentTrenddata.csv");
			BufferedReader br = new BufferedReader(fr);
			boolean fl = false;
			String entry;

			/*-----Reading first line of file-----*/
			entry = br.readLine();
			entryData = entry.split("\\,");
			
			/*-----Read a file line by line-----*/
			while (entry != null && fl == false) {

				/*-----Separating out different values in column-----*/
				entryData = entry.split("\\,");

				/*-----Removing quotes from each value-----*/
				for (i = 0; i < entryData.length; i++) {
					entryData[i] = entryData[i].replace("\"", "");
				}

				/*-----Finding required contentId and creating object-----*/
				if (entryData[1].equals(contentId)) {
						record = new RecModel(entryData[1], entryData[0], entryData[2], entryData[3],
								entryData[4],entryData[5]);
						fl = true;
					}
				entry = br.readLine();
			}

			/*-----Closing of buffered reader and file-----*/
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException o) {
			o.printStackTrace();
		}
		return record;
	}

}
