package controllerForSouvenir;

import repository.SouvenirRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-souvenir")
public class DeleteSouvenirServlet extends HttpServlet {

    private SouvenirRepository souvenirRepository;

    @Override
    public void init() {
        souvenirRepository = SouvenirRepository.getSouvenirRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if(souvenirRepository.delete(id)) {
            response.sendRedirect("/souvenir-list");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.setAttribute("message", "Task with ID '" + "' not found in Souvenir List!");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        }
    }
}
