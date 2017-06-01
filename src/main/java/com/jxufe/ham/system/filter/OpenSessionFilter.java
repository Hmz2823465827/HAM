package com.jxufe.ham.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.logging.Log;;

public class OpenSessionFilter implements Filter{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Log log = LogFactory.getLog(OpenSessionFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		session = sessionFactory.getCurrentSession();
		log.debug("回话过滤器已开启/t"+session.hashCode());
		transaction = session.beginTransaction();
		chain.doFilter(request, response);
		transaction.commit();
		session.close();
		
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
