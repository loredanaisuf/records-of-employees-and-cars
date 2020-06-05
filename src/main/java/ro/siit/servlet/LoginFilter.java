package ro.siit.servlet;


import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/utilizatori", "/masini", "/remorci", "/calendar", "/pontaj", "/locatii", "/grafic", "/informatii", "/profil"})
public class LoginFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("from filter");
        Object authenticatedUser = httpServletRequest.getSession().getAttribute("authenticatedUser");
        Object authenticatedAdmin = httpServletRequest.getSession().getAttribute("authenticatedAdmin");
        if(authenticatedUser != null || authenticatedAdmin != null)  {
            System.out.println("before filter");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("before redirect to login");
            ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
        }
    }


}
