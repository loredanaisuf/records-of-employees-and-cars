package ro.siit.servlet;


import ro.siit.model.Administrator;
import ro.siit.model.TabelAutentificare;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceAdministrator;
import ro.siit.service.ServiceAutentificare;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter(urlPatterns = {"/utilizatori", "/masini", "/remorci", "/calendar", "/pontaj", "/locatii", "/grafic", "/informatii", "/profil"})
public class LoginFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("from filter");
        Object authenticatedUser = httpServletRequest.getSession().getAttribute("authenticatedUser");
        Object authenticatedAdmin = httpServletRequest.getSession().getAttribute("authenticatedAdmin");
//        Cookie[] cookies = httpServletRequest.getCookies();
//        ServiceAutentificare serviceAutentificare = new ServiceAutentificare();
//        ServiceUtilizator serviceUtilizator = new ServiceUtilizator();
//        ServiceAdministrator serviceAdministrator = new ServiceAdministrator();

        if(authenticatedUser != null || authenticatedAdmin != null)  {
            System.out.println("before filter");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
        }
    }


}
