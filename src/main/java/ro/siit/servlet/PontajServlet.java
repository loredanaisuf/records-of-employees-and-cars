package ro.siit.servlet;

import ro.siit.model.Utilizator;
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


    @Override
    public void init() throws ServletException {
        this.serviceUtilizator = new ServiceUtilizator();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Utilizator> utilizatori = this.serviceUtilizator.getUsers();
        req.setAttribute("UsersTobeDisplayed",utilizatori);
        req.getRequestDispatcher("/jsps/forms/Pontaj.jsp").forward(req,resp);
    }
}
