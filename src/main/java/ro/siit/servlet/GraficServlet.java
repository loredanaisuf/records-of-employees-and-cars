package ro.siit.servlet;

import ro.siit.model.InformatiiPtGrafic;
import ro.siit.service.ServiceInformatii;
import ro.siit.service.ServiceMasina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/grafic"})
public class GraficServlet extends HttpServlet {
    private ServiceInformatii serviceInformatii;

    @Override
    public void init() throws ServletException {
        this.serviceInformatii = new ServiceInformatii();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nrInmatriculare = (String) req.getSession().getAttribute("numarInmatriculare");
        System.out.println("Numarul de inmatriculare din informatii : " + nrInmatriculare);
        List<InformatiiPtGrafic> informatiiPtGraficList1 = serviceInformatii.getNumberOfKM(nrInmatriculare);
        System.out.println("Inf pt nr de km sunt: " + informatiiPtGraficList1);
        req.setAttribute("numberOfKM",informatiiPtGraficList1);

        List<InformatiiPtGrafic> informatiiPtGraficList2 = serviceInformatii.getQuantityOfFuel(nrInmatriculare);
        System.out.println("Inf pt motorina sunt: " + informatiiPtGraficList2);
        req.setAttribute("quantityOfFuel",informatiiPtGraficList2);

        List<InformatiiPtGrafic> informatiiPtGraficList3 = serviceInformatii.getConsumption(nrInmatriculare);
        System.out.println("Inf pt consum sunt: " + informatiiPtGraficList3);
        req.setAttribute("consumption",informatiiPtGraficList3);

        req.getRequestDispatcher("/jsps/lists/grafic.jsp").forward(req,resp);
    }
}
