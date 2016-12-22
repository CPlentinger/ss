package ss.week5;

import java.nio.charset.Charset;

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
       
        System.out.println(new String(Base64.encode(input.getBytes())));
        
        String input4 = "010203040506";
        System.out.println(new String(Base64.encode(Hex.decodeHex(input4.toCharArray()))));
        
        String input5 = "U29mdHdhcmUgU3lzdGVtcw==";
        System.out.println(new String(Base64.base64Decode(input5)));
        
        String input6a = "a";
        String input6b = "aa";
        String input6c = "aaa";
        String input6d = "aaaa";
        String input6e = "aaaaa";
        String input6f = "aaaaaa";
        String input6g = "aaaaaaa";
        String input6h = "aaaaaaaa";
        String input6i = "aaaaaaaaa";
        String input6j = "aaaaaaaaaa";
        System.out.println(new String(Base64.encode(input6a.getBytes())));
        System.out.println(new String(Base64.encode(input6b.getBytes())));
        System.out.println(new String(Base64.encode(input6c.getBytes())));
        System.out.println(new String(Base64.encode(input6d.getBytes())));
        System.out.println(new String(Base64.encode(input6e.getBytes())));
        System.out.println(new String(Base64.encode(input6f.getBytes())));
        System.out.println(new String(Base64.encode(input6g.getBytes())));
        System.out.println(new String(Base64.encode(input6h.getBytes())));
        System.out.println(new String(Base64.encode(input6i.getBytes())));
        System.out.println(new String(Base64.encode(input6j.getBytes())));
    }
}
