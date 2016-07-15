package net.tfedu.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 跨域访问
 * 
 * @author Bruce
 * @date 2015年9月8日 下午4:13:38
 * @version 1.0
 */
@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 在启用cookie的情况下，不允许用*，只能用固定的域名
        // httpResponse.setHeader("Access-Control-Allow-Origin", "http://192.168.1.169:3000");

        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpResponse.setStatus(204);

        // 启用cookie
        // httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, Range, Origin");
//        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");  
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
