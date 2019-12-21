import java.util.HashMap;

/**
 * Created by Sai Nikhilesh Reddy at 16:33 , on 20-12-2019.
 */
public class Database {
     private static HashMap<String,String> compTable = new HashMap<>();
     private static HashMap<String ,String> destTable = new HashMap<>();
     private static HashMap<String,String> jumpTable = new HashMap<>();
     private static HashMap<String,Integer> symbolTable = new HashMap<>();

    Database(){

        // COMPTABLE a=0
        compTable.put("0","0101010"); compTable.put("1","0111111"); compTable.put("-1","0111010");
        compTable.put("D","0001100"); compTable.put("A","0110000"); compTable.put("!D","0001101");
        compTable.put("!A","0110001"); compTable.put("-D","0001111"); compTable.put("-A","0110011");
        compTable.put("D+1","0011111"); compTable.put("A+1","0110111"); compTable.put("D-1","0001110");
        compTable.put("A-1","0110010"); compTable.put("D+A","0000010"); compTable.put("D-A","0010011");
        compTable.put("A-D","0000111"); compTable.put("D&A","0000000"); compTable.put("D|A","0010101");

        // COMPTABLE a=1
        compTable.put("M","1110000"); compTable.put("!M","1110001"); compTable.put("-M","1110011");
        compTable.put("M+1","1110111"); compTable.put("M-1","1110010"); compTable.put("D+M","1000010");
        compTable.put("D-M","1010011"); compTable.put("M-D","1000111"); compTable.put("D&M","1000000");
        compTable.put("D|M","1010101");

        // DESTTABLE
        destTable.put("","000"); destTable.put("M","001"); destTable.put("D","010");
        destTable.put("MD","011"); destTable.put("A","100"); destTable.put("AM","101");
        destTable.put("AD","110"); destTable.put("AMD","111");

        // JUMPTABLE
        jumpTable.put("","000"); jumpTable.put("JGT","001"); jumpTable.put("JEQ","010");
        jumpTable.put("JGE","011"); jumpTable.put("JLT","100"); jumpTable.put("JNE","101");
        jumpTable.put("JLE","110"); jumpTable.put("JMP","111");

        // SYMBOLTABLE
        symbolTable.put("R0",0); symbolTable.put("R1",1); symbolTable.put("R2",2);
        symbolTable.put("R3",3); symbolTable.put("R4",4); symbolTable.put("R5",5);
        symbolTable.put("R6",6); symbolTable.put("R7",7); symbolTable.put("R8",8);
        symbolTable.put("R9",9); symbolTable.put("R10",10); symbolTable.put("R11",11);
        symbolTable.put("R12",12); symbolTable.put("R13",13); symbolTable.put("R14",14);
        symbolTable.put("R15",15); symbolTable.put("SCREEN",16384); symbolTable.put("KBD",24576);

        symbolTable.put("0",0); symbolTable.put("1",1); symbolTable.put("2",2);
        symbolTable.put("3",3); symbolTable.put("4",4); symbolTable.put("5",5);
        symbolTable.put("6",6); symbolTable.put("7",7); symbolTable.put("8",8);
        symbolTable.put("9",9); symbolTable.put("10",10); symbolTable.put("11",11);
        symbolTable.put("12",12); symbolTable.put("13",13); symbolTable.put("14",14);
        symbolTable.put("15",15);

        // SYMBOLTABLE --- SPECIAL KEYS
        symbolTable.put("SP",0); symbolTable.put("LCL",1); symbolTable.put("ARG",2);
        symbolTable.put("THIS",3); symbolTable.put("THAT",4);
    }

    public static String getDestValue(String key){
        if (destTable.containsKey(key)){
            return destTable.get(key);
        }
        return null;
    }

    public static String getCompValue(String key){
        if (compTable.containsKey(key)){
            return compTable.get(key);
        }
        return null;
    }

    public static String getJumpValue(String key){
        if (jumpTable.containsKey(key)){
            return jumpTable.get(key);
        }
        return null;
    }

    public static Integer getSymbolValue(String key){
        if (symbolTable.containsKey(key)){
            return symbolTable.get(key);
        }
        return null;
    }

    public static boolean checkSymbolkey(String key){
        return (symbolTable.containsKey(key));
    }
}
