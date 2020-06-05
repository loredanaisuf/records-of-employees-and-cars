package ro.siit.servlet;

import ro.siit.model.Administrator;
import ro.siit.model.Coordonate;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceCoordonate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/locatii")
public class HartaServlet extends HttpServlet {
    private ServiceCoordonate serviceCoordonate;

    @Override
    public void init() throws ServletException {
        this.serviceCoordonate = new ServiceCoordonate();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

        String numeFirma = (authenticatedAdmin == null) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

        List<Coordonate> coordonateList = serviceCoordonate.getAllCoordinates(numeFirma);
        req.setAttribute("list",coordonateList);
        req.getRequestDispatcher("/jsps/lists/harta.jsp").forward(req,resp);
    }
}
