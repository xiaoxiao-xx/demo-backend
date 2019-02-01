package com.microcore.center.vo;

import java.util.List;

import com.microcore.center.model.DbServiceParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestService {

//	/**
//	 * 目标服务接口IP
//	 */
//	private String targetIp;
//
//	/**
//	 * 目标服务接口端口
//	 */
//	private Integer targetPort;
//
//	/**
//	 * 服务接口名称
//	 */
//	private String interfaceName;

	/**
	 * 接口完整地址
	 */
	private String interfaceUrl;
	
	/**
	 * 接口类型
	 */
	private String interfaceType;
	
	/**
	 * 请求方式
	 */
	private String requestMode;
	
	/**
	 * 请求参数
	 */
	private List<DbServiceParam> params;
	
	/**
     * WSDL方法名
     */
    private String wsdlMethodName;
	
	/**
	 * 代理服务接口IP
	 */
	private String proxyIp;
	
	/**
	 * 代理服务接口端口
	 */
	private Integer proxyPort;
	
	/**
	 * 示例代码
	 */
	private String wordExample;
	
//	public String getTargetIp() {
//		return targetIp;
//	}
//
//	public void setTargetIp(String targetIp) {
//		this.targetIp = targetIp;
//	}
//
//	public Integer getTargetPort() {
//		return targetPort;
//	}
//
//	public void setTargetPort(Integer targetPort) {
//		this.targetPort = targetPort;
//	}
//
//	public String getInterfaceName() {
//		return interfaceName;
//	}
//
//	public void setInterfaceName(String interfaceName) {
//		this.interfaceName = interfaceName;
//	}

}
