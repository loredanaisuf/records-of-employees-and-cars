package ro.siit.servlet;


import ro.siit.model.TabelAutentificare;
import ro.siit.service.ServiceAutentificare;

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
        Cookie[] cookies = httpServletRequest.getCookies();
        ServiceAutentificare serviceAutentificare = new ServiceAutentificare();

        if(authenticatedUser != null || authenticatedAdmin != null)  {
            System.out.println("before filter");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if(authenticatedUser == null){
                System.out.println("before redirect to login");

                String selector = "";
                String validator = "";

                for (Cookie aCookie : cookies) {
                    if (aCookie.getName().equals("selector")) {
                        selector = aCookie.getValue();
                    } else if (aCookie.getName().equals("validator")) {
                        validator = aCookie.getValue();
                    }
                }
                if (!"".equals(selector) && !"".equals(validator)) {
                    TabelAutentificare tabelAutentificare = serviceAutentificare.getEntity(selector,validator);
                    if(tabelAutentificare != null){
                        // update new token in database
                        String newSelector = UUID.randomUUID().toString();
                        String newValidator = UUID.randomUUID().toString();

                        serviceAutentificare.updateEntity(newSelector, newValidator, tabelAutentificare.getId());
                        // update cookie
                        Cookie cookieSelector = new Cookie("selector", newSelector);
                        cookieSelector.setMaxAge(604800);

                        Cookie cookieValidator = new Cookie("validator", newValidator);
                        cookieValidator.setMaxAge(604800);

                        httpServletResponse.addCookie(cookieSelector);
                        httpServletResponse.addCookie(cookieValidator);
                    }
                        httpServletRequest.getSession().setAttribute("authenticatedUser", authenticatedUser);
                }

            }

            ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
        }
    }


}
