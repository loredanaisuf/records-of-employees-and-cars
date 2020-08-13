package ro.siit.servlet;

import ro.siit.model.Administrator;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceAdministrator;
import ro.siit.service.ServiceEditareProfil;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/profil")
public class ProfileServlet extends HttpServlet {
    private ServiceEditareProfil serviceEditareProfil;
    private ServiceAdministrator serviceAdministrator;
    private ServiceUtilizator serviceUtilizator;

    @Override
    public void init() throws ServletException {
        serviceEditareProfil = new ServiceEditareProfil();
        serviceAdministrator = new ServiceAdministrator();
        serviceUtilizator = new ServiceUtilizator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

        if(authenticatedAdmin != null){
            req.setAttribute("user",serviceAdministrator.getAdmin(authenticatedAdmin.getFirma()));
            req.setAttribute("displayAdmin","block");
        }else{
            req.setAttribute("user",serviceUtilizator.getUser(authenticatedUser.getId()));
            req.setAttribute("displayAdmin","none");
        }

        String action = req.getParameter("action");
        action = (null == action) ? "profil" : action;
        switch (action){
            case("edit"):
                if(authenticatedAdmin != null){
                    req.setAttribute("UserToEditProfile",serviceAdministrator.getAdmin(authenticatedAdmin.getFirma()));
                }else{
                    req.setAttribute("UserToEditProfile",serviceUtilizator.getUser(authenticatedUser.getId()));
                }
                req.getRequestDispatcher("jsps/forms/formEditareProfil.jsp").forward(req,resp);
                break;

            default:
                req.getRequestDispatcher("jsps/lists/utilizator.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "profil" : action;
        switch (action) {
            case ("edit"):
                Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
                Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

                String nume = req.getParameter("nume");
                String prenume = req.getParameter("prenume");
                String email = req.getParameter("email");
                String parola = req.getParameter("parola");
                String telefon = req.getParameter("telefon");


                if(authenticatedAdmin != null){
                    String firma = authenticatedAdmin.getFirma();
                    serviceEditareProfil.updateAdmin(firma, nume, prenume, email, parola, telefon);
                }else{
                    UUID id = authenticatedUser.getId();
                    serviceEditareProfil.updateUser(id, nume, prenume, email, parola, telefon);
                }
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/profil");
    }
}
