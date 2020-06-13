package ro.siit.servlet;

import ro.siit.model.*;
import ro.siit.service.ServiceCoordonate;
import ro.siit.service.ServiceMasina;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/istoric")
public class IstoricCurseServlet extends HttpServlet {
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
        req.setAttribute("list", coordonateList);

        List<ColoredCar> coloredCars = new ArrayList<>();
        List<Masina> carsList = serviceMasina.getCars(numeFirma);
        for(int i=0; i<carsList.size(); i++){
            coloredCars.add(new ColoredCar(carsList.get(i).getNrInmatriculare(), i, false));
        }
        System.out.println("Nuanta pt fiecare masina: " + coloredCars);
        req.setAttribute("carsList",coloredCars);

        int[] indexOfCars = new int[carsList.size()];
        for(int i=0; i <carsList.size(); i++){
            indexOfCars[i] = 0;
        }

        req.getRequestDispatcher("/jsps/lists/istoricCurse.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");

        String numeFirma = (authenticatedAdmin == null) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

        List<Masina> masinaList = serviceMasina.getCars(numeFirma);

        List<ColoredCar> coloredCars = new ArrayList<>();
        List<Masina> carsList = serviceMasina.getCars(numeFirma);
        for(int i=0; i<carsList.size(); i++){

        }

        String date1 = req.getParameter("fromData");
        String date2 = req.getParameter("toData");
        System.out.println("De la: " + date1 + " pana la: " + date2);
        List<Coordonate> coordinatesList = new ArrayList<>();
        List<Coordonate> allCoordinatesList = new ArrayList<>();
        List<String> vehicleNumbers = new ArrayList<>();

        Map<String, List<Coordonate>> carsAndCoordinateMap = new HashMap<>();
        int i = 0;
        for(Masina m:masinaList){
            boolean checkCar = "true".equals(req.getParameter(m.getNrInmatriculare()));
            System.out.println("masina: " + m.getNrInmatriculare() + "valoarea: " + checkCar);
            if(checkCar){
                coloredCars.add(new ColoredCar(carsList.get(i).getNrInmatriculare(), i, true));
                i++;
                vehicleNumbers.add(m.getNrInmatriculare());
                coordinatesList = serviceCoordonate.getCoordinatesByDate(m.getNrInmatriculare(), date1, date2);
                for(Coordonate c:coordinatesList){
                    allCoordinatesList.add(c);
                }
                allCoordinatesList.add(new Coordonate("","","","0","0"));
//                carsAndCoordinateMap.put(m.getNrInmatriculare(), coordinatesList);
//                System.out.println(carsAndCoordinateMap);
            } else {
                coloredCars.add(new ColoredCar(carsList.get(i).getNrInmatriculare(), i, false));
                i++;
            }
        }



        req.setAttribute("coordinatesListForCars", carsAndCoordinateMap);
        req.setAttribute("allCoordinatesList", allCoordinatesList);
        req.setAttribute("coordinatesList", coordinatesList);
        req.setAttribute("vehicleNumbers", vehicleNumbers);
        System.out.println("lista de coordonate cu nr de inmatriculare: " + coordinatesList);
        System.out.println("lista cu nr de inmatriculare: " + vehicleNumbers);



        System.out.println("Nuanta pt fiecare masina: " + coloredCars);
        req.setAttribute("carsList",coloredCars);

//        List<Coordonate> coordonateList = serviceCoordonate.getAllCoordinates(numeFirma);
//        req.setAttribute("list", coordonateList);
        req.getRequestDispatcher("/jsps/lists/istoricCurse.jsp").forward(req,resp);


    }
}
