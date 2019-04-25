package com.rainyhon.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class Object2Byte {

	/**
	 * @param objBytes
	 * @return
	 * @throws Exception
	 */
	public static <T> T getObjectFromBytes(byte[] objBytes) {
		if (objBytes == null || objBytes.length == 0) {
			return null;
		}
		try {
			ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (T) oi.readObject();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return null;
	}

	/**
	 * 从对象获取一个字节数组
	 *
	 * @EditTime 2007-8-13 上午11:46:56
	 */
	public static <T> byte[] getBytesFromObject(T obj) {
		try {
			if (obj == null) {
				return null;
			}
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			return bo.toByteArray();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return null;
	}
}
