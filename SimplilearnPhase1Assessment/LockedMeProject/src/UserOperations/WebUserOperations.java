package UserOperations;
import java.util.Scanner;
import java.io.File;
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
		int op;
		op = scanner.nextInt();
		
		
			switch(op)
			{
			case 1:
				List<String> files = new ArrayList<String>();
				files = Utilityoperations.getFilenames("/Users/Neena/Documents/SimpliLearnFSD/SimplilearnPhase1Assessment/LockedMeProject/UserFiles/Pictures");
				System.out.println("Here are the files: ");
				for(String strfile:files)
				{
					System.out.println(strfile);
				}
				break;
			}
		
		
		
		

	}

}
