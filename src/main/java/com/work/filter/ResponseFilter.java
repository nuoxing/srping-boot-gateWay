package com.work.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ResponseFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String uri = request.getRequestURI();
		// TODO Auto-generated method stub

		if (uri.contains("WXYYNEW/html") || uri.contains("WXYY_SJ/html")) {// 网上预约静态文件
			context.addZuulResponseHeader("Content-Location", "");
		}
		return null;
	}


	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String uri = request.getRequestURI();
		if (uri.contains("WXYYNEW") || uri.contains("WXYY_SJ")) {// 网上预约
			return true;
		}
		return false;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 999;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

}
