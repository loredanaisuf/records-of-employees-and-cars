//package ro.siit.servlet;
//
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/utilizatori", "/masini", "/remorci", "/calendar", "/pontaj", "/locatii", "/grafic", "/informatii", "/profil", "/istoric"})
//public class LoginFilter implements Filter {
//
//    public void init(FilterConfig arg0) throws ServletException {}
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        System.out.println("from filter");
//        Object authenticatedUser = httpServletRequest.getSession().getAttribute("authenticatedUser");
//        Object authenticatedAdmin = httpServletRequest.getSession().getAttribute("authenticatedAdmin");
//
//        if(authenticatedUser != null || authenticatedAdmin != null)  {
//            System.out.println("before filter");
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
//        }
//    }
//
//
//}

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
    ServiceAutentificare serviceAutentificare;
    ServiceUtilizator serviceUtilizator;
    ServiceAdministrator serviceAdministrator;

    public void init(FilterConfig arg0) throws ServletException {
        serviceAutentificare = new ServiceAutentificare();
        serviceUtilizator = new ServiceUtilizator();
        serviceAdministrator = new ServiceAdministrator();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("from filter");

        Object authenticatedUser = httpServletRequest.getSession().getAttribute("authenticatedUser");
        Object authenticatedAdmin = httpServletRequest.getSession().getAttribute("authenticatedAdmin");

        Cookie[] cookies = httpServletRequest.getCookies();



        if(authenticatedUser != null || authenticatedAdmin != null)  {
            System.out.println("before filter");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            if(authenticatedUser == null){
                System.out.println("user case, before redirect to login");

                String selector = "";
                String validator = "";

                if(cookies.length != 0){
                    for (Cookie aCookie : cookies) {
                        if (aCookie.getName().equals("selector")) {
                            selector = aCookie.getValue();
                        } else if (aCookie.getName().equals("validator")) {
                            validator = aCookie.getValue();
                        }
                    }
                }

                if (!"".equals(selector) && !"".equals(validator)) {
                    TabelAutentificare tabelAutentificare = serviceAutentificare.getUser(selector,validator);
                    System.out.println("din tabelul de autentificare: " + tabelAutentificare);
                    if(tabelAutentificare != null){
                        // update new token in database
                        String newSelector = UUID.randomUUID().toString();
                        String newValidator = UUID.randomUUID().toString();

                        serviceAutentificare.updateUser(newSelector, newValidator, tabelAutentificare.getUserId());
                        // update cookie
                        Cookie cookieSelector = new Cookie("selector", newSelector);
                        cookieSelector.setMaxAge(604800);

                        Cookie cookieValidator = new Cookie("validator", newValidator);
                        cookieValidator.setMaxAge(604800);

                        httpServletResponse.addCookie(cookieSelector);
                        httpServletResponse.addCookie(cookieValidator);


                        Utilizator utilizator = serviceUtilizator.getUser(UUID.fromString(tabelAutentificare.getUserId()));
                        httpServletRequest.getSession().setAttribute("authenticatedUser", utilizator);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }

                }
            }

            if(authenticatedAdmin == null){
                System.out.println("admin case, before redirect to login");

                String selector = "";
                String validator = "";

                if(cookies.length != 0){
                    for (Cookie aCookie : cookies) {
                        if (aCookie.getName().equals("selector")) {
                            selector = aCookie.getValue();
                        } else if (aCookie.getName().equals("validator")) {
                            validator = aCookie.getValue();
                        }
                    }
                }

                System.out.println("selector: " + selector);
                if (!"".equals(selector) && !"".equals(validator)) {
                    TabelAutentificare tabelAutentificare = serviceAutentificare.getAdmin(selector, validator);
                    System.out.println("din tabelul de autentificare: " + tabelAutentificare);
                    if (tabelAutentificare != null) {
                        // update new token in database
                        String newSelector = UUID.randomUUID().toString();
                        String newValidator = UUID.randomUUID().toString();

                        serviceAutentificare.updateAdmin(newSelector, newValidator, tabelAutentificare.getUserId());
                        // update cookie
                        Cookie cookieSelector = new Cookie("selector", newSelector);
                        cookieSelector.setMaxAge(604800);

                        Cookie cookieValidator = new Cookie("validator", newValidator);
                        cookieValidator.setMaxAge(604800);

                        httpServletResponse.addCookie(cookieSelector);
                        httpServletResponse.addCookie(cookieValidator);


                        System.out.println("Before call getAdmin with id: " + tabelAutentificare.getUserId());
                        Administrator administrator = serviceAdministrator.getAdmin(tabelAutentificare.getUserId());
                        httpServletRequest.getSession().setAttribute("authenticatedAdmin", administrator);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                    else{
                        ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
                    }
                }else {
                        ((HttpServletResponse) servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/login");
                }

            }


        }
    }


}