package com.tangcco.cobaya.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro 配置类
 * 
 * @author JiFeng
 *
 *         2018年1月15日
 */
@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		System.err.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 非验证可以进入
		// filterChainDefinitionMap.put("/jsp/**", "anon");

		// 需要验证
		// filterChainDefinitionMap.put("/message/addMsg", "authc");

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/article/index");
		// 配置权限不够的页面
		// shiroFilterFactoryBean.setUnauthorizedUrl("/jsp/unauthorized.html");
		// 404页面
		// filterChainDefinitionMap.put("/", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public MyRealm myRealm() {
		MyRealm myRealm = new MyRealm();
		return myRealm;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myRealm());
		// securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	@Bean
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean
	public SimpleCookie rememberMeCookie() {
		// 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// <!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}

	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
		return cookieRememberMeManager;
	}

	/**
	 * 密码匹配凭证管理器
	 *
	 * @return
	 */
	@Bean(name = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// 采用MD5方式加密
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		// 设置加密次数
		hashedCredentialsMatcher.setHashIterations(1024);
		return hashedCredentialsMatcher;
	}
}
