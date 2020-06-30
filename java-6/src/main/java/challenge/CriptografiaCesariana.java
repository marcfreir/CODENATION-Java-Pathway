package challenge;

public class CriptografiaCesariana implements Criptografia {

    //Validation -> verify if the input is empty
    private void verifyIfIsEmpty(String text)
    {
        if (text.isEmpty())
        {
            //In case the input is empty throw the exception IllegalArgumentException which is not allowed
            throw new IllegalArgumentException("The input can not be empty");
        }
    }

    private String convertText(String text, int key)
    {
        verifyIfIsEmpty(text);
        char[] charsInText = text.toLowerCase().toCharArray();

        //Verify each character from the input...
        StringBuilder res = new StringBuilder();
        for (char character : charsInText)
        {
            //...if is a blank
            if (character == ' ')
            {
                res.append(character);
            }
            //...if is a number
            else if (character >= '0' && character <= '9')
            {
                res.append(character);
            }
            //Otherwise execute the Caeser Cipher function
            else
            {
                //For encryption En(x) = (x + n) mod 26
                //For decryption Dn(x) = (x - n) mod 26
                int asciiMinusOffset = character - 97;
                int asciiMinusKey = asciiMinusOffset + key;
                int modOfCharacter = asciiMinusKey % 26;
                int asciiAddOffset = modOfCharacter + 97;
                char ascii = (char)asciiAddOffset;
                res.append(ascii);
            }
        }
        return res.toString();
    }
    //Encrypt by changing the key to a positive integer
    @Override
    public String criptografar(String text) {

        text = text.toLowerCase();

        return convertText(text, 3);
    }
    //Decrypt by changing the key to a negative integer
    @Override
    public String descriptografar(String text) {

        text = text.toLowerCase();

        return convertText(text, -3);
    }

}