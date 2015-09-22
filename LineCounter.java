package listem;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LineCounter extends FileProcessor implements ILineCounter  {

	private File curFile;
	private int curLineCount;
	private int totLineCount;
	private Map<File, Integer> totalcontainer = new HashMap();
	
	@Override
	public Map<File, Integer> countLines(File directory, String fileSelectionPattern, boolean recursive) {
		super.filePattern = fileSelectionPattern;
		super.recursion = recursive;
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
		curLineCount++;
	}

	@Override
	public void endfile(File file) {
		totalcontainer.put(file, curLineCount);
		curLineCount = 0;
	}
	

	

}
