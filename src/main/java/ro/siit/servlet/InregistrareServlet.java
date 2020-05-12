package ro.siit.servlet;

import ro.siit.model.Utilizator;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = {"/inregistrare"})
public class InregistrareServlet extends HttpServlet {
    ServiceUtilizator serviceUtilizator;
    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.getRequestDispatcher("/jsps/forms/formInregistrare.jsp").forward(req,resp);

        req.setAttribute("displayLogin", "none");

        String action = req.getParameter("action");
        action = (null == action) ? "utilizatori" : action;

        if(action.equals("validate-email")){
            String email = req.getParameter("emailUtilizator");
            System.out.println("email utilizator: " + email);
            boolean exists = serviceUtilizator.usernameExists(email);
            resp.setContentType("application/json");
            resp.getWriter().println("{\"exists\": \"" + exists + "\"}");
        }else{
            req.setAttribute("displayError", "none");
            req.setAttribute("displaySuccess", "none");
            req.getRequestDispatcher("/jsps/forms/formInregistrare.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nume = req.getParameter("numeUtilizator");
        String prenume = req.getParameter("prenumeUtilizator");
        String telefon = req.getParameter("telefonUtilizator");
        String idMasina = req.getParameter("idMasinaUtilizator");
        String email = req.getParameter("emailUtilizator");
        String parola = req.getParameter("parolaUtilizator");

        boolean usernameExists = serviceUtilizator.usernameExists(email);
        if(!usernameExists){
            serviceUtilizator.addUser(new Utilizator(UUID.randomUUID(), nume, prenume, telefon, idMasina, email, parola));
            req.setAttribute("displaySuccess", "block");
            req.setAttribute("displayLogin", "block");
            req.setAttribute("displayError", "none");
            req.setAttribute("success", "Utilizatorul a fost inregistrat cu succes!");
        } else {
            req.setAttribute("displayError", "block");
            req.setAttribute("displaySuccess", "none");
            req.setAttribute("displayLogin", "none");
            req.setAttribute("error", "Acest email deja exista!");
        }

        req.getRequestDispatcher("/jsps/forms/formInregistrare.jsp").forward(req, resp);


    }
}
