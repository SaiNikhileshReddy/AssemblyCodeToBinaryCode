import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 01:21 , on 22-12-2019.
 */

public class Test {
    public static void main(String[] args) throws IOException {

        /*try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }*/

        int count = 0;
        int slash = 0;
        String line, lineValue;

        Scanner data = new Scanner(new File("data.asm"));

        while (data.hasNextLine()){
            line = data.nextLine();
            char[] lineChar = line.toCharArray();
            for (int i = 0; i<lineChar.length-1; i++){
                if (lineChar[i] == '/' && lineChar[i+1] == '/'){
                    slash = i;
                    break;
                }
            }

            if ((line.substring(0,(slash)).trim().isEmpty() && slash !=0) || line.trim().isEmpty()){
                System.out.println("this line is removed");
            }else if (line.charAt(0) == '@'){
                System.out.println("@ is Removed");
            }

            slash = 0;
        }
    }

    public static String cLineCompile(String line) {
        return C_Line.mainKey(line);
    }
}