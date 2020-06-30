package challenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        CriptografiaCesariana cryptography = new CriptografiaCesariana();
        Scanner read = new Scanner(System.in);
        System.out.println("Type/Declare the text: ");
        String text = read.nextLine();
        String encryptedText = cryptography.criptografar(text);
        System.out.println("Encrypted Text");
        System.out.println(encryptedText);
        String decryptedText = cryptography.descriptografar(encryptedText);
        System.out.println("Decrypted Text");
        System.out.println(decryptedText);
    }
}