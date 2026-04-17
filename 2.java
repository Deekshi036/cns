#include <stdio.h> 
int main() 
{ 
    char *str = "Hello World"; 
    int i = 0; 
  
 
    printf("Original String: %s\n", str); 
    // AND operation 
    printf("Result after AND with 127: "); 
    while (str[i] != '\0') 
    { 
        printf("%c", str[i] & 127); 
        i++; 
    } 
    i = 0; 
    // XOR operation 
    printf("\nResult after XOR with 127: "); 
    while (str[i] != '\0') 
    { 
        printf("%d ", str[i] ^ 127);   // printing ASCII values for clarity 
        i++; 
    } 
    return 0; 
} 




Java Program: 
public class AndXor127 
{ 
    public static void main(String[] args) 
    { 
        String str = "Hello World"; 
        System.out.println("Original String: " + str); 
 
 
 
        // AND operation 
        System.out.print("Result after AND with 127: "); 
        for (int i = 0; i < str.length(); i++) 
        { 
            char result = (char)(str.charAt(i) & 127); 
            System.out.print(result); 
        } 
        // XOR operation 
        System.out.print("\nResult after XOR with 127: "); 
        for (int i = 0; i < str.length(); i++) 
        { 
            int result = (str.charAt(i) ^ 127); 
            System.out.print(result + " "); 
        } 
    } 
} 
Output: 
Original String: Hello World 
Result after AND with 127: Hello World 
Result after XOR with 127: 55 26 19 19 16 95 40 16 13 19 27
