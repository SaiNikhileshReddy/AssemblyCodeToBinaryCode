import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 01:15 , on 23-12-2019.
 */
public class UserInterface{
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("==============Hack Assembler==============\n");

        while (true) {
            System.out.print("\nEnter file name : ");
            String inputFile = scan.nextLine();
            String userFileCheck = inputFile.substring(inputFile.indexOf('.'));
            if (userFileCheck.equals(".asm")) {
                Assembler.main(inputFile);
            } else {
                System.out.println("Incorrect file format.");
                return;
            }

            String outputFile = inputFile.substring(0, inputFile.indexOf('.')) + ".hack";
            displayBinaryCode(outputFile);


            System.out.print("\nDo you want to convert another file :");
            if (!scan.nextLine().toLowerCase().equals("yes")) {
                System.out.println("Thanks for using HACK ASSEMBLER");
                break;
            }
        }

    }

    private static void displayBinaryCode(String outputFile) throws IOException {
        System.out.print("\nDo you want to see the contents of "+outputFile+" :");
        if (scan.nextLine().toLowerCase().equals("yes")){
            Scanner data = new Scanner(new File(outputFile));
            while(data.hasNextLine()){
                System.out.println(data.nextLine());
            }
        }
    }
}
