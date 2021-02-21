package UserOperations;
import java.lang.String;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class WebUserOperations {

	private static boolean String;

	public static void main(String[] args) {
		
		
		int op, sop;
		Scanner scanner = new Scanner(System.in);
		op = Utilityoperations.mainMenu();

		
		
		String strfilename, strfolder, strwrite;
		strfolder = "/Users/Neena/Documents/SimpliLearnFSD/SimplilearnPhase1Assessment/LockedMeProject/UserFiles/Pictures";
		
		
		List<String> files = new LinkedList<String>();
		files = Utilityoperations.getFilenames(strfolder);
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
				System.out.println("Please select few more User file options:");
				System.out.println("1. Add a file");
				System.out.println("2. Delete a file");
				System.out.println("3. Search a file ");
				System.out.println("4. Go to the main menu ");
				
				sop = scanner.nextInt();
				
				if(sop ==1)
				{
					System.out.println("Please enter a filename to add: ");
					strfilename = scanner.next().trim();
					System.out.println("Please enter something to write to the file: ");
					strwrite = scanner.next().trim().toLowerCase();
					
					try {
						 
						for(String file:files)
						{
							if(!file.equals(strfilename))
							{
								Utilityoperations.addFile(strfolder, strfilename, strwrite);
								files = Utilityoperations.getFilenames(strfolder);
								files.add(strfilename);
								Collections.sort(files, java.lang.String.CASE_INSENSITIVE_ORDER);
								break;
							}
							else
							{
								System.out.println(strfilename + "- File already exists!");
							}
						}
						
							
						

					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(sop==2)
				{
					System.out.println("Please enter a filename to delele: ");
					strfilename = scanner.next().trim();
					File file = new File(strfolder + "/" + strfilename);
					files = Utilityoperations.getFilenames(strfolder);
					
					
					try
					{
						if(file.exists())
						{
									Utilityoperations.delFile(strfolder, strfilename);
									files.remove(strfilename);
								
						}
						else
						{
							System.out.println("Can't find file " + strfilename);
						}
						
					}
					catch(SecurityException ex)
					{
						System.out.println(ex.getMessage());
					}
				}
				if(sop==3)
				{
					System.out.println("Search for a file: ");
					strfilename = scanner.next().trim();
					
					File file = new File(strfolder + "/" + strfilename);
					files = Utilityoperations.getFilenames(strfolder);
					Collections.sort(files, java.lang.String.CASE_INSENSITIVE_ORDER);
					
					if(file.exists() || Collections.binarySearch(files, strfilename) >= 0)
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
				if(sop ==4)
				{
					op = Utilityoperations.mainMenu();
				}
				break;
				
			
				
			}
			
			
		
		
		
		

	}

}
