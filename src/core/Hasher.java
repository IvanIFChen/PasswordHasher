package core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class Hasher {

	public static String sha(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA-224");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
	
	public static String translate(String input) {
		
		char[] customTable =
		{
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'D', 'C', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=',
				'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', ',', '.', '/', ';',
				'\'', '[', ']', '\\', '<', '>', '?', ':', '"', '{', '}', '|', 'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
		};
		
		String passOut = "";
		for (int i = 0; i < 8; i++) {
			int section = Integer.parseInt(input.substring(i * 7, (i * 7) + 7), 16);
			passOut += customTable[(section >> 7) % 128];
			passOut += customTable[(section & 0x3fff) % 128];
		}
		return passOut;
	}
}
