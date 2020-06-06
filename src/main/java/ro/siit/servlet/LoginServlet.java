package ro.siit.servlet;


import ro.siit.model.Administrator;
import ro.siit.model.TabelAutentificare;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceAdministrator;
import ro.siit.service.ServiceAutentificare;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private ServiceUtilizator userService;
    private ServiceAdministrator serviceAdministrator;
    private ServiceAutentificare serviceAutentificare;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new ServiceUtilizator();
        serviceAdministrator = new ServiceAdministrator();
        serviceAutentificare = new ServiceAutentificare();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("display", "none");
        req.getRequestDispatcher("/jsps/forms/formLogare.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("numeUtilizator");
        String pwd = req.getParameter("parolaUtilizator");

        Utilizator authenticatedUser  = userService.checkCredentialsUser(username, pwd);
        Administrator authenticatedAdmin = serviceAdministrator.checkCredentialsAdmin(username, pwd);

        if(authenticatedUser != null){
            req.getSession().setAttribute("authenticatedUser", authenticatedUser);

            String selector = UUID.randomUUID().toString();
            String validator = UUID.randomUUID().toString();
            serviceAutentificare.addEntity(new TabelAutentificare(UUID.randomUUID().toString(), selector, validator, authenticatedUser.getId().toString()));

            Cookie cookieSelector = new Cookie("selector", selector);
            cookieSelector.setMaxAge(604800);
            Cookie cookieValidator = new Cookie("validator", validator);
            cookieValidator.setMaxAge(604800);

            resp.addCookie(cookieSelector);
            resp.addCookie(cookieValidator);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");

        } else {
            if(authenticatedAdmin != null){
                req.getSession().setAttribute("authenticatedAdmin", authenticatedAdmin);

                String selector = UUID.randomUUID().toString();
                String validator = UUID.randomUUID().toString();
                serviceAutentificare.addEntity(new TabelAutentificare(UUID.randomUUID().toString(), selector, validator, authenticatedAdmin.getFirma()));


                Cookie cookieSelector = new Cookie("selector", selector);
                cookieSelector.setMaxAge(604800);
                Cookie cookieValidator = new Cookie("validator", validator);
                cookieValidator.setMaxAge(604800);

                resp.addCookie(cookieSelector);
                resp.addCookie(cookieValidator);

                resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");
            } else {
                req.setAttribute("error", "Combinatia email/parola este incorecta!");
                //req.setAttribute("display", "block");
                req.getRequestDispatcher("/jsps/forms/formLogare.jsp").forward(req, resp);
            }
        }


    }
}
