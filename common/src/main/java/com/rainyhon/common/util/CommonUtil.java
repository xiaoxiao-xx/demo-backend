package com.rainyhon.common.util;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.stream.FileImageInputStream;
import javax.validation.constraints.NotNull;

/**
 * @author lmh
 */
@Slf4j
public class CommonUtil {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static {
		ConvertUtils.register(new DateConverter(null), Date.class);
	}

	/**
	 * 获取Bean
	 *
	 * @param clazz Class
	 * @return bean object
	 */
	public static <T> T getBean(Class<T> clazz) {
		return ApplicationContextProvider.getBean(clazz);
	}

	/**
	 * 获取UUID
	 *
	 * @return UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean isHave(String column, String columns, String table) {
		if (column.contains(".")) {
			String[] strs = column.split("\\.");
			return table.equals(strs[0]) && (columns + ",").contains(strs[1] + ",");
		} else {
			return (columns + ",").contains(column + ",");
		}
	}

	/**
	 * 将List
	 * <p>
	 * 转成 List<V>
	 *
	 * @param list List
	 *             <p>
	 * @param v    Class<V>
	 * @return List<V>
	 */
	public static <P, V> List<V> listPo2VO(List<P> list, Class<V> v) {
		if (isEmpty(list)) {
			return new ArrayList<>();
		}
		List<V> listVo = new ArrayList<>();
		for (P p : list) {
			listVo.add(po2VO(p, v));
		}
		return listVo;
	}

