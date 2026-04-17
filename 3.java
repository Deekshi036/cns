import java.util.*;

public class CryptoExperiment3 
{
    // ---------- Caesar Cipher ----------
    static String caesarEncrypt(String text, int key) 
    {
        String result = "";
        for (int i = 0; i < text.length(); i++) 
        {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) 
            {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char)((ch - base + key) % 26 + base);
            }
            result += ch;
        }
        return result;
    }

    static String caesarDecrypt(String text, int key) 
    {
        return caesarEncrypt(text, 26 - key);
    }

    // ---------- Substitution Cipher ----------
    static String substitutionEncrypt(String text) 
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String sub   = "zyxwvutsrqponmlkjihgfedcba";
        text = text.toLowerCase();
        String result = "";

        for (int i = 0; i < text.length(); i++) 
        {
            char ch = text.charAt(i);
            int index = alpha.indexOf(ch);
            if (index != -1)
                result += sub.charAt(index);
            else
                result += ch;
        }
        return result;
    }

    static String substitutionDecrypt(String text) 
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String sub   = "zyxwvutsrqponmlkjihgfedcba";
        String result = "";

        for (int i = 0; i < text.length(); i++) 
        {
            char ch = text.charAt(i);
            int index = sub.indexOf(ch);
            if (index != -1)
                result += alpha.charAt(index);
            else
                result += ch;
        }
        return result;
    }

    // ---------- Hill Cipher (2x2 simple) ----------
    static void hillCipher() 
    {
        int[][] key = {{3, 3}, {2, 5}};
        String text = "HI";
        int[] msg = new int[2];
        int[] res = new int[2];

        for (int i = 0; i < 2; i++)
            msg[i] = text.charAt(i) - 'A';

        for (int i = 0; i < 2; i++) 
        {
            res[i] = 0;
            for (int j = 0; j < 2; j++)
                res[i] += key[i][j] * msg[j];

            res[i] %= 26;
        }

        System.out.print("Hill Cipher Encrypted: ");
        for (int i = 0; i < 2; i++)
            System.out.print((char)(res[i] + 'A'));
        System.out.println();
    }

    // ---------- Main ----------
    public static void main(String[] args) 
    {
        String text = "HELLO";
        int key = 3;

        System.out.println("Original Text: " + text);

        // Caesar
        String c1 = caesarEncrypt(text, key);
        System.out.println("Caesar Encrypted: " + c1);
        System.out.println("Caesar Decrypted: " + caesarDecrypt(c1, key));

        // Substitution
        String s1 = substitutionEncrypt(text);
        System.out.println("Substitution Encrypted: " + s1);
        System.out.println("Substitution Decrypted: " + substitutionDecrypt(s1));

        // Hill
        hillCipher();
    }
}





//output
Original Text: HELLO 
Caesar Encrypted: KHOOR 
Caesar Decrypted: HELLO 
Substitution Encrypted: svool 
Substitution Decrypted: hello 
Hill Cipher Encrypted: TC
