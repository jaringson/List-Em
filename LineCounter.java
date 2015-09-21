package listem;

import java.io.File;
import java.util.Map;

public class LineCounter extends FileProcessor implements ILineCounter  {

	private File curFile;
	private int curLineCount;
	private int totLineCount;
	
	@Override
	public Map<File, Integer> countLines(File directory, String fileSelectionPattern, boolean recursive) {
		super.processDir(directory);
		return null;
	}

	@Override
	public void unreadableDir(File dir) {
		System.out.println("Can't Read the Directory or File");
	}
	@Override
	public void nondir(File dir) {
		System.out.println("This is not a Directory");
	}
	
	
	public void startFile(File file){
		curFile = file;
		curLineCount = 0;
	}
	public void endFile(File file){
		assert(file == curFile);
	}
	public void line(){
		curLineCount++;
		totLineCount++;
	}

	@Override
	public void processline(String line) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endfile(File file) {
		// TODO Auto-generated method stub
		
	}
	

	

}
