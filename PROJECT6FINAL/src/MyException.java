/**
 * Created by Sai Nikhilesh Reddy at 00:52 , on 23-12-2019.
 */
public class MyException extends Exception {
    public static void fileTester(int filelength) throws ArrayIndexOutOfBoundsException{
        if (filelength == 0){
            throw(new ArrayIndexOutOfBoundsException("File Not Entered"));
        }
    }
}
