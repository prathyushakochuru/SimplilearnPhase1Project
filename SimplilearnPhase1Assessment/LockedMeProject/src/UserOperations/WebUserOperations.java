package UserOperations;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebUserOperations {

	public static void main(String[] args) {
		

		System.out.println("                 ****Welcome to LockedMe.com!****               ");
		System.out.println("              Where you find the exclusive fineart           ");
		System.out.println("Hello user, I am Prathyusha Kochuru - Full Stack Web Developer, Lockers Pvt. Ltd.");
		System.out.println("Please select the folliwing options:");
		System.out.println("1. Retrieve the filenames");
		System.out.println("2. Perform CRUD file operations");
		System.out.println("3. Navigate to the main menu");
		
		Scanner scanner = new Scanner(System.in);
		int op, sop;
		String strfilename, strfolder;
		strfolder = "/Users/Neena/Documents/SimpliLearnFSD/SimplilearnPhase1Assessment/LockedMeProject/UserFiles/Pictures";
		op = scanner.nextInt();
		
		List<String> files = new ArrayList<String>();
		files = Utilityoperations.getFilenames(strfolder);
		Collections.sort(files);
		
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
				
				sop = scanner.nextInt();
				
				if(sop ==1)
				{
					System.out.println("Please enter a filename to add: ");
					strfilename = scanner.next().trim();
					
					try {
						Utilityoperations.addFile(strfolder, strfilename);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				break;
			
				
			}
		
		
		
		

	}

}
