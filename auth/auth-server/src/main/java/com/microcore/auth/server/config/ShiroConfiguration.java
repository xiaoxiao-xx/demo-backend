package com.microcore.auth.server.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microcore.auth.server.realm.MyShiroRealm;

@Configuration
public class ShiroConfiguration {

	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
//		filterMap.put("/test", "authc");
		filterMap.put("/test", "anon");
		filterMap.put("/login", "anon");
		filterMap.put("/query", "authc,perms[query]");
		// shiroFilterFactoryBean.setLoginUrl("success");
		// shiroFilterFactoryBean.setUnauthorizedUrl("error");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		
		return shiroFilterFactoryBean;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myShiroRealm") MyShiroRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}

	@Bean(name = "myShiroRealm")
	public MyShiroRealm getRealm() {
		return new MyShiroRealm();
	}

}
