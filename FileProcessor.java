package listem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public abstract class FileProcessor {

	protected String dirName;
	protected String filePattern;
	protected Boolean recursion;
	protected Pattern pattern;
	protected Matcher matcher;
	
	void processDir(File dir){
		//System.out.println("here3");
		if(!dir.isDirectory()){
			nondir(dir);
			return;
		}
		if(!dir.canRead()){
			unreadableDir(dir);
			return;
		}
		filePattern = filePattern.substring(1,filePattern.length()-1);
		for(File file: dir.listFiles()){
			pattern = Pattern.compile(filePattern);
			matcher = pattern.matcher(file.getName());
			//System.out.println("here4 " + file.getName() + " "+ filePattern + " " + matcher.matches());
			if(matcher.matches()){
				//System.out.println("here1");
				if(file.isFile()){
					if(file.canRead()){
						processFile(file);
					}
				}
				else if(recursion == true && file.isDirectory()){
					processDir(file);
				}
			}
		}
	}
	public abstract void unreadableDir(File dir);
	public abstract void nondir(File dir);
	public abstract void processline(String line);
	public abstract void endfile(File file);
	
	private void processFile(File file) {
		try {
			Scanner reader = new Scanner (new BufferedInputStream(new FileInputStream(file)));
			while(reader.hasNext()){
				String line = reader.nextLine();
				processline(line);
			}
			endfile(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

}
