/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: (Using cyphers encrpyt and decrpyt messages)
 * Due: 10/13/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Adam Lee
*/

package lab;
/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * Choose a keyword (e.g., KEY).
	 * Repeat the keyword to match the length of the plaintext.
	 * Each letter in the plaintext is shifted by the position of the 
	 * corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
        if (!isStringInBounds(plainText)) return null;
        String expandedKey = "";
        for (int i = 0; i < plainText.length(); i++) {
            expandedKey += key.charAt(i % key.length());
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int plainChar = plainText.charAt(i);
            int keyChar = expandedKey.charAt(i);
            int encryptedChar = plainChar + (keyChar - LOWER_RANGE);
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText)) return null;
        String expandedKey = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            expandedKey += key.charAt(i % key.length());
        }
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            int encryptedChar = encryptedText.charAt(i);
            int keyChar = expandedKey.charAt(i);
            int plainChar = encryptedChar - (keyChar - LOWER_RANGE);
            while (plainChar < LOWER_RANGE) {
                plainChar += RANGE;
            }
            plainText.append((char) plainChar);
        }
        return plainText.toString();
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 * Same row: replace each letter with the one to its right.
	 * Same column: replace each with the one below.
	 * Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    // --- Playfair Helper Methods ---
    private static int getRow(char c) { return ALPHABET64.indexOf(c) / 8; }
    private static int getCol(char c) { return ALPHABET64.indexOf(c) % 8; }
    private static char getChar(int row, int col) {
        int wrappedRow = (row % 8 + 8) % 8;
        int wrappedCol = (col % 8 + 8) % 8;
        return ALPHABET64.charAt((wrappedRow * 8) + wrappedCol);
    }
    
    private static String preparePlayfairText(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == ' ') continue; 
            sb.append(current);
        }
        if (sb.length() % 2 != 0) {
            sb.append('_'); // Padding
        }
        return sb.toString();
    }
    // --- End Playfair Helpers ---
    
    public static String playfairEncryption(String plainText, String key) {
        if (!isStringInBounds(plainText)) return null;
        
        String cleanText = preparePlayfairText(plainText);
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < cleanText.length(); i += 2) {
            char char1 = cleanText.charAt(i);
            char char2 = cleanText.charAt(i + 1);

            int r1 = getRow(char1), c1 = getCol(char1);
            int r2 = getRow(char2), c2 = getCol(char2);

            if (r1 == r2) { // Same Row Rule: Shift Right (+1 column)
                cipherText.append(getChar(r1, c1 + 1));
                cipherText.append(getChar(r2, c2 + 1));
            } else if (c1 == c2) { // Same Column Rule: Shift Down (+1 row)
                cipherText.append(getChar(r1 + 1, c1));
                cipherText.append(getChar(r2 + 1, c2));
            } else { // Rectangle Rule: Swap Columns
                cipherText.append(getChar(r1, c2));
                cipherText.append(getChar(r2, c1));
            }
        }
        return cipherText.toString();
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText)) return null;

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i += 2) {
            char char1 = encryptedText.charAt(i);
            char char2 = encryptedText.charAt(i + 1);

            int r1 = getRow(char1), c1 = getCol(char1);
            int r2 = getRow(char2), c2 = getCol(char2);

            if (r1 == r2) { // Same Row Rule: Shift Left (-1 column)
                plainText.append(getChar(r1, c1 - 1));
                plainText.append(getChar(r2, c2 - 1));
            } else if (c1 == c2) { // Same Column Rule: Shift Up (-1 row)
                plainText.append(getChar(r1 - 1, c1));
                plainText.append(getChar(r2 - 1, c2));
            } else { // Rectangle Rule: Swap Columns (Rule is symmetric)
                plainText.append(getChar(r1, c2));
                plainText.append(getChar(r2, c1));
            }
        }
        // A full implementation requires code to remove padding character ('_') 
        // and re-insert original spaces for full functionality.
        return plainText.toString();
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) return null;
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            int encryptedChar = plainChar + key;
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) return null;
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            int plainChar = encryptedChar - key;
            while (plainChar < LOWER_RANGE) {
                plainChar += RANGE;
            }
            plainText.append((char) plainChar);
        }
        return plainText.toString();
    }    

}