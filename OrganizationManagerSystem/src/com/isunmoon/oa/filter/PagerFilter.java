package com.isunmoon.oa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.isunmoon.oa.web.Env;
import com.isunmoon.oa.web.SystemContext;

public class PagerFilter extends HttpServlet implements Filter {
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		SystemContext.setOffset(getOffset(request));
		SystemContext.setPageSize(getPageSize());
		try {  
            arg2.doFilter(arg0, arg1);  
        } finally {  
            SystemContext.removeOffset();  
            SystemContext.removePageSize();  
        }  
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	
	public PagerFilter() {
		super();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	
	
	public int getPageSize() {
		int pageSize = 0;
		try {
			pageSize = Integer.parseInt(Env.getInstance().getProperty("pageModel_pageSize"));
		}catch(NumberFormatException e) {
			pageSize = Integer.MAX_VALUE;
		}
		return pageSize;
	}
	
	public int getOffset(HttpServletRequest req) {
		int offset = 0;
		try {
			String str = req.getParameter("pager.offset");
			System.out.println("---str=" + str);
			if(str == null) {
				offset = 0;
			}else {
				offset = Integer.parseInt(req.getParameter("pager.offset"));
				System.out.println("---offset=" + offset);
			}
		}catch(NumberFormatException e) {}
		System.out.println("---offset=" + offset);
		return offset;
	}

	
	
}
