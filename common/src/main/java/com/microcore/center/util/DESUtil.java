package com.microcore.center.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

public class DESUtil {

	// 密码，长度要是8的倍数    注意此处为简单密码  简单应用 要求不高时可用此密码

	/*
	 * DES是一种对称加密算法。所谓对称加密算法，即加密和解密使用相同密钥的算法。
	 * DES加密算法出自IBM的研究，后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，
	 * 因为DES使用56位密钥，以现代计算能力，24小时内即可被破解。
	 */

	private static String password = "wish30_microcore";

	public static void main(String[] args) {
		//待加密内容
		String str = "task_id=TSK_000000006870&ledger_id=0715-5572";
		String result = DESUtil.encrypt(str);
		Encoder base64en = Base64.getEncoder();
		System.out.println("加密后：" + result);
//        result = "2+/+xd8Xknr+uVm31GQvyw==" ;
		// 直接将如上内容解密
		try {
			String decryResult = DESUtil.decryptor(result);
			System.out.println("解密后：" + new String(decryResult));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 3; i++) {
			String a = "1234";
			String res = DESUtil.encrypt(str);
			System.out.println(res);
		}

	}

	/**
	 * 加密数据
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 * @Method encrypt
	 * @date 2016年7月26日
	 */
	public static String encrypt(String data) {  //对string进行BASE64Encoder转换
		byte[] bt = encryptByKey(data.getBytes(), password);
		Encoder base64en = Base64.getEncoder();
		return new String(base64en.encode(bt));
	}

	/**
	 * 解密数据
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 * @Method: encrypt
	 * @date 2016年7月26日
	 */
	public static String decryptor(String data) throws Exception {  //对string进行BASE64Encoder转换
		byte[] bt = decrypt(Base64.getDecoder().decode(data), password);
		return new String(bt);
	}

	/**
	 * 加密
	 *
	 * @param datasource byte[]
	 * @param key        String
	 * @return byte[]
	 */
	private static byte[] encryptByKey(byte[] datasource, String key) {
		try {
			SecureRandom random = new SecureRandom();

			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			//创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			//Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			//用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			//现在，获取数据并加密
			//正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 *
	 * @param src byte[]
	 * @param key String
	 * @return byte[]
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] src, String key) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(key.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

}

