package listem;

import java.io.File;
import java.util.regex.*;

public abstract class FileProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private String dirName;
	private String filePattern;
	private Boolean recursion;
	private Pattern pattern;
	private Matcher matcher;
	
	void processDir(File dir){
		if(!dir.isDirectory()){
			nondir(dir);
			return;
		}
		if(!dir.canRead()){
			unreadableDir(dir);
			return;
		}
		for(File file: dir.listFiles()){
			if(file.isFile()){
				if(file.canRead()){
					processFile(file);
				}
			}
		}
	}
	public abstract void unreadableDir(File dir);
	private void processFile(File file) {
		
	}
	public abstract void nondir(File dir);

}
