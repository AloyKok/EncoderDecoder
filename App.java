import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        EncoderDecoder encoderDecoder = new EncoderDecoder();

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Choose (1) to encode or (2) to decode a message:");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Enter your message to encode:");
                String message = input.nextLine();
                String encoded = encoderDecoder.encode(message);
                System.out.println("Encoded message: " + encoded);
            } else if (choice == 2) {
                System.out.println("Enter your message to decode:");
                String encodedMessage = input.nextLine();
                String decoded = encoderDecoder.decode(encodedMessage);
                System.out.println("Decoded message: " + decoded);
            }
        }

    }
}
