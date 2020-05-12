package ro.siit.servlet;

import ro.siit.model.Utilizator;

import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@WebServlet(urlPatterns = {"/utilizatori"})
public class UtilizatoriServlet extends HttpServlet {
    private ServiceUtilizator serviceUtilizator;


    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("display","none");

        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        System.out.println("email user: " + authenticatedUser);
        if(authenticatedUser.getEmail().equals("admin")){
            req.setAttribute("displayAdmin","block");
        }else{
            req.setAttribute("displayAdmin","none");
        }

        String action = req.getParameter("action");
        action = (null == action) ? "utilizatori" : action;

        switch (action){
            case("add"):
                req.getRequestDispatcher("/jsps/forms/formUtilizator.jsp").forward(req,resp);
                break;

            case("edit"):
                String userId = req.getParameter("id");
                Utilizator utilizator = serviceUtilizator.getUser(UUID.fromString(userId));
                req.setAttribute("UserToEdit", utilizator);
                req.getRequestDispatcher("/jsps/forms/formUtilizator.jsp").forward(req,resp);
                break;

            case("delete"):
                userId = req.getParameter("id");
                serviceUtilizator.deleteUser(UUID.fromString(userId));
                resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");
                break;

            default:
                List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
                req.setAttribute("UsersTobeDisplayed", utilizatori);
                req.getRequestDispatcher("/jsps/lists/listaUtilizatori.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "utilizatori" : action;

        switch (action){
            case("add"):
                String nume = req.getParameter("numeUtilizator");
                String prenume = req.getParameter("prenumeUtilizator");
                String telefon = req.getParameter("telefonUtilizator");
                String idMasina = req.getParameter("idMasinaUtilizator");
                String email = req.getParameter("emailUtilizator");
                String parola = req.getParameter("parolaUtilizator");
                serviceUtilizator.addUser(new Utilizator(UUID.randomUUID(), nume, prenume, telefon, idMasina, email, parola));
                break;

            case("edit"):
                String userId = req.getParameter("id");
                System.out.println("id-ul este: " + userId);
                nume = req.getParameter("numeUtilizator");
                prenume = req.getParameter("prenumeUtilizator");
                telefon = req.getParameter("telefonUtilizator");
                idMasina = req.getParameter("idMasinaUtilizator");
                email = req.getParameter("emailUtilizator");
                parola = req.getParameter("parolaUtilizator");
                Utilizator utilizator = new Utilizator(UUID.fromString(userId),nume, prenume, telefon, idMasina, email, parola);
                System.out.println(utilizator);
                serviceUtilizator.updateUser(utilizator);
                break;
        }

        req.setAttribute("displayAdmin","block");
        resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");

    }
}
