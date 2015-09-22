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
	private Pattern subpattern;
	private Matcher submatcher;

	@Override
	public Map<File, List<String>> grep(File directory, 
			String fileSelectionPattern, String substringSelectionPattern,
			boolean recursive) {
		totalcontainer.clear();
		subcontainer.clear();
		//System.out.println("here2");
		super.filePattern = fileSelectionPattern;
		super.recursion = recursive;
		substring = substringSelectionPattern;
		super.processDir(directory);
		//System.out.println(totalcontainer.toString());
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
		//System.out.println("here");
		//System.out.println(substring);
		pattern = Pattern.compile(substring);
		matcher = pattern.matcher(line);
		if(matcher.find()){
			//System.out.println("here5");
			subcontainer.add(line);
		}
	}
	@Override
	public void endfile(File file) {
		List<String> temp = new ArrayList();
		if(subcontainer.size() > 0){
			//System.out.println("here6" + subcontainer.toString());
			totalcontainer.put(file, subcontainer);
			subcontainer = temp;
		}
	}

}