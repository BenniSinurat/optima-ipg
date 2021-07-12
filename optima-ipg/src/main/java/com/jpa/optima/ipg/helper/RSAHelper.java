package com.jpa.optima.ipg.helper;

import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.python.bouncycastle.util.io.pem.PemObject;
import org.python.bouncycastle.util.io.pem.PemReader;

public class RSAHelper {

	public static String encrypt(String publicKeyPem, String plainText)
			throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		// Read PEM Format
		PemReader pemReader = new PemReader(new StringReader(publicKeyPem));
		byte[] content = pemReader.readPemObject().getContent();
		// Get X509EncodedKeySpec format
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(content);

		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKeySecret = kf.generatePublic(keySpec);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKeySecret);
		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

		return new String(Base64.getEncoder().encode(encryptedBytes));
	}
	
	 public static String decrypt(String privateKeyPem,String encryptedString) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
	        // Read PEM Format
	        PemReader pemReader = new PemReader(new StringReader(privateKeyPem));
	        PemObject pemObject = pemReader.readPemObject();
	        pemReader.close();

	        // Get PKCS8EncodedKeySpec for decrypt
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pemObject.getContent());
	        KeyFactory kf = KeyFactory.getInstance("RSA");
	        PrivateKey privateKeySecret = kf.generatePrivate(keySpec);

	        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        cipher.init(Cipher.DECRYPT_MODE, privateKeySecret);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedString)), "UTF-8");

	    }

}
