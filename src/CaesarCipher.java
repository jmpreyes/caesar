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
 * (Need to initialize the array of characters (alphabet) instead so only
 * alphabet is returned as output. Since the code uses the character's
 * ASCII value, the result may include other special characters which may
 * not be readable based on the text encoding.)
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
    
    /**
     * The constructor passes an integer as the key necessary for 
     * encryption and decryption. If the key is a valid number, set it as the
     * value for field. Else, set it to 0. Since there is no wrapping or
     * boundary for key values, this check is not implemented.
     * 
     * @param key               type integer 
     */
    public CaesarCipher(int key) {
        this.key = key;
    }

    /**
     * Returns a string which is the result of encryption. The character's
     * value is shifted based on the key passed into the constructor.
     * Not very efficient.
     * 
     * @param plainText         type String
     * @return                  type String
     */
    public String encrypt(String plainText) {
        String enc = "";
        for (int i = 0; i < plainText.length(); i++){
            char ch = (char)(plainText.codePointAt(i) + key);
            //char ch = (char)((plainText.codePointAt(i) + key) % 26);
            enc += ch;
        }
        return enc;
    }
    
    /**
     * Returns the original plain text using the same key from encryption.
     * Not very efficient.
     * 
     * @param cipherText        type String
     * @return                  type String
     */
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
