package UserOperations;
import java.io.File;
import java.io.FileNotFoundException;
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
	
	public static void addFile(String strfolder, String strfilename) throws FileNotFoundException
	{
		String strnewfile = strfolder.trim() + "/" + strfilename.trim();
		
		File newfile = new File(strnewfile);
		
		try {
			if(newfile.createNewFile())
			{
				System.out.println(strfilename + " created SUCCESSFULLY in " + strfolder);
			}
			else
			{
				System.out.println(strfilename + " ALREADY exists in " + strfolder);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
