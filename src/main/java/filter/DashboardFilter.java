package filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Prajwal on 12/3/2016.
 */
public class DashboardFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp1=(HttpServletResponse) resp;
        HttpServletRequest req1=(HttpServletRequest) req;
        System.out.println("ksbdflkjsbvvgklbsklbf");
        if(req1.getSession().getAttribute("users")!=null)
            chain.doFilter(req, resp);
        else
            resp1.sendRedirect("index.html");


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
