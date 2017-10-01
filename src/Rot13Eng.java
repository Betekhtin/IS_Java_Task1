/**
 * Implementation of the ROT13 encoder/decoder for the english alphabet
 * @author Betehtin Artem
 */
class Rot13Eng {

    private static String encode_str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static String decode_str = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";

    /**
     * This method takes the input string and encode it with ROT13 cipher.
     * The algorithm takes a letter from the input string and substitute it with corresponding letter
     * from the decode string. Encode string is used to find the index of the encoding letter in the decode string.
     *
     * @param input string to encode
     */
    static String encode(String input){
        StringBuilder output = new StringBuilder(); // Get a StringBuilder to build encoded string gradually
        for (int i = 0; i < input.length(); ++i) {
            char current_char = input.charAt(i);
            // Check if current character is a letter in the encoding string
            if (encode_str.indexOf(current_char) >= 0) {
                output.append(decode_str.charAt(encode_str.indexOf(current_char))); // Get encoded letter
            } else {
                // If not, append it as it is
                output.append(current_char);
            }
        }
        return output.toString();
    }

    /**
     * Since english alphabet is 26 characters, rotating it by 13 letters back(decoding) will give the same result
     * as rotating it by 13 letters forward(encoding).
     *
     * @param input string to decode
     */
    static String decode(String input){
        return encode(input);
    }
}
