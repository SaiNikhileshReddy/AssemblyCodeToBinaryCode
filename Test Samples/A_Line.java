
import java.io.FileNotFoundException;

/**
 * Created by Sai Nikhilesh Reddy at 16:08 , on 22-12-2019.
 */
public class A_Line {
    public static String mainKey(Database database, String key) throws FileNotFoundException {

        int slashHidden = 0;

        char[] lineChar = key.toCharArray();

        if (!(lineChar.length < 2)) {
            for (int i = 0; i < lineChar.length - 1; i++) {
                if (lineChar[i] == '/' && lineChar[i + 1] == '/') {
                    slashHidden = i;
                    break;
                }
            }
        }
//        System.out.println("slash " + slashHidden);
        String shortString = null;
        if (key.charAt(0) == '@') {
            int endPosition = (slashHidden == 0) ? key.length() : slashHidden;
            shortString = key.substring(1, endPosition).trim();
//            System.out.println(shortString+"==>"+database.getSymbolValue(shortString));
            return (String.format("%16s", Integer.toBinaryString(database.getSymbolValue(shortString)))
                    .replace(' ', '0'));
        }

        /*if (key.charAt(0) == '('){
            shortString = key.substring(1, key.indexOf(')'));
//            System.out.println(shortString);
//            System.out.println(shortString+"==>"+database.getSymbolValue(shortString));
        }*/


        return shortString;
    }
}
