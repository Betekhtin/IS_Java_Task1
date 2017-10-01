/**
 * Class for translating hexadecimal numbers to decimal
 * @author Betehtin Artem
 */
class HexToDec {

    /**
     * Convert input hexadecimal string into a decimal number
     *
     * @param input hexadecimal string to convert
     * @return converted decimal number
     * @throws IllegalArgumentException if input string is not a hexadecimal number
     */
    static Long convert(String input){
        if (input.matches("[0-9A-F]+")){ //Check if input string is hex number
            return Long.parseLong(input, 16);
        } else {
            throw new IllegalArgumentException("Input string must be hexadecimal number.");
        }
    }

}
