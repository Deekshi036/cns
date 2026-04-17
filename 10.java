import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
public class SHA1Digest { 
    // Compute SHA-1 digest and return as hexadecimal string 
    public static String computeSHA1(String text) throws NoSuchAlgorithmException { 
        MessageDigest md = MessageDigest.getInstance("SHA-1"); 
        byte[] hashBytes = md.digest(text.getBytes()); 
        // Convert byte array to hexadecimal string 
        StringBuilder hexString = new StringBuilder(); 
        for (byte b : hashBytes) { 
            String hex = Integer.toHexString(0xff & b); 
            if (hex.length() == 1) 
                hexString.append('0'); // pad single digit with leading zero 
            hexString.append(hex); 
        } 
        return hexString.toString(); 
 

 
    } 
    public static void main(String[] args) { 
        try { 
            // Test with multiple messages to demonstrate avalanche effect 
            String[] messages = { 
                "Hello World", 
                "Hello World!",   // one character different 
                "hello world",    // lowercase 
                ""               // empty string 
            }; 
            System.out.println("======================================"); 
            System.out.println("  SHA-1 Message Digest Calculator"); 
            System.out.println("======================================"); 
            for (String msg : messages) { 
                String digest = computeSHA1(msg); 
                String label  = msg.isEmpty() ? "(empty string)" : msg; 
                System.out.println("Input   : " + label); 
                System.out.println("SHA-1   : " + digest); 
                System.out.println("Length  : " + (digest.length() * 4) + " bits  (" + digest.length() + 
" hex chars)"); 
                System.out.println("--------------------------------------"); 
            } 
        } catch (NoSuchAlgorithmException e) { 
            System.out.println("Error: SHA-1 algorithm not available."); 
            e.printStackTrace(); 
        } 
 

 
    } 
} 




/*Output: 
====================================== 
  SHA-1 Message Digest Calculator 
====================================== 
Input   : Hello World 
SHA-1   : 0a4d55a8d778e5022fab701977c5d840bbc486d0 
Length  : 160 bits  (40 hex chars) -------------------------------------- 
Input   : Hello World! 
SHA-1   : 2ef7bde608ce5404e97d5f042f95f89f1c232871 
Length  : 160 bits  (40 hex chars) -------------------------------------- 
Input   : hello world 
SHA-1   : 2aae6c35c94fcfb415dbe95f408b9ce91ee846ed 
Length  : 160 bits  (40 hex chars) -------------------------------------- 
Input   : (empty string) 
SHA-1   : da39a3ee5e6b4b0d3255bfef95601890afd80709 
Length  : 160 bits  (40 hex chars) --------------------------------------*/
