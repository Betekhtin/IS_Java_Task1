/**
 * Class for translating hexadecimal numbers to decimal
 * @author Betehtin Artem
 */
class HexToDec {

    private static String hex_digits = "0123456789ABCDEF";

    /**
     * Convert input hexadecimal string into a decimal number using standard Java methods
     *
     * @param input hexadecimal string to convert
     * @return converted decimal number
     * @throws IllegalArgumentException if input string is not a hexadecimal number
     */
    static Long convertStandard(String input){
        if (input.matches("[0-9A-F]+")) //Check if input string is hex number
            throw new IllegalArgumentException("Input string must be hexadecimal number.");
        return Long.parseLong(input, 16);
    }

    /**
     * Convert input hexadecimal string into a decimal number using iteration through the input string
     *
     * @param input hexadecimal string to convert
     * @return converted decimal number
     * @throws IllegalArgumentException if input string is not a hexadecimal number
     */
    static Long convert(String input) {
        if (input.matches("[0-9A-F]+")) //Check if input string is hex number
            throw new IllegalArgumentException("Input string must be hexadecimal number.");
        Long result = 0L;
        Long current_pow = 1L;
        String s = new StringBuilder(input).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            result += hex_digits.indexOf(s.charAt(i)) * current_pow;
            current_pow *= 16;
        }
        return result;
    }

}
