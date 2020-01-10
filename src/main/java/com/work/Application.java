package com.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 项目启动类
 * @author
 * @SpringBootApplication springboot应用注解
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    
    
    // 第二步override configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    
   /* @Bean
	public AuthorizeFilter authorizeFilter(){
		return new AuthorizeFilter();
    }*/
  /*  
    @Bean
   	public ResponseFilter responseFilter(){
   		return new ResponseFilter();
       }*/
    
  
}

