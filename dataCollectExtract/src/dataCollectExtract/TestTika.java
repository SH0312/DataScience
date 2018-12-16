package dataCollectExtract;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;


//Tika로 PDF파일에서 텍스트 추출
public class TestTika {
	public static void main(String[] args) throws Exception{
		TestTika tika = new TestTika();
		tika.convertPdf("C:\\Users\\SH\\Desktop\\1234.pdf");
	}
	
	public void convertPdf(String fileName) {
		InputStream stream = null;
		
		try {
			stream = new FileInputStream(fileName);
			
			AutoDetectParser parser = new AutoDetectParser();
			BodyContentHandler handler = new BodyContentHandler(-1);
			Metadata metadata = new Metadata();
			parser.parse(stream, handler, metadata, new ParseContext());
			System.out.println(handler.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(stream != null)
				try {
					stream.close();
				}
			catch (IOException e) {
				// TODO: handle exception
				System.out.println("Error colsing stream");
			}
		}
	}

}
