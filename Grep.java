package listem;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep extends FileProcessor implements IGrep  {

	private File curFile;
	private Map totalcontainer = new HashMap();
	private List<String> subcontainer = new ArrayList();
	private String substring;

	

	
	@Override
	public Map<File, List<String>> grep(File directory, 
			String fileSelectionPattern, String substringSelectionPattern,
			boolean recursive) {
		super.filePattern = fileSelectionPattern;
		super.recursion = recursive;
		substring = substringSelectionPattern;
		super.processDir(directory);
		
		return totalcontainer;
	}

	@Override
	public void unreadableDir(File dir) {
		System.out.println("Can't Read the Directory or File");
	}
	@Override
	public void nondir(File dir) {
		System.out.println("This is not a Directory");
	}
	@Override
	public void processline(String line) {
		System.out.println("here");
		if(line.contains(substring)){
			subcontainer.add(line);
		}
	}
	@Override
	public void endfile(File file) {
		totalcontainer.put(file, subcontainer);
		subcontainer.clear();
	}

}
