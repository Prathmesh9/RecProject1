package implimentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.stream.JsonReader;

import model.RecModel;
import service.RecServiceImpl;

@Component
public class StartUp implements ServletContextListener {

	/*@Autowired
	RecServiceImpl recSerImpl;*/

	public void onStartUp() {

		// return "redirect:/get";
	}

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent event) {
		FileReader fr;
		String[] entryData;
		String temp = "visitor_id";
		int i;
		try {
			final WebApplicationContext springContext = WebApplicationContextUtils
					.getWebApplicationContext(event.getServletContext());
			System.out.println(springContext);
			final RecServiceImpl recSer = (RecServiceImpl) springContext.getBean("recSerImpl");

			HashMap<String, String> hmap=new HashMap<>();
			JsonReader reader = new JsonReader(new FileReader("abc.json"));
			reader.beginObject();
			while(reader.hasNext()){
				hmap.put(reader.nextName(), reader.nextString());
			}
			
			fr = new FileReader("/home/bridgeit/contentTrial.csv");
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
							entryData[5],hmap.get(entryData[3]));
					recSer.addVisitor(rm);
					recSer.addToDao(rm);
				}
				entry = br.readLine();
			}
			System.out.println("Start map");
			recSer.createContentIDMap();
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

	}
}
