package dataCollectExtract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWriting {
	public static void main(String[] args) {
		String outfilename = "C:\\Users\\SH\\workspace\\cookbook\\files\\test.json";
		
		//JsonWriting.writeJson(outfilename);
		JsonWriting.readJson(outfilename);
	}
	public static void writeJson(String outFileName) {
		JSONObject obj = new JSONObject();
		obj.put("book", "Harry Potter and the Philosopher's Stone");
		obj.put("author", "J. K. Rowling");
		
		JSONArray list = new JSONArray();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		obj.put("messages", list);
		
		try {
			FileWriter file = new FileWriter(outFileName);
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(obj);
	}
	
	public static void readJson(String fileName) {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(fileName));
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("book");
			System.out.println(name);
			String author = (String) jsonObject.get("author");
			System.out.println(author);
			JSONArray reviews = (JSONArray) jsonObject.get("messages");
			Iterator<String> iterator = reviews.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch(IOException e) {
			
		}catch(ParseException e) {
			
		}
		
	}

}