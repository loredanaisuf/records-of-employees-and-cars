package ro.siit.servlet;

import ro.siit.model.InformatiiMasina;
import ro.siit.service.ServiceInformatii;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/informatii"})
public class InformatiiServlet extends HttpServlet {
    private ServiceInformatii serviceInformatii;

    @Override
    public void init() throws ServletException {
        this.serviceInformatii = new ServiceInformatii();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nrInmatriculare = (String) req.getSession().getAttribute("numarInmatriculare");
        List<InformatiiMasina> informatiiMasinaList = serviceInformatii.getInformation(nrInmatriculare);
        req.setAttribute("nrInmatriculare", nrInmatriculare);
        req.setAttribute("information",informatiiMasinaList);
        req.setAttribute("displayKm","none");
        req.setAttribute("displayF","none");
        req.setAttribute("displayC","none");
        req.getRequestDispatcher("/jsps/lists/informatii.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstDate = req.getParameter("km-from");
        String secondDate = req.getParameter("km-to");
        float numberOfKms = serviceInformatii.getNrOfKm(firstDate,secondDate);
        req.setAttribute("numberOfKms",numberOfKms);
        req.setAttribute("firstDateKm", firstDate);
        req.setAttribute("secondDateKm", secondDate);
        req.setAttribute("displayKm","block");
        System.out.println("Nr of km: " + numberOfKms);

        firstDate = req.getParameter("f-from");
        secondDate = req.getParameter("f-to");
        int fuel = serviceInformatii.getFuel(firstDate,secondDate);
        req.setAttribute("fuel",fuel);
        req.setAttribute("firstDateF", firstDate);
        req.setAttribute("secondDateF", secondDate);
        req.setAttribute("displayF","block");

        firstDate = req.getParameter("c-from");
        secondDate = req.getParameter("c-to");
        float consumption = serviceInformatii.getFuel(firstDate,secondDate);
        req.setAttribute("consumption",consumption);
        req.setAttribute("firstDateC", firstDate);
        req.setAttribute("secondDateC", secondDate);
        req.setAttribute("displayC","block");

        String nrInmatriculare = (String) req.getSession().getAttribute("numarInmatriculare");
        List<InformatiiMasina> informatiiMasinaList = serviceInformatii.getInformation(nrInmatriculare);
        req.setAttribute("nrInmatriculare", nrInmatriculare);
        req.setAttribute("information",informatiiMasinaList);

        req.getRequestDispatcher("/jsps/lists/informatii.jsp").forward(req,resp);
    }
}
