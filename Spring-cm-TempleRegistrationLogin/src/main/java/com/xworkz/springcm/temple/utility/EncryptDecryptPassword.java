package com.xworkz.springcm.temple.utility;

import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class EncryptDecryptPassword {
	
	private static final Logger logger=Logger.getLogger(EncryptDecryptPassword.class);

	public EncryptDecryptPassword() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}
	
	public static String encrypt(String strToEncrypt) {
		return Base64.getEncoder().encodeToString(strToEncrypt.getBytes());
	}

	public static String decrypt(String strToDecrypt) {
		return new String(Base64.getMimeDecoder().decode(strToDecrypt));
	}
	
//	public static String encrypt(byte[] strToEncrypt) {
//		byte[] enc=new byte[strToEncrypt.length];
//		
//		for(int i=0;i<strToEncrypt.length;i++) {
//			enc[i]=(byte)((i%2==0) ? strToEncrypt[i]+1 : strToEncrypt[i]-1);
//		}
//		return new String(strToEncrypt);
//	}
//	
//	public static String decrypt(byte[] strToDecrypt) {
//		byte[] enc=new byte[strToDecrypt.length];
//		
//		for(int i=0;i<strToDecrypt.length;i++) {
//			enc[i]=(byte)((i%2==0) ? strToDecrypt[i]-1 : strToDecrypt[i]+1);
//		}
//		return new String(strToDecrypt);
//	}
	
	
//	private static String secretKey = "sweetysweetysweety!!!!";
//	private static String salt = "hellohellohellohello!!!!";
//	
//	public static String encrypt(String strToEncrypt) {
//		try {
//			logger.info("invoked encrypt method in PasswordCryptionServiceImpl ");
//			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//			IvParameterSpec ivspec = new IvParameterSpec(iv);
//
//			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
//			SecretKey tmp = factory.generateSecret(spec);
//			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
//
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
//			String encryptedPassword = Base64.getEncoder()
//					.encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//			logger.info("encryptedPassword: " + encryptedPassword);
//			return encryptedPassword;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		return null;
//	}
//
//	public static String decrypt(String strToDecrypt) {
//		try {
//			logger.info("invoked decrypt method in PasswordCryptionServiceImpl ");
//			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//			IvParameterSpec ivspec = new IvParameterSpec(iv);
//
//			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
//			SecretKey tmp = factory.generateSecret(spec);
//			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
//
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
//			String decryptedPassword = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//			return decryptedPassword;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		return null;
//	}
	
}

//	public static final String ALGO = "AES";
//
//	private byte[] keyValue = "lv39eptlvuhaqqsr".getBytes();
//
//
//	public String encryptData(String encData) throws Exception {
//		Key key = generateKey();
//		Cipher c = Cipher.getInstance(ALGO);
//		c.init(Cipher.ENCRYPT_MODE, key);
//		byte[] encVal = c.doFinal(encData.getBytes());
//		String encryptedValue = new Base64Decoder().encode(encVal);
//		return encryptedValue;
//	}
//	
//	public String decrypti(String enData) throws Exception {
//		Key key = generateKey();
//		Cipher c=Cipher.getInstance(ALGO);
//		c.init(Cipher.DECRYPT_MODE, key);
//		byte[] decodeValue=new BASE64Decoder().decodeBuffer(enData);
//		byte[] decVal=c.doFinal(decodeValue);
//		String decValue=new String(decVal);
//		
//		return decValue;
//		
//	}
//
//	private Key generateKey() {
//		Key key = new SecretKeySpec(keyValue, ALGO);
//		return key;
//	}
