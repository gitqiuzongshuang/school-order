package com.qiu.filter;

import io.netty.util.internal.StringUtil;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;




/**        
 * Title: 跨域访问处理(跨域资源共享)    
 * Description: 解决前后端分离架构中的跨域问题
 * @author cjj       
 * @created 2017年7月4日 下午5:00:09    
 */
public class CorsFilter implements Filter{


    private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowOrigin = filterConfig.getInitParameter("allowOrigin");
        allowMethods = filterConfig.getInitParameter("allowMethods");
        allowCredentials = filterConfig.getInitParameter("allowCredentials");
        allowHeaders = filterConfig.getInitParameter("allowHeaders");
        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");

    }

    /** 
     * @description 通过CORS技术实现AJAX跨域访问,只要将CORS响应头写入response对象中即可
     * @author rico       
     * @created 2017年7月4日 下午5:02:38      
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException     
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)     
     */  
    @Autowired
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
         HttpServletRequest request = (HttpServletRequest) req;  
         HttpServletResponse response = (HttpServletResponse) res; 

         String currentOrigin = request.getHeader("Origin");
         response.setContentType("textml;charset=UTF-8");
         response.setHeader("Access-Control-Allow-Origin", currentOrigin);  


         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
     	response.setHeader("Access-Control-Max-Age", "0");
     	response.setHeader("Access-Control-Allow-Headers",
     	"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
     	response.setHeader("Access-Control-Allow-Credentials", "true");
     	response.setHeader("XDomainRequestAllowed", "1");


         if (StringUtil.isNullOrEmpty(allowMethods)) {  
             response.setHeader("Access-Control-Allow-Methods", allowMethods);  
         }  
         if (StringUtil.isNullOrEmpty(allowCredentials)) {  
             response.setHeader("Access-Control-Allow-Credentials", allowCredentials);  
         }  
         if (StringUtil.isNullOrEmpty(allowHeaders)) { 
             response.setHeader("Access-Control-Allow-Headers", allowHeaders);  
         }  
         if (StringUtil.isNullOrEmpty(exposeHeaders)) {  
             response.setHeader("Access-Control-Expose-Headers", exposeHeaders);  
         }  
         chain.doFilter(req, res);  

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}

