package com.microcore.center.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义响应结构
 */
public class ResultVo<T> implements Serializable {

	/**
	 * 定义jackson对象
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 响应业务状态
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 页码
	 */
	private long index;

	/**
	 * 总记录数
	 */
	private long count;

	/**
	 * 响应中的数据
	 */
	private T data;

	public ResultVo() {
	}

	public ResultVo(Integer status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public ResultVo(T data) {
		this(200, "OK", data);
	}

	public static <T> ResultVo<T> build(Integer status, String msg) {
		return new ResultVo<>(status, msg, null);
	}

	public static <T> ResultVo<T> build(Integer status, String msg, T data) {
		return new ResultVo<>(status, msg, data);
	}

	public static <T> ResultVo<T> ok(T data) {
		ResultVo<T> vo = new ResultVo<>(data);
		vo.setCount(1);
		vo.setIndex(1);
		return vo;
	}

	public static <T> ResultVo<T> ok() {
		return new ResultVo<>(null);
	}

	/*
	 * public static ResultVo pageSuccess(Page datas) {
	 *     ResultVo resultVo = new ResultVo();
	 *     resultVo.setStatus(200);
	 *     resultVo.setMsg("OK");
	 *     resultVo.setIndex(datas.getNumber() + 1);
	 *     resultVo.setCount(datas.getNumberOfElements());
	 *     resultVo.setData(datas.getContent());
	 *     return resultVo;
	 * }
	 */

	public ResultVo<T> success() {
		this.status = 200;
		this.msg = "OK";
		return this;
	}

	public ResultVo<T> success(T data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
		return this;
	}

	public ResultVo<T> failure() {
		this.status = 500;
		this.msg = "failed";
		return this;
	}

	public ResultVo<T> failure(String message) {
		this.status = 500;
		this.msg = message;
		return this;
	}

	/**
	 * 错误返回
	 *
	 * @return
	 */
	public static <T> ResultVo<T> fail() {
		return build(500, "failed");
	}

	public static <T> ResultVo<T> fail(String msg) {
		return build(500, msg);
	}

	public static <T> ResultVo<T> fail2(String msg) {
		return build(500, msg);
	}

	public static <T> ResultVo<T> sessionOut() {
		return build(250, "session  out");
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为ResultVo对象
	 *
	 * @param jsonData json数据
	 * @param clazz    ResultVo中的object类型
	 * @return
	 */
	public static ResultVo formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, ResultVo.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 *
	 * @param json
	 * @return
	 */
	public static ResultVo format(String json) {
		try {
			return MAPPER.readValue(json, ResultVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 *
	 * @param jsonData json数据
	 * @param clazz    集合中的类型
	 * @return
	 */
	public static ResultVo formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public ResultVo findAll(Integer pageNum, Integer pageSize, String searchName) {
		return null;
	}

	@Override
	public String toString() {
		return "ResultVo{" +
				"status=" + status +
				", msg='" + msg + '\'' +
				", index=" + index +
				", count=" + count +
				", data=" + data +
				'}';
	}
}
