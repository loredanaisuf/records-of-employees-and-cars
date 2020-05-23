package ro.siit.servlet;

import ro.siit.model.Administrator;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceAdministrator;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = {"/inregistrareCompanie"})
public class AdminServlet extends HttpServlet {
    ServiceAdministrator serviceAdministrator;
    @Override
    public void init() throws ServletException {
        this.serviceAdministrator = new ServiceAdministrator();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("From servlet do get!");
        req.setAttribute("displayLogin", "none");
        String action = req.getParameter("action");
        action = (null == action) ? "utilizatori" : action;

        if(action.equals("validate-company")){
            String firma = req.getParameter("firma");
            System.out.println("firma: " + firma);
            boolean exists = serviceAdministrator.companyExists(firma);
            resp.setContentType("application/json");
            resp.getWriter().println("{\"exists\": \"" + exists + "\"}");
        }else{
            req.setAttribute("displayError", "none");
            req.setAttribute("displaySuccess", "none");
            req.getRequestDispatcher("/jsps/forms/formInregistrareCompanie.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("From servlet do get!");
        String numeFirma = req.getParameter("firma");
        String nume = req.getParameter("numeAdmin");
        String prenume = req.getParameter("prenumeAdmin");
        String telefon = req.getParameter("telefonAdmin");
        String cod = req.getParameter("cod");
        String email = req.getParameter("emailAdmin");
        String parola = req.getParameter("parolaAdmin");

        System.out.println("Dates before to be added in DB");
        System.out.println(new Administrator(numeFirma,email,parola,nume,prenume,telefon,cod));



        boolean usernameExists = serviceAdministrator.companyExists(numeFirma);
        System.out.println(usernameExists);
        if(!usernameExists){
            serviceAdministrator.addAdmin(new Administrator(numeFirma,email,parola,nume,prenume,telefon,cod));
            req.setAttribute("displaySuccess", "block");
            req.setAttribute("displayLogin", "block");
            req.setAttribute("displayError", "none");
            req.setAttribute("success", "Compania a fost inregistrata cu succes!");
        } else {
            req.setAttribute("displayError", "block");
            req.setAttribute("displaySuccess", "none");
            req.setAttribute("displayLogin", "none");
            req.setAttribute("error", "Aceasta firma este inregistrata deja!");
        }

        req.getRequestDispatcher("/jsps/forms/formInregistrareCompanie.jsp").forward(req, resp);


    }
}
