import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//simport java.util.Random;

/**
 * This is the main method/driver of the program.
 * The driver initializes an integer key value for encryption.
 * Random numbers from 1 to 26 (or 0 to 25) may be used instead.
 * 
 * The input file for encryption is "in.txt" and the encrypted output
 * is "out.txt". A testing file called "test.txt" is used to test
 * or verify the functionality of the encrypt method.
 * 
 * @author Joseph
 */
public class Driver {
    public static void main(String[] args) throws Exception {
        //Random r = new Random();
        //int key = r.nextInt(26) + 1;
        int key = 5;
        
        //System.out.println("Random number for key: " + key);
        //BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), "UTF-8"));
        String text = "";
        try {
            System.out.println("***** Read from input file \"in.txt\" *****");
            CaesarCipher cc = new CaesarCipher(key);
            while ((text = br.readLine()) != null) {
                String enc = cc.encrypt(text);
                bw.write(enc + "\n");
                bw.flush();
            }
            System.out.println("***** Encrypted file written in \"out.txt\" *****");
        } catch (Exception e) {
            System.err.println("Exception > " + e.toString());
        } finally {
            if (br != null) br.close();
            if (bw != null) bw.close();
        }
    }
}
