package com.rainyhon.common.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {

	/**
	 * 获取两个时间的时间间隔，单位为分钟
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static long getMinuteDuration(Date before, Date after) {
		if (before.after(after)) {
			return 0;
		}
		return (after.getTime() - before.getTime()) / (1000 * 60);
	}

	public static Date nextMonthDate(Date now, int month) {
		Calendar rightNow = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间。
		rightNow.setTime(now);
		// 日期加月
		rightNow.add(Calendar.MONTH, month);
		return rightNow.getTime();
	}

	/**
	 * 获取最近十二个月字符串
	 *
	 * @return 形如 "2018-06" 的字符串
	 */
	public static List<String> getLatest12Months() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal1.clone();

		List<String> list = new ArrayList<>();
		for (cal2.add(Calendar.MONTH, -11); cal2.compareTo(cal1) <= 0; cal2.add(Calendar.MONTH, 1)) {
			int month = cal2.get(Calendar.MONTH) + 1;
			list.add(cal2.get(Calendar.YEAR) + "-" + ((month < 10) ? "0" : "") + month);
		}

		return list;
	}

//	public static void main(String[] args) throws ParseException {
//		Date date1 = new SimpleDateFormat("yyyyMMdd HHmmss").parse("20180612 124503");
//		String date2 = new SimpleDateFormat("yyyyMMdd HHmmss").format(nextMonthDate(date1, 13));
//		System.out.println(date2);
//	}

	/**
	 * 将秒数转换为时间格式
	 *
	 * @param ttl 秒
	 * @return
	 */
	public static String ttl(long ttl) {
		long time = ttl / 60;
		long hour = time / 60;
		long min = time - hour * 60;
		long sec = (ttl - min * 60);
		return hour + "小时" + min + "分钟" + sec + "秒";
	}

}
