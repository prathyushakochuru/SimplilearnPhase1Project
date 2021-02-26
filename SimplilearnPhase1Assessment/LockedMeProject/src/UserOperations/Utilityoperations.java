/* Project: LockedMe.com - Console Application
 * Author: Prathyusha Kochuru
 * Date: 02/24/2021
 * Class - UtilityOperations class - Abstract methods implementation*/

package UserOperations;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Extends the UserAbstract class
public class Utilityoperations extends UserAbstract{
	
	List<String> fileslist = new LinkedList<String>();
	
	//Implementation of mainMenu() method
	@Override
	public int mainMenu()
	{
		System.out.println("                 ****Welcome to LockedMe.com!****               ");
		System.out.println("              Where you find the exclusive fineart           ");
		System.out.println("Hello user, I am Prathyusha Kochuru - Full Stack Web Developer, Lockers Pvt. Ltd.");
		System.out.println("Please select the following options:");
		System.out.println("1. Retrieve the filenames");
		System.out.println("2. Perform CRUD file operations");
		System.out.println("3. Close the application");
		
		int op;
		Scanner scanner = new Scanner(System.in);
		op = scanner.nextInt();
		return op;
	}
	
	//Implementation of getFilenames() method - Get files into a list
	@Override
	public List<String> getFilenames(File[] files) 
	{
		for(File file:files)
		{
			//traverse through all the sub folders
			if(file.isDirectory())
			{
				//fileslist.add(file.getName());
				getFilenames(file.listFiles());
			}
			else {
				fileslist.add(file.getName());
			}
				
		}
		
		return fileslist;		
	}
	
	
	//Implementation of addFile() method - creates a new file and writes to the file - throws IOException
	@Override
	public  void addFile(String strfolder, String strfilename) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		String strnewfile = strfolder.trim() + "/" + strfilename.trim();
		String strwrite;
		
		File newfile = new File(strnewfile);	
		try {
			if(!newfile.exists())
			{
				System.out.println("Please enter something to write to the file: ");
				//case insensitive
				strwrite = scanner.next().trim().toLowerCase();
				FileWriter filewrite = new FileWriter(strnewfile);
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
	}
	
	
	//Implementation of delFile() method - deletes a file if exists- throws SecurityException 
	@Override
	protected  void delFile(String strfolder, String strfilename) throws SecurityException 
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
	
	//Implementation of searchFile() method - search a file if exists- throws FileNotFoundException
	@Override
	public void searchFile(List<String> files, String strfolder, String strfilename) throws FileNotFoundException
	{
		File file = new File(strfolder + "/" + strfilename);
		File[] filenames = new File(strfolder).listFiles();
		files = getFilenames(filenames);
		Collections.sort(files);
		
		if(file.exists() && Collections.binarySearch(files, strfilename) >= 0 )
		{
			System.out.println("Found the file!");
			try(FileInputStream fis=new FileInputStream(strfolder + "/" + strfilename);
					BufferedInputStream bis=new BufferedInputStream(fis);){ 
			
				StringBuilder sb=new StringBuilder();
				while(bis.available()!=0) {
					sb.append((char)bis.read());
				}
				System.out.println("Data read from the file is ");
				System.out.println(sb.toString());
		
			} catch (FileNotFoundException e) {
			System.out.println("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("File not found!");
		}
	}

}
