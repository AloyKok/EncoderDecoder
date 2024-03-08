# EncoderDecoder
Encoder that takes in a plaintext and encodes it to another obfuscated string. Decoder for the encoded text.

Logic:
Choose any character in the reference table as the offset.
The first character of the encoded message will be the
offset character. Any character not in the reference table
will mapped back to the same character.
For example, if the offset character is B, the entire table
will shift by 1 element down (Refer to Shift Table #1).
Thus, given the plaintext HELLO WORLD, it will be
encoded as BGDKKN VNQKC:

HOW TO USE:
- Run the main App.java
- Pick option 1 (encode) or 2 (decode)
- Enter your plaintext or encoded text
- It will display your encoded or decoded text!
