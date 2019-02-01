package com.microcore.center.context;

import java.util.*;

import com.microcore.common.util.CommonUtil;
import com.microcore.common.util.RandomUtil;

public class VCodeContext {

	private static final Map<String, VCodeInfo> VCODE = new HashMap<>();

	public static String addVCodeInfo(String id) {
		String vCode = RandomUtil.randomNumber(6);
		return addVCodeInfo(id, vCode);
	}

	public static String addVCodeInfo(String id, String vCode) {
		return addVCodeInfo(id, vCode, new Date(CommonUtil.getCurrentTime().getTime() + 1000 * 60 * 5));
	}

	private static String addVCodeInfo(String id, String vCode, Date expDate) {
		VCodeInfo vcodeInfo = VCODE.get(id);
		if (vcodeInfo != null && !vcodeInfo.isExp()) {
			return vcodeInfo.getVcode();
		}
		VCODE.put(id, new VCodeInfo(id, vCode, expDate));
		return vCode;
	}

	public static boolean verifyVCode(String id, String vcode) {
		if (!VCODE.containsKey(id)) {
			return false;
		}
		VCodeInfo vcodeInfo = VCODE.get(id);
		return !vcodeInfo.isExp();
	}

	/**
	 * clear:(清理缓存)
	 *
	 * @author whater
	 * @since JDK 1.8
	 */
	private static void clear() {
		Iterator<Map.Entry<String, VCodeInfo>> iterator = VCODE.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, VCodeInfo> next = iterator.next();
			if (next.getValue().isExp()){
				iterator.remove();
			}
		}
	}

	static class VCodeInfo {
		/**
		 * ID
		 */
		private String id;
		/**
		 * 验证码
		 */
		private String vcode;
		/**
		 * 超时时间
		 */
		private Date expDate;

		VCodeInfo(String id, String vcode, Date expDate) {
			super();
			this.id = id;
			this.vcode = vcode;
			this.expDate = expDate;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		String getVcode() {
			return vcode;
		}

		public void setVcode(String vcode) {
			this.vcode = vcode;
		}

		public Date getExpDate() {
			return expDate;
		}

		public void setExpDate(Date expDate) {
			this.expDate = expDate;
		}

		/**
		 * isExp:(是否过期，true:过期，false:未过期). <br/>
		 *
		 * @return boolean
		 */
		boolean isExp() {
			return CommonUtil.getCurrentTime().getTime() > expDate.getTime();
		}
	}
}
