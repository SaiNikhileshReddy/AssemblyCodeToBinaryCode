import java.util.Scanner;

/**
 * Created by Sai Nikhilesh Reddy at 10:36 , on 18-12-2019.
 */
public class C_Line {
    private static Database database = new Database();
    private static Scanner scan = new Scanner(System.in);

    public static String mainKey(String sentence){
        String cLine = sentence;

        int pDest = 0;
        String sDest = null;
        String destValue;

        int pComp = 0;
        String sComp = null;
        String compValue;

        int pJump = 0;
        String sJump = null;
        String jumpValue;

        int commentVariablePositon = 0 ;
        String finalMachineCode;



        for (int i = 0; i<cLine.length(); i++){

            // comment variable position
            if (i<=(cLine.length()-2)){
                if (cLine.charAt(i) == '/' && cLine.charAt(i+1) == '/'){
                    commentVariablePositon = i;
                }
            }

            // dest KEYWORD
             if (cLine.charAt(i) == '=' && pDest ==0){
                 if (i<commentVariablePositon || commentVariablePositon==0){
                     pDest = i;
                     sDest = cLine.substring(0,(i)).trim();
                 }
             }

             // comp KEYWORD
            if (cLine.charAt(i) == ';' && pComp == 0){
                pComp = i;
            }
            if (pDest !=0 && pComp ==0){
                int positionTemp = (commentVariablePositon == 0) ? cLine.length() : commentVariablePositon;
                sComp = cLine.substring((pDest+1),(positionTemp)).trim();
            }
            if (pDest==0 && pComp !=0){
                sComp = cLine.substring(pDest,pComp);
            }

            // jump KEYWORD
            if (pComp != 0 && pDest == 0){
                pJump = (commentVariablePositon == 0) ? cLine.length() : commentVariablePositon;
                sJump = cLine.substring((pComp+1),pJump).trim();
            }
        }

        String value = null;
        value = (sDest == null) ? "" : sDest;
        destValue = database.getDestValue(value);
        compValue = database.getCompValue(sComp);
        value = (sJump == null) ? "" : sJump;
        jumpValue = database.getJumpValue(value);

//        System.out.println("Dest key = "+sDest+":"+destValue);
//        System.out.println("Comp key = "+sComp+":"+compValue);
//        System.out.println("Jump key = "+sJump+":"+jumpValue);

        finalMachineCode = "111"+compValue+destValue+jumpValue;

        /*System.out.println("dest is :"+sDest+":");
        System.out.println("comp is :"+sComp+":");
        System.out.println("jump is :"+sJump+":");


        System.out.println("\n\ndest Key :"+sDest+":");
        System.out.println("dest Value :"+destValue+":");


        System.out.println("comp Key :"+sComp+":");
        System.out.println("comp Value :"+compValue+":");


        System.out.println("jump Key :"+sJump+":");
        System.out.println("jump Value :"+jumpValue+":");


        System.out.println("\nFinal code :"+finalMachineCode);*/

        return finalMachineCode;
    }
}
