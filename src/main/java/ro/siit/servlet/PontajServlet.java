package ro.siit.servlet;

import ro.siit.model.Administrator;
import ro.siit.model.Pontaj;
import ro.siit.model.Utilizator;
import ro.siit.service.ServicePontaj;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/pontaj"})

public class PontajServlet extends HttpServlet {
    private ServiceUtilizator serviceUtilizator;
    private ServicePontaj servicePontaj;


    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
        servicePontaj = new ServicePontaj();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");
        String numeFirma = (null == authenticatedAdmin) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

        Utilizator angajat = (Utilizator) req.getSession().getAttribute("angajat");
        List<Pontaj> listOfDates = servicePontaj.getDates(angajat.getId());
        System.out.println("List of dates: " + listOfDates);
        req.setAttribute("listOfDates", listOfDates);
        req.setAttribute("angajat", angajat);
        int numberOfHours = servicePontaj.getNumberOfHours(angajat.getId());
        System.out.println("Nr de ore pt " + angajat.getPrenume() + " este: " + numberOfHours);
        req.setAttribute("numberOfHours",numberOfHours);
        req.getRequestDispatcher("/jsps/lists/pontaj.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        int nrOre = Integer.parseInt(req.getParameter("nrOre"));

        Utilizator angajat = (Utilizator) req.getSession().getAttribute("angajat");
        String numePrenume = angajat.getNume() + " " + angajat.getPrenume();
        Pontaj pontaj = new Pontaj(angajat.getId(), numePrenume, data, nrOre);
        servicePontaj.addDate(pontaj);
        System.out.println("Dates from form: " + pontaj);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/pontaj");
    }
}
