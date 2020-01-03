import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 12:29 , on 22-12-2019.
 */
public class Assembler extends MyException {
    public static void main(String[] args) {
        try {
            fileTester(args[0].length());
            String fileName = args[0]; //args[0];
            String outputFile = fileName.substring(0, fileName.indexOf('.')) + ".hack";
            PrintStream ps = new PrintStream(new File(outputFile));
            Scanner data = new Scanner(new File(fileName));
            Database database = reconstructDatabase(fileName);

            while (data.hasNextLine()) {
                String binaryLine = (Parser.converter(database, data.nextLine()));
                if (binaryLine != null)
                    ps.println(binaryLine);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There's no input for file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }

    public static void main(String fileName) {
        main(new String[]{fileName});
    }

    private static Database reconstructDatabase(String fileName) throws FileNotFoundException {
        int countHidden = 0;
        int countRegister = 15;
        String line;
        int slashHidden = 0;


        Database database = new Database();

        Scanner data1 = new Scanner(new File(fileName));
        while (data1.hasNextLine()) {
            line = data1.nextLine();
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
                    System.out.println(getLabel + "==>" + database.getSymbolValue(getLabel) + ":");
                } else {
                    countHidden++;
                }
            }
        }

        Scanner data2 = new Scanner(new File(fileName));
        while (data2.hasNextLine()) {
            line = data2.nextLine();
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

                if (mainKey.charAt(0) == '@') {
                    String getLabel = mainKey.substring(1).trim();

                    if (!database.checkSymbolKey(getLabel)) {

                        if (checkIfString(getLabel)) {
                            int intLabel = Integer.parseInt(getLabel);
                            database.setSymbolKey(getLabel, intLabel);
                            System.out.println(getLabel + " ==> " + database.getSymbolValue(getLabel));
                        } else {
                            countRegister++;
                            database.setSymbolKey(getLabel, countRegister);
                            System.out.println(getLabel + "==>" + database.getSymbolValue(getLabel) + ":");
                        }
                    }
                }
//                System.out.println("Line :"+(countHidden-1)+":"+line);
            }
            slashHidden = 0;
        }

        return database;
    }

    private static boolean checkIfString(String getlabel) {
        char[] ch = getlabel.toCharArray();
        String returnLabel = "";
        for (int i = 0; i < ch.length; i++) {
            if (!Character.isDigit(ch[i])) {
                return false;
            }
        }
        return true;
    }
}
