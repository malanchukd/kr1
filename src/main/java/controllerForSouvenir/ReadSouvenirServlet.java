package controllerForSouvenir;

import model.Souvenir;
import repository.SouvenirRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/read-souvenir")
public class ReadSouvenirServlet extends HttpServlet {

    private SouvenirRepository souvenirRepository;

    @Override
    public void init() {
        souvenirRepository = SouvenirRepository.getSouvenirRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int souvenirId = Integer.parseInt(request.getParameter("id"));
        Souvenir souvenir = souvenirRepository.read(souvenirId);
        if (souvenir == null) {
            request.setAttribute("url", request.getServletPath());
            response.setStatus(404);
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        } else {
            request.setAttribute("souvenir", souvenir);
            request.getRequestDispatcher("/WEB-INF/pages/read-souvenir.jsp").forward(request, response);
        }
    }
}
