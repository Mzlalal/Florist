package net.dyy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截所有的jsp页面,禁止使用静态资源访问
 * @author dyy
 */
@WebFilter(filterName = "/JspFilter" , urlPatterns="/*" )
public class JspFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		// 获取请求路径
		String path = servletRequest.getServletPath();
		System.out.println(path);

		String url_1 = "/pages/util/rand.jsp";

		//如果请求包含 .jsp 则返回首页
		if (path.indexOf(".jsp") != -1 && !url_1.equals(path)) {
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			String context = servletRequest.getContextPath();
			servletResponse.sendRedirect(context+"/index");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}



}
