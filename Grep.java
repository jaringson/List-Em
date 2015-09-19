package listem;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Grep extends FileProcessor implements IGrep  {

	private File curFile;
	
	@Override
	public Map<File, List<String>> grep(File directory, 
			String fileSelectionPattern, String substringSelectionPattern,
			boolean recursive) {
		super.processDir(directory);
		
		return null;
	}

	@Override
	public void unreadableDir(File dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nondir(File dir) {
		// TODO Auto-generated method stub
		
	}

}
