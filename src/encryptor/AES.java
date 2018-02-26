package encryptor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;;

public class AES {
	private static byte[] key;
	private static SecretKeySpec secretKey;

	/**
	 *
	 * @param toDec
	 * @param secret
	 * @return String
	 *
	 *         Takes in a String to be decrypted and a key String and returns the
	 *         decrypted String.
	 */
	public static String decrypt(String toDec, String secret) {
		try {
			setKey(secret);
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			c.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(c.doFinal(Base64.getDecoder().decode(toDec)));
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 *
	 * @param toEn
	 * @param secret
	 * @return String, encrypted
	 *
	 *         Takes in a String to be encrypted and a key String and returns the
	 *         encrypted String.
	 */
	public static String encrypt(String toEn, String secret) {
		try {
			setKey(secret);
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			c.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(c.doFinal(toEn.getBytes("UTF-8")));
		} catch (Exception e) {

		}
		return null;
	}

	private static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
		} catch (NoSuchAlgorithmException e) {

		} catch (UnsupportedEncodingException e) {

		}
	}

}
