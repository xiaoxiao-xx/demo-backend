package com.rainyhon.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//import org.springframework.web.servlet.resource.WebJarsResourceResolver;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	public static final String SUFFIX = "file:";

	@Value("${sls.FILE_PATH}")
	private String filePath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 访问myres根目录下的fengjing.jpg 的URL为 http://localhost:8080/fengjing.jpg （/** 会覆盖系统默认的配置）
		// registry.addResourceHandler("/**").addResourceLocations("classpath:/myres/").addResourceLocations("classpath:/static/")
		// 可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:
		// registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
		// registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
//		registry.addResourceHandler("/static/**").addResourceLocations(SUFFIX + filePath);

		// TODO webjars
//		registry.addResourceHandler("/webjars/**")
//		.addResourceLocations("classpath:/META-INF/resources/webjars/");

//		registry.addResourceHandler("/webjars/**")
//				.addResourceLocations("/webjars/")
//				.resourceChain(false)
//				.addResolver(new WebJarsResourceResolver())
//				.addResolver(new PathResourceResolver());
//		.addResolver(new WebJarsResourceResolver());


		registry.addResourceHandler("/swagger*.html").addResourceLocations("/");
		registry.addResourceHandler("/static/**").addResourceLocations(SUFFIX + filePath + "/");
		super.addResourceHandlers(registry);
	}

}
