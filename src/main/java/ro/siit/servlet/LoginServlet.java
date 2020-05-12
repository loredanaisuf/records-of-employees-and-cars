package ro.siit.servlet;


import ro.siit.model.Utilizator;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private ServiceUtilizator userService;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new ServiceUtilizator();
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
        System.out.println("email: " + username + "parola: " + pwd);

        Utilizator authenticatedUser = userService.checkCredentials(username, pwd);
        if(authenticatedUser != null){
            req.getSession().setAttribute("authenticatedUser", authenticatedUser);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");
        } else {
            req.setAttribute("error", "Combinatia email/parola este incorecta!");
            //req.setAttribute("display", "block");
            req.getRequestDispatcher("/jsps/forms/formLogare.jsp").forward(req, resp);
        }

    }
}
