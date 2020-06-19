//
//package ro.siit.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = {"/logout"})
//public class LogoutServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().removeAttribute("authenticatedUser");
//        req.getSession().removeAttribute("authenticatedAdmin");
//        resp.sendRedirect(req.getContextPath() + "/login");
//    }
//}

package ro.siit.servlet;

import ro.siit.service.ServiceAutentificare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        Object authenticatedUser = httpServletRequest.getSession().getAttribute("authenticatedUser");
        Object authenticatedAdmin = httpServletRequest.getSession().getAttribute("authenticatedAdmin");

        ServiceAutentificare serviceAutentificare = new ServiceAutentificare();
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            String selector = "";

            for (Cookie aCookie : cookies) {
                if (aCookie.getName().equals("selector")) {
                    selector = aCookie.getValue();
                }
            }

            if (!selector.isEmpty() & authenticatedAdmin != null) {
                // delete token from database
                serviceAutentificare.deleteAdmin(selector);

                Cookie cookieSelector = new Cookie("selector", "");
                cookieSelector.setMaxAge(0);

                Cookie cookieValidator = new Cookie("validator", "");
                cookieValidator.setMaxAge(0);
                resp.addCookie(cookieSelector);
                resp.addCookie(cookieValidator);
            }

            if (!selector.isEmpty() & authenticatedUser != null) {
                // delete token from database
                serviceAutentificare.deleteUser(selector);

                Cookie cookieSelector = new Cookie("selector", "");
                cookieSelector.setMaxAge(0);

                Cookie cookieValidator = new Cookie("validator", "");
                cookieValidator.setMaxAge(0);
                resp.addCookie(cookieSelector);
                resp.addCookie(cookieValidator);
            }
        }


        req.getSession().removeAttribute("authenticatedUser");
        req.getSession().removeAttribute("authenticatedAdmin");
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}