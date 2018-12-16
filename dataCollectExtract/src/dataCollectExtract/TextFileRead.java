package dataCollectExtract;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TextFileRead {
	public static void main(String[] args) {
		File file =new File("C:\\Users\\SH\\Desktop\\집.txt");
		
		try{
			String text = FileUtils.readFileToString(file, "UTF-8");
			System.out.println(text);
		}
		catch(IOException e) {
			System.out.println("Error reading "+ file.getAbsolutePath());
		}
	}

}
