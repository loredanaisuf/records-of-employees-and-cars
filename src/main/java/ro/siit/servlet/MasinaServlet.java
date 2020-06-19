package ro.siit.servlet;

import org.apache.poi.ss.usermodel.Workbook;
import ro.siit.model.Administrator;
import ro.siit.model.InformatiiMasina;
import ro.siit.model.Masina;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceInformatii;
import ro.siit.service.ServiceMasina;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/masini"})
public class MasinaServlet extends HttpServlet {
    private ServiceMasina serviceMasina;
    private ServiceUtilizator serviceUtilizator;
    private ServiceInformatii serviceInformatii;

    @Override
    public void init() throws ServletException {
        this.serviceMasina = new ServiceMasina();
        this.serviceUtilizator = new ServiceUtilizator();
        this.serviceInformatii = new ServiceInformatii();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");
        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");
        System.out.println("email user: " + authenticatedUser);
        System.out.println("email admin: " + authenticatedAdmin);
        if(authenticatedAdmin != null){
            req.setAttribute("displayAdmin","block");
        }else{
            req.setAttribute("displayAdmin","none");
        }

        String numeFirma = (null == authenticatedAdmin) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

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

            case ("addInf"):
                req.getRequestDispatcher("/jsps/forms/formInformatiiMasina.jsp").forward(req, resp);
                break;

            case ("deleteMasina"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                serviceMasina.deleteCar(nrInmatriculare);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");
                break;

            case("information"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                req.getSession().setAttribute("numarInmatriculare",nrInmatriculare);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/grafic");
                break;

            case("seeInf"):
                nrInmatriculare = req.getParameter("id");
//                req.getSession().setAttribute("numarInmatriculare",nrInmatriculare);
//                resp.sendRedirect(req.getServletContext().getContextPath() + "/informatii");

                List<InformatiiMasina> informatiiMasinaList = serviceInformatii.getInformation(nrInmatriculare);
                //byte[] bits = serviceMasina.getXLSFile(informatiiMasinaList);
                Workbook workbook = serviceMasina.getXLSFile(informatiiMasinaList);
                resp.setContentType("text/plain");
                resp.setHeader("Content-disposition", "attachment; filename=informatii.xlsx");
                workbook.write(resp.getOutputStream());

                break;

            default:
                List<Masina> masini = this.serviceMasina.getCars(numeFirma);
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

        Administrator authenticatedAdmin = (Administrator) req.getSession().getAttribute("authenticatedAdmin");
        Utilizator authenticatedUser = (Utilizator) req.getSession().getAttribute("authenticatedUser");

        String numeFirma = (null == authenticatedAdmin) ? authenticatedUser.getFirma() : authenticatedAdmin.getFirma();

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
                serviceMasina.addCar(new Masina(nrInmatriculare, numeFirma,marca, anulFabricatiei, itp, rca, casco, rovignieta));

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
                serviceMasina.updateCar(new Masina(nrInmatriculare, numeFirma, marca, anulFabricatiei, itp, rca, casco, rovignieta));

//                masini = this.serviceMasina.getCars();
//                req.setAttribute("CarsTobeDisplayed", masini);
//  //              resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");
//               req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
                break;

            case ("addInf"):
                nrInmatriculare = req.getParameter("id");
                String data = req.getParameter("data");
                Float numar_km = Float.valueOf(req.getParameter("numar_km"));
                Integer cantitate = Integer.valueOf(req.getParameter("cantitate"));
                Float consum = (100*cantitate)/numar_km;
                System.out.println(new InformatiiMasina(UUID.randomUUID(),nrInmatriculare,data,numar_km,cantitate,consum));
                serviceMasina.addInf(new InformatiiMasina(UUID.randomUUID(),nrInmatriculare,data,numar_km,cantitate,consum));
                break;
        }

//        List<Masina> masini = this.serviceMasina.getCars();
//        req.setAttribute("CarsTobeDisplayed", masini);
//        req.getRequestDispatcher("/jsps/lists/listaMasini.jsp").forward(req, resp);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");

    }
}
