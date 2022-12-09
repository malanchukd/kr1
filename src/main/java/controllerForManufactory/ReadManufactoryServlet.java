package controllerForManufactory;

import model.Manufactory;
import repository.ManufactoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/read-manufactory")
public class ReadManufactoryServlet extends HttpServlet {

    private ManufactoryRepository manufactoryRepository;

    @Override
    public void init() {
        manufactoryRepository = ManufactoryRepository.getManufactoryRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int manufactoryId = Integer.parseInt(request.getParameter("id"));
        Manufactory manufactory = manufactoryRepository.read(manufactoryId);
        if (manufactory == null) {
            request.setAttribute("url", request.getServletPath());
            response.setStatus(404);
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        } else {
            request.setAttribute("manufactory", manufactory);
            request.getRequestDispatcher("/WEB-INF/pages/read-manufactory.jsp").forward(request, response);
        }
    }
}
