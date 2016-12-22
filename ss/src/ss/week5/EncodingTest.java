package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.sun.xml.internal.messaging.saaj.util.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        String input2 = "Hellow Big World";
        System.out.println(Hex.encodeHexString(input2.getBytes()));
        
        String input3 = "4d6f64756c652032"; 
        byte[] input3b = Hex.decodeHex(input3.toCharArray());
        System.out.println(new String(input3b));
       
        byte[] inputb = Base64.encode("Hello World".getBytes());
        System.out.println(Base64.base64Decode(inputb.toString()));
    }
}
