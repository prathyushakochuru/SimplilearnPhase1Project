package UserOperations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Utilityoperations {
	
	public static int mainMenu()
	{
		System.out.println("                 ****Welcome to LockedMe.com!****               ");
		System.out.println("              Where you find the exclusive fineart           ");
		System.out.println("Hello user, I am Prathyusha Kochuru - Full Stack Web Developer, Lockers Pvt. Ltd.");
		System.out.println("Please select the folliwing options:");
		System.out.println("1. Retrieve the filenames");
		System.out.println("2. Perform CRUD file operations");
		System.out.println("3. Navigate to the main menu");
		
		int op;
		Scanner scanner = new Scanner(System.in);
		op = scanner.nextInt();
		return op;
	}
	
	public static List<String> getFilenames(String strfolder) 
	{
		List<String> fileslist = new LinkedList<String>();
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
	
	public static void addFile(String strfolder, String strfilename, String strwrite) throws IOException
	{
		String strnewfile = strfolder.trim() + "/" + strfilename.trim().toLowerCase();
		
		File newfile = new File(strnewfile.toLowerCase());
		FileWriter filewrite = new FileWriter(strnewfile);
		
		try {
			if(newfile.exists())
			{
				filewrite.write(strwrite);
				filewrite.close();
				System.out.println(strfilename + " created and wrote SUCCESSFULLY in " + strfolder);
			}
			else
			{
				System.out.println(strfilename + " ALREADY exists in " + strfolder);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			filewrite.close();
			
		}
	}
	
	protected static void delFile(String strfolder, String strfilename) throws SecurityException 
	{
		String strnewfile = strfolder.trim() + "/" + strfilename.trim();
		File file = new File(strnewfile);
		
		if(file.exists())
		{
			file.delete();
			System.out.println(strfilename + " is successfully deleted!");	
		}
		else
		{
			System.out.println("Sorry, "+ strfilename + " file not found!");
		}
		
		
		
	}

}
