package br.com.projetoperiodo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ControleAcesso
 */
public class ControleAcesso implements Filter {

	private static String LOGIN_ACTION_URI;
	
    /**
     * Default constructor. 
     */
    public ControleAcesso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		RequestDispatcher rd;
		/*
		if ( httpRequest.getSession(Boolean.FALSE) == null &&
				 !LOGIN_ACTION_URI.equals(httpRequest.getRequestURI())) {
			rd = request.getRequestDispatcher("/login.do");
			rd.forward(request, response);
		} */
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 LOGIN_ACTION_URI = fConfig.getInitParameter("loginActionURI");
	}

}
