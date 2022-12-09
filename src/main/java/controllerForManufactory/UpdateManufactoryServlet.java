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

@WebServlet(value = "/edit-manufactory")
public class UpdateManufactoryServlet extends HttpServlet {

    private ManufactoryRepository manufactoryRepository;

    private Manufactory manufactory;

    @Override
    public void init() {
        manufactoryRepository = ManufactoryRepository.getManufactoryRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        manufactory = manufactoryRepository.read(Integer.parseInt(request.getParameter("id")));

        if (manufactory == null) {
            response.setStatus(404);
            request.setAttribute("url", "/edit-manufactory");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        } else {
            request.setAttribute("manufactory", manufactory);
            request.getRequestDispatcher("/WEB-INF/pages/edit-manufactory.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(manufactory == null) {
            manufactory = manufactoryRepository.read(Integer.parseInt(request.getParameter("id")));
        }
        String name = manufactory.getName();
        Country country = manufactory.getCountry();

        manufactory.setName(request.getParameter("name"));
        manufactory.setCountry(Country.valueOf(request.getParameter("country")));

        if(manufactoryRepository.update(manufactory)) {
            response.sendRedirect("/manufactory-list");
        } else {
            request.setAttribute("error", "Manufactory with a given name already exists.");
            request.setAttribute("manufactory", manufactory);
            request.getRequestDispatcher("/WEB-INF/pages/edit-manufactory.jsp").forward(request, response);
            manufactory.setName(name);
            manufactory.setCountry(country);
        }
    }
}
