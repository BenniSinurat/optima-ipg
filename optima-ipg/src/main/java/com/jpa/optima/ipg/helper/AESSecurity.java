package com.jpa.optima.ipg.helper;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class AESSecurity {
	private static Logger logger = Logger.getLogger(AESSecurity.class);
	
	public static String encrypt(String src, String encryptKey, String timestamp) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, makeKey(encryptKey), makeIv(timestamp));
			
			String encoded = Base64.getEncoder().encodeToString(cipher.doFinal(src.getBytes()));
			logger.info("ENCRYPT: " + encoded);
			return encoded;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String src, String encryptKey, String timestamp) {
		String decrypted = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, makeKey(encryptKey), makeIv(timestamp));
			decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(src)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		logger.info("DECRYPT :" + decrypted);
		return decrypted;
	}

	public static AlgorithmParameterSpec makeIv(String timestamp) {
		try {
			return new IvParameterSpec(timestamp.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Key makeKey(String encryptKey) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] key = md.digest(encryptKey.getBytes("UTF-8"));
			return new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
