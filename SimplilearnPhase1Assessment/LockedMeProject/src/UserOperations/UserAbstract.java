/* Project: LockedMe.com - Console Application
 * Author: Prathyusha Kochuru
 * Date: 02/24/2021
 * Class - Abstract class*/

package UserOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.File;

//Abstract class
public abstract class UserAbstract {
	
	abstract int mainMenu();
	abstract List<String> getFilenames(File[] files);
	abstract void addFile(String strfolder, String strfilename) throws IOException;
	abstract void delFile(String strfolder, String strfilename) throws SecurityException; 
	abstract void searchFile(List<String> files, String strfolder, String strfilename) throws FileNotFoundException;
	
	

}
