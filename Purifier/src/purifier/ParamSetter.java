
package purifier;

import java.util.*;

public class ParamSetter {
    
    static String setPathToFileRead() {
        System.out.print("Insert file's path of the file to treat: ");
        return new Scanner(System.in).nextLine();
    }
    
    static String setPathToFileWrite(){
        System.out.print("Insert path of where you want to save purified file: ");
        String path = new Scanner(System.in).nextLine()+"/";
        System.out.print("Choose a name for purified file, default is Purified.txt: ");
        String filePurifiedName = new Scanner(System.in).nextLine();
        return filePurifiedName.equals("") ? path + "Purified.txt": path + filePurifiedName;
    }
    
    static String setSeparator(){
        System.out.print("Type the separator used in the file, Default is <SEP>: ");
        String choice =new Scanner(System.in).nextLine();
        return choice.equals("")? "<SEP>":choice;
    }
    
    public static int[] setColumsToConsider(){
        System.out.print("Type the number of the columns to consider when cleaning, default is 3: ");
        String scelta1  = new Scanner(System.in).nextLine();
        int numberOfColumnsToConsider = scelta1.equals("")? 3:Integer.parseInt(scelta1);
        System.out.print("\r");
        
        int[] indexesOfColumnsToConsider = new int[numberOfColumnsToConsider];
        
        if(numberOfColumnsToConsider == 3){
            System.out.println("Choose indexes of the columns to consider when cleaning, starting from 0.");
            System.out.print("Type values separated by spaces, default columns are; 0 2 3: ");
            String scelta2 = new Scanner(System.in).nextLine();
            if(scelta2.equals("")){
                return new int[]{0,2,3};
            } else{
                
                for (int i = 0; i < numberOfColumnsToConsider; i++) {
                    indexesOfColumnsToConsider[i] = Integer.parseInt(scelta2.split(" ")[i]);
                }
                return indexesOfColumnsToConsider;
            }

        } else {  
            System.out.println("Choose indexes of the columns to compare, starting from 0.");
            System.out.println("Type values separated by spaces (ex: 0 1 2): ");
            for(int i = 0; i<numberOfColumnsToConsider; i++){
                System.out.print("index of priority " + (i+1) + ": ");
                indexesOfColumnsToConsider[i] = new Scanner(System.in).nextInt();
                return indexesOfColumnsToConsider;
            }    
        }
        return indexesOfColumnsToConsider;
    }
    
}
