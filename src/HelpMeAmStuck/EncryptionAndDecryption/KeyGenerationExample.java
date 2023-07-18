package HelpMeAmStuck.EncryptionAndDecryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyGenerationExample {
    public static void GettingKeys() {
        try {

            KeyGenerator keyGen = KeyGenerator.getInstance("AES");


            SecretKey secretKey = keyGen.generateKey();


            byte[] encodedKey = secretKey.getEncoded();
            System.out.println("Generated Key: " + bytesToHex(encodedKey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
