package lab;

import junit.framework.TestCase;

public class CryptoManagerTestStudent extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
    public void testIsStringInBoundsUnique() {
        assertTrue(CryptoManager.isStringInBounds("TEST! 123_"));
        assertFalse(CryptoManager.isStringInBounds("invalid test a"));
    }

	public void testVigenereEncryptDecryptUnique() {
        String plain = "ASSIGNMENT THREE";
        String key = "CMSC";
        
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        
        assertEquals(plain, decrypted);
    }
    
    public void testCaesarEncryptDecryptUnique() {
        String plain = "FINAL CHECK 9!";
        int key = 70; 
        
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        
        assertEquals(plain, decrypted);
    }
    
    public void testPlayfairEncryptDecryptUnique() {
        String plain = "GREAT JOB NOW";
        String key = "PASSED";
        
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        
        // Note: The Playfair implementation removes spaces and pads to an even length.
        // Expected result after cleanup is GREATJOBNOW_
        assertEquals("GREATJOBNOW_", decrypted); 
    }
}