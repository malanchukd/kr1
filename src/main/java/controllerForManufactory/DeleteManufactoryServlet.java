package controllerForManufactory;

import repository.ManufactoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-manufactory")
public class DeleteManufactoryServlet extends HttpServlet {

    private ManufactoryRepository manufactoryRepository;

    @Override
    public void init() {
        manufactoryRepository = ManufactoryRepository.getManufactoryRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (manufactoryRepository.delete(id)) {
            response.sendRedirect("/manufactory-list");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.setAttribute("message", "Task with ID '" + "' not found in Manufactory List!");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        }
    }
}
