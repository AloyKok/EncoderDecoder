import java.util.Random;

public class EncoderDecoder {

    private final String referenceTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private final Random random = new Random();

    /**
     * Helper Function to create the new shift table
     * 
     * @param offsetChar
     * @return shiftedTable
     */
    private String shiftTable(char offsetChar) {
        int shift = referenceTable.indexOf(offsetChar);
        int startIndex = (referenceTable.length() - 1 + shift) % referenceTable.length();
        String shiftedTable = referenceTable.substring(startIndex) + referenceTable.substring(0, startIndex);
        shiftedTable = shiftedTable.charAt(shiftedTable.length() - 1)
                + shiftedTable.substring(0, shiftedTable.length() - 1);

        return shiftedTable;
    }

    /**
     * Encoder Function
     * 
     * @param plainText
     * @return encoded.toString();
     */
    public String encode(String plainText) {
        if (plainText == null || plainText.isEmpty()) {
            return plainText;
        }

        char offsetChar = referenceTable.charAt(random.nextInt(referenceTable.length()));
        String newTable = shiftTable(offsetChar);

        StringBuilder encoded = new StringBuilder();
        encoded.append(offsetChar);

        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = Character.toUpperCase(plainText.charAt(i));
            int index = referenceTable.indexOf(currentChar);

            if (index != -1) {
                encoded.append(newTable.charAt(index));
            } else {
                encoded.append(currentChar);
            }
        }

        return encoded.toString();
    }

    /**
     * Decoder Function
     * 
     * @param encodedText
     * @return decoded.toString();
     */
    public String decode(String encodedText) {
        if (encodedText == null || encodedText.isEmpty()) {
            return encodedText;
        }

        char offsetChar = encodedText.charAt(0);
        String newTable = shiftTable(offsetChar);

        StringBuilder decoded = new StringBuilder();

        for (int i = 1; i < encodedText.length(); i++) {
            char currentChar = encodedText.charAt(i);
            int index = newTable.indexOf(currentChar);

            if (index != -1) {
                decoded.append(referenceTable.charAt(index));
            } else {
                decoded.append(currentChar);
            }
        }
        return decoded.toString();
    }
}
