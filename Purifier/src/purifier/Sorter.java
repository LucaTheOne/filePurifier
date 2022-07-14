
package purifier;

/**
 *
 * @author big
 */
public class Sorter extends Purifier {
    
    
    
    
    public static boolean stringAreInverted(String s1, String s2){
        if(s1.compareTo(s2)>0) return true;
        return false;
    }
    
    private static void switchString(String s1,String s2){
        String temp = s1;
        s1=s2;
        s2=temp;
    }
}