	/**
	 * 将P对象转成V对象
	 *
	 * @param p P对象
	 * @param v V对象
	 * @return V对象
	 */
	public static <V, P> V po2VO(P p, Class<V> v) {
		if (p == null) {
			try {
				return v.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		V tObject = null;
		try {
			tObject = v.newInstance();
			BeanUtils.copyProperties(tObject, p);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			log.error("PO转VO出错!", e);
		}
		return tObject;
	}

	/**
	 * 判断List是否为空
	 *
	 * @param list List
	 * @return 结果
	 */
	public static boolean isEmpty(List<?> list) {
		return list == null || list.size() == 0;
	}

	/**
	 * 判断List是否不为空
	 *
	 * @param list List
	 * @return 结果
	 */
	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}

	/**
	 * 将 List<Map<String, Object>> 转成 List<T>
	 *
	 * @param listRecord List<Map<String, Object>>对象
	 * @param t          Class<T>
	 * @return List<T>
	 */
	public static <T> List<T> map2PO(List<Map<String, Object>> listRecord, Class<T> t, boolean flag) {
		if (isEmpty(listRecord)) {
			return new ArrayList<>();
		}
		List<T> listT = new ArrayList<>();
		for (Map<String, Object> record : listRecord) {
			if (record == null) {
				log.info("map2PO: record is null");
				continue;
			}
			try {
				T newT = t.newInstance();
				for (String column : record.keySet()) {
					try {
						Object value = record.get(column);
						if (value == null) {
							continue;
						}
						if (flag) {
							BeanUtils.setProperty(newT, column2Filed(column), value);
						} else {
							BeanUtils.setProperty(newT, column, value);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				listT.add(newT);

			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return listT;
	}

	/**
	 * 将 List<Map<String, Object>> 转成 List<T>
	 *
	 * @param listRecord List<Map<String, Object>>对象
	 * @param t          Class<T>
	 * @return List<T>
	 */
	public static <T> List<T> map2PO(List<Map<String, Object>> listRecord, Class<T> t) {
		return map2PO(listRecord, t, true);
	}

	/**
	 * 将 Map<String, Object> 对象转成 T 对象 注意： 这个方法会调用
	 * column2Filed()，只适合从数据库中查出的字段名含下划线的数据转成对象
	 *
	 * @param record Map<String, Object>对象
	 * @param t      T对象
	 * @return T对象
	 */
	public static <T> T map2PO(Map<String, Object> record, Class<T> t) {
		if (record == null) {
			return null;
		}
		try {
			T newT = t.newInstance();
			for (String column : record.keySet()) {
				try {
					BeanUtils.setProperty(newT, column2Filed(column), record.get(column));
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			return newT;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T map2POx(Map<String, Object> record, Class<T> t) {
		ConvertUtils.register(new DateConverter(null), Date.class);

		if (record == null) {
			return null;
		}
		try {
			T newT = t.newInstance();
			for (String column : record.keySet()) {
				try {
					// 可能出现 org.apache.commons.beanutils.ConversionException: No value specified for
					// 'Date' 的问题
//					if (record.get(column) == null) {
//						continue;
//					}

					BeanUtils.setProperty(newT, column, record.get(column));
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			return newT;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将下划线分隔的单词转为小驼峰风格
	 *
	 * @param column 下划线分隔的单词
	 * @return 小驼峰风格
	 */
	private static String column2Filed(String column) {
		String[] names = column.toLowerCase().split("_");
		StringBuilder filed = new StringBuilder();
		filed.append(names[0]);
		for (int i = 1; i < names.length; i++) {
			filed.append(names[i].substring(0, 1).toUpperCase()).append(names[i].substring(1));
		}
		return filed.toString();
	}

	/**
	 * 拼接分页查询语句
	 *
	 * @param pageIndex 页码
	 * @param pageSize  每页大小
	 * @return SQL语句
	 */
	public static String getPageSQL(Integer pageIndex, Integer pageSize) {
		if (pageIndex == null || pageIndex < 0 || pageSize == null || pageSize < 1) {
			return "";
		}
		return " limit " + pageIndex + "," + pageSize;
	}

	/**
	 * 将 List<T> 转成 Set<T>
	 *
	 * @param list List<T>
	 * @return Set<T>
	 */
	public static <T> Set<T> list2Set(List<T> list) {
		return new HashSet<>(list);
	}

	/**
	 * 获取当前时间的 yyyy-MM-dd HH:mm:ss 形式的字符串
	 *
	 * @return 时间字符串
	 */
	public static synchronized String getSystemDateStr() {
		return FORMAT.format(new Date());
	}

//	/**
//	 * 获取当前时间的 yyyy-MM-dd 形式（仅年月日）的字符串
//	 *
//	 * @return 时间字符串
//	 */
//	public static String getSystemDateStr2() {
//		return new SimpleDateFormat("yyyy-MM-dd").FORMAT(new Date());
//	}

	/**
	 * 将List<String>变成以逗号分隔的字符串，形如 hello,world,again
	 */
	public static String getCommaString(List<String> list) {
		return String.join(",", list);
	}

	/**
	 * 拼接数据库插入语句
	 *
	 * @param tableName 表名
	 * @param keyList   字段列表
	 * @return SQL语句
	 */
	public static String conInsert(String tableName, List<String> keyList) {
		return "insert into " + tableName + "(" + CommonUtil.getCommaString(keyList) + ") values ("
				+ keyList.stream().map(x -> "?").collect(Collectors.joining(",")) + ")";
	}

	/**
	 * 判断original字符串是否和list中的任意一个相等
	 */
	public static boolean orEquals(String original, String... list) {
		return Arrays.stream(list).anyMatch(original::equals);
	}

	/**
	 * 获取当前时间
	 *
	 * @return Date对象
	 */
	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * 获取当前时间
	 *
	 * @return Date对象
	 */
	public static Date getSystemDate() {
		return getCurrentTime();
	}

	/**
	 * 将同类型多个参数转为List
	 *
	 * @param ts  不定参数列表
	 * @param <T> 类型
	 * @return List<T>
	 */
	public static <T> List<T> array2List(T... ts) {
		return new ArrayList<>(Arrays.asList(ts));
	}

	/**
	 * 获取数据字节大小
	 *
	 * @param list Map列表
	 * @return 数据字节大小
	 */
	public static Integer getSizeOfData(List<Map<String, Object>> list) {
		Integer size = 0;
		for (Map<String, Object> map : list) {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Object obj = map.get(key);
				if (obj instanceof Date) {
					size += "yyyy-MM-dd HH:mm:ss".getBytes().length;
				} else if (obj != null) {
					size += obj.toString().getBytes().length;
				}
			}
		}
		return size;
	}

	public static String formatNumber(Integer seq) {
		DecimalFormat format = new DecimalFormat("########");
		return format.format(seq + 10000000);
	}

	public static String removeOrgList(String authScope, List<String> removeList) {
		List<String> scopeList = new ArrayList<>(Arrays.asList(authScope.split(",")));
		for (String s : removeList) {
			scopeList.removeIf(x -> x.equals(s));
		}
		return scopeList.stream().collect(Collectors.joining(","));
	}

	public static boolean checkPageIsNull(Integer pageIndex, Integer pageSize) {
		return pageIndex == null || pageSize == null;
	}

//	public static String random(String... type) {
//		return type[(int) (Math.random() * type.length)];
//	}

	public static <T> T random(T... type) {
		return type[(int) (Math.random() * type.length)];
	}

	/**
	 * 图片转byte数组
	 */
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

	public static String byte2Base64Str(byte[] b) {
		return Base64.encodeBase64String(b);
	}

	public static void saveFile(String path, byte[] buffer) {
		saveFile(path, buffer, buffer.length);
	}

	public static void saveFile(String path, byte[] buffer, int length) {
		try {
			OutputStream os = new FileOutputStream(path);
			os.write(buffer, 0, length);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前用户的机构ID
	 *
	 * @return 当前用户的机构ID
	 */
	public static String getCurrentOrgId() {
		return UserUtil.getOrgId();
	}

	/**
	 * 获取当前用户ID
	 *
	 * @return 用户ID
	 */
	public static String getCurrentUserId() {
		return UserUtil.getUserId();
	}

	public static boolean exceptionMessageIs(RuntimeException e, @NotNull String message) {
		return message.equals(e.getMessage());
	}

	/**
	 * 计算两个时间点的相差天数
	 * https://blog.csdn.net/u012336619/article/details/60143860
	 */
	public static int getTimeDistance(Date beginDate, Date endDate) {
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(beginDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		long beginTime = beginCalendar.getTime().getTime();
		long endTime = endCalendar.getTime().getTime();
		// 先算出两时间的毫秒数之差大于一天的天数
		int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));

		// 使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
		endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);
		// 再使endCalendar减去1
		endCalendar.add(Calendar.DAY_OF_MONTH, -1);
		// 比较两日期的DAY_OF_MONTH是否相等天
		if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)) {
			// 相等说明确实跨天了
			return betweenDays + 1;
		} else {
			// 不相等说明确实未跨天
			return betweenDays + 0;
		}
	}

	public static Calendar getTomorrowCalendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal;
	}

}
