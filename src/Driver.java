import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

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
