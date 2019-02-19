package com.microcore.center.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * MD5加密算法<br/>
 * SHA加密算法<br/>
 * @author Administrator
 *
 */
public class Encode {

	/** MD5加密算法 **/
	public static byte[] MD5Encode(byte[] obj) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(obj);
			return md5.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String MD5Encode(String data) {
		return Base64.getEncoder().encodeToString(MD5Encode(Base64.getDecoder().decode(data)));
	}
	
	/**
	 * SHA 加密算法
	 **/
	public static byte[] SHAEncode(byte[] obj) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("SHA");
			md5.update(obj);
			return md5.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String SHAEncode(String data) {
		return Base64.getEncoder().encodeToString(SHAEncode(Base64.getDecoder().decode(data)));
	}

}
