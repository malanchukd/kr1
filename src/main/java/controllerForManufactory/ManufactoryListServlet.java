package controllerForManufactory;

import repository.ManufactoryRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/manufactory-list")
public class ManufactoryListServlet extends HttpServlet {
    private ManufactoryRepository manufactoryRepository;

    @Override
    public void init() {
        manufactoryRepository = ManufactoryRepository.getManufactoryRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/manufactory-list.jsp");
        request.setAttribute("manufactory", manufactoryRepository.all());
        requestDispatcher.forward(request, response);
    }
}

