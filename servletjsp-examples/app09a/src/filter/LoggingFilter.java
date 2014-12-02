package filter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "LoggingFilter", urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = "logFileName", value = "log.txt"),
                @WebInitParam(name = "uriPrefix", value = "URI: "),
                @WebInitParam(name = "urlPrefix", value = "URL: ")})
public class LoggingFilter implements Filter {

    private PrintWriter logger;
    private String uriPrefix;
    private String urlPrefix;

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
        uriPrefix = filterConfig.getInitParameter("uriPrefix");
        urlPrefix = filterConfig.getInitParameter("urlPrefix");
        String logFileName = filterConfig.getInitParameter("logFileName");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        // without path info in logFileName, the log file will be
        // created in $TOMCAT_HOME/bin

        System.out.println("logFileName:" + logFileName);
        try {
        	File logFile = new File(appPath, logFileName);
            logger = new PrintWriter(logFile);
            System.out.println(logFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroying filter");
        if (logger != null) {
            logger.close();
        }
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("LoggingFilter.doFilter");
        HttpServletRequest httpServletRequest =  (HttpServletRequest) request;
        logger.println(LocalDateTime.now() + " " + uriPrefix + httpServletRequest.getRequestURI());
        logger.println(LocalDateTime.now() + " " + urlPrefix + httpServletRequest.getRequestURL());
        logger.flush();
        filterChain.doFilter(request, response);
    }
}