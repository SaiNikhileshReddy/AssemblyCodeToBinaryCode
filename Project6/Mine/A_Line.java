import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 16:08 , on 22-12-2019.
 */
public class A_Line {
    public static String mainKey(String fileName, String key) throws FileNotFoundException {
        int countHidden = 0;
        int countRegister = 15;
        int slashHidden = 0;
        String line;
        Database database = new Database();

        Scanner data = new Scanner(new File(fileName));
        while (data.hasNextLine()) {
            line = data.nextLine();
            char[] lineChar = line.toCharArray();

            if (!(lineChar.length < 2)) {
                for (int i = 0; i < lineChar.length - 1; i++) {
                    if (lineChar[i] == '/' && lineChar[i + 1] == '/') {
                        slashHidden = i;
                        break;
                    }
                }
            }


            if (!((line.substring(0, (slashHidden)).trim().isEmpty() && slashHidden != 0) || line.trim().isEmpty()
                    || (line.charAt(0) == '/' && line.charAt(1) == '/'))) {

                int endPosition = (slashHidden == 0) ? line.length() : slashHidden;
                String mainKey = line.substring(0, endPosition).trim();


                int positionOne = mainKey.indexOf('(');
                int positionTwo = mainKey.indexOf(')');
                if (positionOne >= 0 && positionTwo > 0) {
                    String getLabel = mainKey.substring(positionOne + 1, positionTwo).trim();
                        database.setSymbolKey(getLabel, countHidden);
//                        System.out.println(getLabel+" ==> "+database.getSymbolValue(getLabel));
                }else {
                    countHidden++;
                }

                if (mainKey.charAt(0) == '@') {
                    String getLabel = mainKey.substring(1).trim();
                    if (!database.checkSymbolKey(getLabel)){
                        countRegister++;
                        database.setSymbolKey(getLabel,countRegister);
//                        System.out.println(getLabel+" ==> "+database.getSymbolValue(getLabel));
                    }
                }
//                System.out.println("Line :"+(countHidden-1)+":"+line);
            }
            slashHidden = 0;
        }

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

    public static void main(String[] args) throws FileNotFoundException {
    }

}
