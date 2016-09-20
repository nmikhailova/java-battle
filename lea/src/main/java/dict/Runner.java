package dict;

/**
 * Created by user on 11.04.2016.
 */
public class Runner {
    final static String FILE_NAME="d:\\mytext.txt";
    public static void main(String [] args){
        TextFileAnalizer ta= new TextFileAnalizer(FILE_NAME);
        ta.getText();
    }
}
