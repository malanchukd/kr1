package controllerForSouvenir;

import repository.SouvenirRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/souvenir-list")
public class SouvenirListServlet extends HttpServlet {
    private SouvenirRepository souvenirRepository;

    @Override
    public void init() {
        souvenirRepository = SouvenirRepository.getSouvenirRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/souvenir-list.jsp");
        request.setAttribute("souvenir", souvenirRepository.all());
        requestDispatcher.forward(request, response);
    }
}
