package com.rainyhon.common.util;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Base64;


/**
 * BASE64编码解码工具包
 * 依赖javabase64-1.3.1.jar
 *
 */
@Slf4j
public class Base64Utils {


	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;

	private static final String charsetName = "UTF-8";

	/**
	 * 编码
	 */
	public static String base64Ecode(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		try {
			return new String(Base64.getEncoder().encode(str.getBytes(charsetName)));
		} catch (UnsupportedEncodingException e) {
			log.info("编码不支持",e.getMessage());
		}
		return null;
	}

	/**
	 * 解码
	 */
	public static String base64Dcode(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		try {
			return new String(Base64.getDecoder().decode(str), charsetName);
		} catch (UnsupportedEncodingException e) {
			log.info("编码不支持",e.getMessage());
		}
		return null;
	}

	/**
	 * BASE64字符串解码为二进制数据
	 *
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode(String base64) {
		//.getDecode(base64.getBytes())
		return Base64.getDecoder().decode(base64);
	}

	/**
	 * 二进制数据编码为BASE64字符串
	 *
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] bytes) {
//        return new String(Base64.encode(bytes));
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * 将文件编码为BASE64字符串
	 * 大文件慎用，可能会导致内存溢出
	 *
	 * @param filePath 文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static String encodeFile(String filePath) throws Exception {
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}

	/**
	 * BASE64字符串转回文件
	 *
	 * @param filePath 文件绝对路径
	 * @param base64   编码字符串
	 * @throws Exception
	 */
	public static void decodeToFile(String filePath, String base64) throws Exception {
		byte[] bytes = decode(base64);
		byteArrayToFile(bytes, filePath);
	}

	/**
	 * 文件转换为二进制数组
	 *
	 * @param filePath 文件路径
	 * @return
	 * @throws Exception
	 */
	private static byte[] fileToByte(String filePath) throws Exception {
		byte[] data = new byte[0];
		File file = new File(filePath);
		if (file.exists()) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while ((nRead = in.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}
			out.close();
			in.close();
			data = out.toByteArray();
		}
		return data;
	}

	/**
	 * 二进制数据写文件
	 *
	 * @param bytes    二进制数据
	 * @param filePath 文件生成目录
	 */
	private static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		if (destFile.createNewFile()) {
			OutputStream out = new FileOutputStream(destFile);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead;
			while ((nRead = in.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}
			out.close();
			in.close();
		}
	}

}
