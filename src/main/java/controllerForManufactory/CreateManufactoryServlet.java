package controllerForManufactory;


import model.Country;
import model.Manufactory;
import repository.ManufactoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/create-manufactory")
public class CreateManufactoryServlet extends HttpServlet {
    private ManufactoryRepository manufactoryRepository;

    @Override
    public void init() {
        manufactoryRepository = ManufactoryRepository.getManufactoryRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/create-manufactory.jsp").forward(request, response);

        if (Boolean.parseBoolean(request.getParameter("reset"))) {
            response.sendRedirect(getServletContext().getContextPath() + request.getServletPath());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Country country = Country.valueOf(request.getParameter("country").toUpperCase());
        Manufactory manufactory = new Manufactory(name, country);

        if(manufactory.getName().isBlank()) {
            request.setAttribute("atr", "Expected value in input field but it was empty.");
            request.getRequestDispatcher("/WEB-INF/pages/create-manufactory.jsp").forward(request, response);
            return;
        }

        if (manufactoryRepository.create(manufactory)) {
            response.sendRedirect("/manufactory-list");
        } else {
            request.setAttribute("atr", "Manufactory with a given name already exists.");
            request.getRequestDispatcher("/WEB-INF/pages/create-manufactory.jsp").forward(request, response);
        }
    }
}
