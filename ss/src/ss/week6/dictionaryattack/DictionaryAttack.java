package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException 
	 */
	public void readPasswords(String filename) throws IOException {
		passwordMap = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new FileReader(filename));
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			String[] fline = line.split(": ");
			passwordMap.put(fline[0], fline[1]);
		}
		in.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return Hex.encodeHexString(md.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		if (passwordMap.containsKey(user)) {
			return passwordMap.get(user).equals(getPasswordHash(password));
		}else {
			return false;
		}
		
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws IOException 
	 */
    	public void addToHashDictionary(String filename) throws IOException {        
    		hashDictionary = new HashMap<String, String>();
    		BufferedReader in = new BufferedReader(new FileReader(filename));
    		for (String line = in.readLine(); line != null; line = in.readLine()) {
    			hashDictionary.put(line, getPasswordHash(line));
    		}
    		in.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (String user : passwordMap.keySet()) {
			for (String pass : hashDictionary.keySet()) {
				if (checkPassword(user, pass)) {
					System.out.printf("%-10s %s %n", user, pass);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("LeakedPasswords.txt");
		da.addToHashDictionary("pass.txt");
		da.doDictionaryAttack();
	}

/*	6.23
 * 	26^4 = 456,976
 */
}
