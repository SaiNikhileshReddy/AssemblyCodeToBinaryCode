import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 12:29 , on 22-12-2019.
 */
public class Assembler {
    static Integer count = 0;
    public static void main(String[] args) throws FileNotFoundException {
        int slash = 0;
        String line, lineValue;

        String fileName = "data.asm";
        Scanner data = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();

        while (data.hasNextLine()) {
            list.add(data.nextLine());
        }

//        while(data.hasNextLine()){
//            String binaryLine = (Parser.converter(data, data.nextLine()));
//            if (binaryLine != null)
//                System.out.println(binaryLine);
//        }

//        System.out.println(list.size());

        for (int i = 0; i<list.size(); i++){
            String binaryLine = (Parser.converter(fileName, list.get(i)));
            if (binaryLine != null)
            System.out.println(binaryLine);
        }


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

    }
}
