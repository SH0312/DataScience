package dataCollectExtract;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileListing {
	public static void main(String[] args) {
		FileListing fileListing = new FileListing(); 
		fileListing.listFiles("C:\\Users\\SH\\Desktop\\Lab");
	}
	public void listFiles(String rootDir) {
		File dir = new  File(rootDir);
		
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		
		for(File file : files) {
			System.out.println("file: "+ file.getAbsolutePath());
		}
	}

}