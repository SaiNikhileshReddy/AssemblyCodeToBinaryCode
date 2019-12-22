import java.io.FileNotFoundException;

/**
 * Created by Sai Nikhilesh Reddy at 12:29 , on 22-12-2019.
 */
public class Parser {
    public static String converter(String fileName, String line) throws FileNotFoundException {
        int slash = 0;
        String lineValue;

        char[] lineChar = line.toCharArray();

        if (!(lineChar.length < 2)) {
            for (int i = 0; i < lineChar.length - 1; i++) {
                if (lineChar[i] == '/' && lineChar[i + 1] == '/') {
                    slash = i;
                    break;
                }
            }
        }

//        System.out.println("Line : "+line);
        if (!((line.substring(0, (slash)).trim().isEmpty() && slash != 0) || line.trim().isEmpty()
                || (line.charAt(0) == '/' && line.charAt(1) == '/'))) {
            int endPosition = (slash == 0) ? line.length() : slash;
            String editedKey = line.substring(0, endPosition).trim();


            if ((line.trim().charAt(0) == '@') || (line.trim().charAt(0) == '(')) {

                lineValue = A_Line.mainKey(fileName, editedKey);
                return lineValue;
            } else {
                lineValue = cLineCompile(line.trim());
                return lineValue;
            }
        }else{
            return null;
        }
    }

    public static String cLineCompile(String line) {
        return C_Line.mainKey(line);
    }

    public static void main(String[] args) throws FileNotFoundException {
    }
}
