/* Project: LockedMe.com - Console Application
 * Author: Prathyusha Kochuru
 * Date: 02/24/2021
 * Name - UserOperations Main method*/


package UserOperations;
import java.lang.String;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WebUserOperations {

	public static void main(String[] args) {
		
		//Create an object for the abstract implementation class
		UserAbstract userop = new Utilityoperations();
		int op, sop;
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		op = userop.mainMenu();
		
		String strfilename, strfolder, strwrite;
		strfolder = "/Users/Neena/Documents/SimpliLearnFSD/SimplilearnPhase1Assessment/LockedMeProject/UserFiles";
		
		//create a linkedlist<>
		List<String> files = new LinkedList<String>();
		//populate the list - filenames from the folder
		
		File[] filenames = new File(strfolder).listFiles();
		files = userop.getFilenames(filenames);
		//sorts linkedlist in ascending order
		Collections.sort(files, java.lang.String.CASE_INSENSITIVE_ORDER);
		
			switch(op)
			{
			case 1:
				
				System.out.println("Here are the files in the ascending order: ");
				for(String strfile:files)
				{
					System.out.println(strfile);
				}
				break;
				
			case 2:
			{
				System.out.println("Please select few more User file options:");
				System.out.println("1. Add a file");
				System.out.println("2. Delete a file");
				System.out.println("3. Search a file ");
				System.out.println("4. Go to the main menu ");
				
				sop = scanner.nextInt();
				
				//do {
				switch(sop)
				{
					case 1:
					{
						System.out.println("Please enter a filename to add: ");
						strfilename = scanner.next().trim();
						try {
								for(String file:files)
							{
								if(!file.contains(strfilename))
								{	//call addFile						
									userop.addFile(strfolder, strfilename);
									//add file to the LinkedList
									files.add(strfilename);									
									break;
								}
							}
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						}
					
						case 2:
						{
							
							System.out.println("Please enter a filename to delele: ");
							strfilename = scanner.next().trim();
							File file = new File(strfolder + "/" + strfilename);
							files = userop.getFilenames(filenames);
						try
						{
							//checks if file exists before deleting and also .contains gives the correct case-sensitive filename
							if(file.exists() && files.contains(strfilename))
							{
								//delete the right file
								userop.delFile(strfolder, strfilename);
								//remove from the list
								files.remove(strfilename);								
							}
							else
							{
								System.out.println("Can't find file " + strfilename);
							}
							
						}//Security exception while 
						catch(SecurityException ex)
						{
							System.out.println(ex.getMessage());
						}
						break;
						}
						
						case 3:
						{
							System.out.println("Search for a file: ");
							strfilename = scanner.next().trim();
							
							try {
								//search for the file and then read the content if exists
								userop.searchFile(files, strfolder, strfilename);
							}
							//throws File not found if file doesn't exists
							catch (FileNotFoundException e1) {							
								e1.printStackTrace();
							}
							
							break;
						}
						default:
						{
							//go to the main welcome menu
							op = userop.mainMenu();
							//loop =false;
							break;
						}
				}
				//} while(sop!=4);
				break;
			}
			case 3:
				//exit the application
				System.out.println("See you later, thank you!");
				System.exit(0);
				
			
				
			}
			
			
		
		
		
		

	}

}


