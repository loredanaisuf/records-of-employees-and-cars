package ro.siit.servlet;

import ro.siit.model.Remorca;
import ro.siit.model.Utilizator;
import ro.siit.service.ServiceRemorca;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/remorci"})
public class RemorciServlet extends HttpServlet {
    private ServiceUtilizator serviceUtilizator;
    private ServiceRemorca serviceRemorca;

    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
        this.serviceRemorca = new ServiceRemorca();
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
        action = (null == action) ? "remorci" : action;
        switch (action) {
            case ("utilizatori"):
                resp.sendRedirect(req.getServletContext().getContextPath() + "/utilizatori");
                break;

            case ("masini"):
                resp.sendRedirect(req.getServletContext().getContextPath() + "/masini");
                break;

            case ("addRemorca"):
                req.getRequestDispatcher("/jsps/forms/formRemorca.jsp").forward(req, resp);
                action = "null";
                break;

            case ("editRemorca"):
                String nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                Remorca remorca = serviceRemorca.getTrail(nrInmatriculare);
                req.setAttribute("TrailToEdit", remorca);
                req.getRequestDispatcher("/jsps/forms/formRemorca.jsp").forward(req, resp);
                break;

            case ("deleteRemorca"):
                nrInmatriculare = req.getParameter("id");
                System.out.println("Numarul de inmatriculare : " + nrInmatriculare);
                serviceRemorca.deleteTrail(nrInmatriculare);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/remorci");
                break;
        }

        List<Remorca> remorci = this.serviceRemorca.getTrails();
        req.setAttribute("TrailsTobeDisplayed", remorci);
        req.getRequestDispatcher("/jsps/lists/listaRemorci.jsp").forward(req, resp);
//                break;
//            case ("remorci"):
//                List<Remorca> remorci = this.serviceRemorca.getTrails();
//                req.setAttribute("TrailsTobeDisplayed", remorci);
//                req.getRequestDispatcher("/jsps/lists/listaRemorci.jsp").forward(req, resp);
//                break;
//
//
//            default:
//                List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
//                req.setAttribute("UsersTobeDisplayed", utilizatori);
//                req.getRequestDispatcher("/jsps/lists/listaUtilizatori.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (null == action) ? "remorci" : action;
        switch (action) {
            case ("addRemorca"):
                String idRemorca = req.getParameter("nrInmatriculareRemorca");
                String idMasina = req.getParameter("nrInmatriculareMasina");
                Integer anulFabricatieiR = Integer.valueOf(req.getParameter("anFabricatieRemorca"));
                String itpR = req.getParameter("itpRemorca");
                serviceRemorca.addTrail(new Remorca(idRemorca,idMasina, anulFabricatieiR, itpR));

//                List<Remorca> remorci = this.serviceRemorca.getTrails();
//                req.setAttribute("TrailsTobeDisplayed", remorci);
//                req.getRequestDispatcher("/jsps/lists/listaRemorci.jsp").forward(req, resp);
                break;

            case ("editRemorca"):
                idRemorca = req.getParameter("nrInmatriculareRemorca");
                idMasina = req.getParameter("nrInmatriculareMasina");
                anulFabricatieiR = Integer.valueOf(req.getParameter("anFabricatieRemorca"));
                itpR = req.getParameter("itpRemorca");
                serviceRemorca.updateTrail(new Remorca(idRemorca, idMasina, anulFabricatieiR, itpR));

//                remorci = this.serviceRemorca.getTrails();
//                req.setAttribute("TrailsTobeDisplayed", remorci);
//                req.getRequestDispatcher("/jsps/lists/listaRemorci.jsp").forward(req, resp);
                break;
        }
//        List<Remorca> remorci = this.serviceRemorca.getTrails();
//        req.setAttribute("TrailsTobeDisplayed", remorci);
//        req.getRequestDispatcher("/jsps/lists/listaRemorci.jsp").forward(req, resp);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/remorci");

    }
}