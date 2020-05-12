package ro.siit.servlet;

import ro.siit.model.Masina;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceMasina;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/masini"})
public class MasinaServlet extends HttpServlet {
    private ServiceMasina serviceMasina;
    private ServiceUtilizator serviceUtilizator;

    @Override
    public void init() throws ServletException {
        this.serviceMasina = new ServiceMasina();
        this.serviceUtilizator = new ServiceUtilizator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        System.out.println("email user: " + authenticatedUser);
        if(authenticatedUser.getEmail().equals("admin")){
            System.out.println("block");
            req.setAttribute("displayAdmin","block");
            System.out.println("param: " + req.getAttribute("displayAdmin"));
        }else{
            System.out.println("none");
            req.setAttribute("displayAdmin","none");
            System.out.println("param: " + req.getAttribute("displayAdmin"));
        }

        String action = req.getParameter("action");
        action = (null == action) ? "masini" : action;

        switch (action) {
            case ("addMasina"):
                req.getRequestDispatcher("/jsps/forms/formMasina.jsp").forward(req, resp);
                action = "null";
                break;

            case ("editMasina"):
                String nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                Masina masina = serviceMasina.getCar(nrInmatriculare);
                req.setAttribute("CarToEdit", masina);
                req.getRequestDispatcher("/jsps/forms/formMasina.jsp").forward(req, resp);
                break;

            case ("deleteMasina"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                serviceMasina.deleteCar(nrInmatriculare);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");
                break;

            default:
                List<Masina> masini = this.serviceMasina.getCars();
                req.setAttribute("CarsTobeDisplayed", masini);
                req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
                break;
//            case ("masini"):
//                List<Masina> masini = this.serviceMasina.getCars();
//                req.setAttribute("CarsTobeDisplayed", masini);
//                req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
//                break;
//
//            default:
//                List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
//                req.setAttribute("UsersTobeDisplayed", utilizatori);
//                req.getRequestDispatcher("/jsps/lists/listaUtilizatori.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "list" : action;
        switch (action){
            case("addMasina"):
                String nrInmatriculare = req.getParameter("nrInmatriculareMasina");
                String marca = req.getParameter("marcaMasina");
                System.out.println("marca : " + marca);
                System.out.println("string an : " + req.getParameter("anMasina"));
                Integer anulFabricatiei = Integer.valueOf(req.getParameter("anMasina"));
                System.out.println("int an : " + anulFabricatiei);
                String itp = req.getParameter("itpMasina");
                System.out.println("itp : " + itp);
                String rca = req.getParameter("rcaMasina");
                String casco = req.getParameter("cascoMasina");
                String rovignieta = req.getParameter("rovignietaMasina");
                serviceMasina.addCar(new Masina(nrInmatriculare, marca, anulFabricatiei, itp, rca, casco, rovignieta));

//                List<Masina> masini = this.serviceMasina.getCars();
//                req.setAttribute("CarsTobeDisplayed", masini);
//                req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
                break;

            case("editMasina"):
                nrInmatriculare = req.getParameter("id");
                marca = req.getParameter("marcaMasina");
                System.out.println("marca : " + marca);
                anulFabricatiei = Integer.valueOf(req.getParameter("anMasina"));
                itp = req.getParameter("itpMasina");
                System.out.println("marca : " + itp);
                rca = req.getParameter("rcaMasina");
                casco = req.getParameter("cascoMasina");
                rovignieta = req.getParameter("rovignietaMasina");
                serviceMasina.updateCar(new Masina(nrInmatriculare, marca, anulFabricatiei, itp, rca, casco, rovignieta));

//                masini = this.serviceMasina.getCars();
//                req.setAttribute("CarsTobeDisplayed", masini);
//  //              resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");
//               req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
                break;
        }
//        List<Masina> masini = this.serviceMasina.getCars();
//        req.setAttribute("CarsTobeDisplayed", masini);
//        req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");

    }
}
