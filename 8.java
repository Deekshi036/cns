import java.security.KeyPair; 
import java.security.KeyPairGenerator; 
import java.security.PrivateKey; 
import java.security.PublicKey; 
import javax.crypto.Cipher; 
import java.util.Base64; 
public class RSAAlgorithm { 
    // Generate RSA public/private key pair 
 

 
    public static KeyPair generateKeyPair() throws Exception { 
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); 
        keyGen.initialize(2048); // Key size: 1024, 2048, or 4096 bits 
        return keyGen.generateKeyPair(); 
    } 
    // Encrypt plaintext using RSA Public Key 
    public static String encrypt(String plainText, PublicKey publicKey) 
            throws Exception { 
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); 
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); 
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8")); 
        return Base64.getEncoder().encodeToString(encryptedBytes); 
    } 
    // Decrypt ciphertext using RSA Private Key 
    public static String decrypt(String cipherText, PrivateKey privateKey) 
            throws Exception { 
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); 
        cipher.init(Cipher.DECRYPT_MODE, privateKey); 
        byte[] decryptedBytes = 
            cipher.doFinal(Base64.getDecoder().decode(cipherText)); 
        return new String(decryptedBytes, "UTF-8"); 
    } 
    public static void main(String[] args) { 
        try { 
            String plainText = "Hello World"; 
            System.out.println("Original Text   : " + plainText); 
 

 
            // Generate RSA Key Pair 
            KeyPair keyPair = generateKeyPair(); 
            PublicKey  publicKey  = keyPair.getPublic(); 
            PrivateKey privateKey = keyPair.getPrivate(); 
            System.out.println("Public Key      : " + 
                Base64.getEncoder().encodeToString(publicKey.getEncoded())); 
            System.out.println("Private Key     : " + 
                Base64.getEncoder().encodeToString(privateKey.getEncoded())); 
            // Encrypt with Public Key 
            String encrypted = encrypt(plainText, publicKey); 
            System.out.println("Encrypted Text  : " + encrypted); 
            // Decrypt with Private Key 
            String decrypted = decrypt(encrypted, privateKey); 
            System.out.println("Decrypted Text  : " + decrypted); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
} 

/*
Output: 
Original Text    : Hello World 
Public Key        : MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB...  (truncated) 
Private Key      : MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKA...  (truncated) 
Encrypted Text  : Hy7kL2mN3pQ4rS5tU6vW7xY8zA9bC0dE1fG2hI3...  (truncated) 
Decrypted Text  : Hello World*/
