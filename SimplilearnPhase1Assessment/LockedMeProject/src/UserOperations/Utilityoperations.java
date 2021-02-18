package UserOperations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Utilityoperations {
	
	public static List<String> getFilenames(String strfolder) 
	{
		List<String> fileslist = new ArrayList<String>();
		File[] filenames = new File(strfolder).listFiles();
		
		for(File file:filenames)
		{
			//if(file.isDirectory())
			//{
			//	getFilenames(file.toString());
			//}
			//if(file.isFile())
			//{
				fileslist.add(file.getName());
			//}
		}
		
		return fileslist;
		
	}

}
