package ro.siit.servlet;

import ro.siit.model.Administrator;
import ro.siit.model.Coordonate;
import ro.siit.model.Masina;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceCoordonate;
import ro.siit.service.ServiceMasina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/locatii")
public class HartaServlet extends HttpServlet {
    private ServiceCoordonate serviceCoordonate;
    private ServiceMasina serviceMasina;

    @Override
    public void init() throws ServletException {
        this.serviceCoordonate = new ServiceCoordonate();
        this.serviceMasina = new ServiceMasina();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

        String numeFirma = (authenticatedAdmin == null) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

        List<Coordonate> coordonateList = serviceCoordonate.getAllCoordinates(numeFirma);
        System.out.println("doGet Lista de coordonate: " + coordonateList);
        req.setAttribute("list", coordonateList);

        List<Masina> carsList = serviceMasina.getCars(numeFirma);
        req.setAttribute("carsList",carsList);

        req.getRequestDispatcher("/jsps/lists/harta.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("from do post HartaServlet");
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

        String numeFirma = (authenticatedAdmin == null) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();
        List<Coordonate> coordonateList = new ArrayList<>();
        List<Masina> masinaList = serviceMasina.getCars(numeFirma);

        for(Masina m:masinaList){
            boolean checkCar = "true".equals(req.getParameter(m.getNrInmatriculare()));
            System.out.println("masina: " + m.getNrInmatriculare() + "valoarea: " + checkCar);
            if(checkCar){
//                List<Coordonate> coordonateListOneCar = serviceCoordonate.getCoordinatesByCar(m.getNrInmatriculare());
//                for(Coordonate coordonate:coordonateListOneCar){
//                    coordonateList.add(coordonate);
//                }
                coordonateList.add(serviceCoordonate.getLatestCoordinetesForCar(m.getNrInmatriculare()));
            }
        }

        System.out.println("doPost Lista de coordonate: " + coordonateList);

        List<Masina> carsList = serviceMasina.getCars(numeFirma);
        req.setAttribute("carsList",carsList);
        req.setAttribute("list", coordonateList);
        req.getRequestDispatcher("/jsps/lists/harta.jsp").forward(req,resp);


    }
}
