
package purifier;

import java.io.*;
import java.util.*;

/**
 *
 * @author big
 */
public class Importer {
    
    public static String[] fromFileIntoArray() throws IOException, FileNotFoundException {
        String path = ParamSetter.setPathToFileRead();
        BufferedReader input = new BufferedReader(new FileReader(new File(path)));
        int dim=0;
        while(input.readLine() != null){
            dim++;
        }
        input.close();
        
        input = new BufferedReader(new FileReader(path));
        String[] aux = new String[dim];
        for (int i = 0; i < dim; i++) {
            aux[i] = input.readLine();
        }
        input.close();
        
        return aux;
   
    }
    
    public static ArrayList<String> fromFileIntoList(String pathToFileRead) throws FileNotFoundException, IOException{
        ArrayList<String> aux = new ArrayList<>();
        BufferedReader input = new BufferedReader(new FileReader(pathToFileRead));
        String current;
        while((current = input.readLine()) != null){
            aux.add(current);
        }
        return aux;
    }

}
