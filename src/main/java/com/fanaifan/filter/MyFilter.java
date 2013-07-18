package com.fanaifan.filter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fanaifan.exception.ErrorBean;


/**
 * Tomcat GET方式表单提交乱码解决。
 * @author BeanSoft
 *
 */
public class MyFilter implements Filter {

	private static Logger log = Logger.getLogger(MyFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
	ErrorBean.requestStr = req.getRequestURL().toString();
	log.info("请求地址:"+req.getRequestURL()+"  涉及到的方法为："+req.getMethod());

	int length = req.getContentLength();
	if (length > 0) {
		BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(req,length);

		InputStream is = bufferedRequest.getInputStream();
		byte[] content = new byte[length];

		int pad = 0;
		while(pad < length){
			pad += is.read(content, pad, length);
		}
		log.info("涉及到的内容为:"+new String(content,"utf-8"));
		request = bufferedRequest;
	}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	log.info("创建filter");
	}



}