package lab;
import junit.framework.TestCase;

public class CryptoManagerGFATest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
    public void testIsStringInBounds() {
        // All caps letters are within the bounds (' ' to '_')
        assertTrue(CryptoManager.isStringInBounds("MONTGOMERY"));
    }

	public void testVigenereEncryptDecrypt() {
        String plain = "MONTGOMERY";
        String key = "MNT";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        
        // This confirms that the decryption process reverses the encryption process
        // to retrieve the original plaintext.
        assertEquals(plain, decrypted);
    }
    
}