package com.demo.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {DataConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
