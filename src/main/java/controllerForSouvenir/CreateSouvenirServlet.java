package controllerForSouvenir;

import model.Souvenir;
import repository.SouvenirRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = "/create-souvenir")
public class CreateSouvenirServlet extends HttpServlet {
    private SouvenirRepository souvenirRepository;

    @Override
    public void init() {
        souvenirRepository = SouvenirRepository.getSouvenirRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/create-souvenir.jsp").forward(request, response);

        if(Boolean.parseBoolean(request.getParameter("reset"))) {
            response.sendRedirect(getServletContext().getContextPath() + request.getServletPath());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String manufactoryName = request.getParameter("nameOfManufacture");
        LocalDate releaseDate = LocalDate.parse(request.getParameter("yyyy,mm,dd"));
        double price = Double.parseDouble(request.getParameter("price"));
        Souvenir souvenir = new Souvenir(name, manufactoryName, releaseDate, price);

        if(souvenir.getName().isBlank()) {
            request.setAttribute("atr", "Expected value in input field but is was empty.");
            request.getRequestDispatcher("/WEB-INF/pages/create-souvenir.jsp").forward(request, response);
        }
        if (souvenirRepository.create(souvenir)) {
            response.sendRedirect("/souvenir-list");
        }
    }
}
