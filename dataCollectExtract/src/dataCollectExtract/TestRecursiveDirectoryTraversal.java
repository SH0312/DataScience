package dataCollectExtract;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
//폴더 안에 파일명 및 경로 읽기 / 폴더 있을 경우 폴더 안에 파일 읽기
public class TestRecursiveDirectoryTraversal {
	public static void main(String[] args) {
		System.out.println(listFiles(new File("C:\\Users\\SH\\workspace\\cookbook\\dataCollectExtract")));
	}
	public static Set<File> listFiles(File rootDir){
		Set<File> fileSet = new HashSet<File>();
		
		if(rootDir == null || rootDir.listFiles() == null) {
			return fileSet;
		}
		
		for(File fileOrDir : rootDir.listFiles()) {
			if(fileOrDir.isFile()) {
				fileSet.add(fileOrDir);
			}
			else {
				fileSet.addAll(listFiles(fileOrDir));
			}
		}
		
		return fileSet;
		
	}

}
