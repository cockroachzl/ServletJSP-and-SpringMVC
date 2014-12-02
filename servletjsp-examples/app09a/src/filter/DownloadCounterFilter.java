package filter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "DownloadCounterFilter",
        urlPatterns = { "/*" })
public class DownloadCounterFilter implements Filter {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Properties downloadLog;
    private File logFile;

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
        System.out.println("DownloadCounterFilter");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        logFile = new File(appPath, "downloadLog.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        final String uri = httpServletRequest.getRequestURI();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String property = downloadLog.getProperty(uri);
                if (property == null) {
                    downloadLog.setProperty(uri, "1");
                } else {
                    int count = 0;
                    try {
                        count = Integer.parseInt(property);
                    } catch (NumberFormatException e) {
                        // silent
                    }
                    count++;
                    downloadLog.setProperty(uri, Integer.toString(count));
                }
                try {
                    downloadLog.store(new FileWriter(logFile), "");
                } catch (IOException e) {
                }
            }
        });
        filterChain.doFilter(request, response);
    }
}