/**
 * CaesarCipher is a shifting crytographic technique which shifts a character value by its key value.
 * The key is randomly generated between 1 and 26.
 * 
 * To encode, pText.charAt() + key = encChar
 * To decode, encChar - key = pText.charAt()
 * 
 * Note that the methods to encode and decode are NOT EFFICIENT.
 * This is the most basic way to shirt character values, but this
 * (so far) does not wrap the characters if key value is greater than 26.
 * 
 * @author Joseph
 * @version 1.0.0
 */
public class CaesarCipher {
    private int key;
    
    /*
    private final char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                  'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                                  'U', 'V', 'W', 'X', 'Y', 'Z'};
    */
    
    public CaesarCipher(int key) {
        this.key = key;
    }

    public String encrypt(String plainText) {
        String enc = "";
        for (int i = 0; i < plainText.length(); i++){
            char ch = (char)(plainText.codePointAt(i) + key);
            //char ch = (char)((plainText.codePointAt(i) + key) % 26);
            enc += ch;
        }
        return enc;
    }
    
    public String decrypt(String cipherText) {
        String dec = "";
        for (int i = 0; i < cipherText.length(); i++){
            char ch = (char)(cipherText.codePointAt(i) - key);
            //char ch = (char)((cipherText.codePointAt(i) - key) % 26);
            dec += ch;
        }
        return dec;
    }
}
