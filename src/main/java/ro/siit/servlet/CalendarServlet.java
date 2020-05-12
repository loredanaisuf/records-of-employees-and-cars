package ro.siit.servlet;

import ro.siit.model.Event;
import ro.siit.service.ServiceCalendar;
import ro.siit.service.ServiceUtilizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = {"/calendar"})
public class CalendarServlet extends HttpServlet {
    private ServiceCalendar serviceCalendar;

    @Override
    public void init() throws ServletException {
        this.serviceCalendar = new ServiceCalendar();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> events = new ArrayList<>();
        events = serviceCalendar.getDatesFromDB();
        req.setAttribute("events", events);
        req.getRequestDispatcher("/jsps/lists/calendar.jsp").forward(req, resp);

    }


}
