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

@WebServlet(value = "/edit-souvenir")
public class UpdateSouvenirServlet extends HttpServlet {
    private SouvenirRepository souvenirRepository;

    private Souvenir souvenir;

    @Override
    public void init() {
        souvenirRepository = SouvenirRepository.getSouvenirRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        souvenir = souvenirRepository.read(Integer.parseInt(request.getParameter("id")));

        if (souvenir == null) {
            response.setStatus(404);
            request.setAttribute("url", "/edit-souvenir");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        } else {
            request.setAttribute("souvenir", souvenir);
            request.getRequestDispatcher("/WEB-INF/pages/edit-souvenir.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(souvenir == null) {
            souvenir = souvenirRepository.read(Integer.parseInt(request.getParameter("id")));
        }
        String name = souvenir.getName();
        String manufactoryName = souvenir.getManufactoryName();
        LocalDate releaseDate = souvenir.getReleaseDate();
        double price = souvenir.getPrice();

        souvenir.setName(request.getParameter("name"));
        souvenir.setManufactoryName(request.getParameter("manufactoryName"));
        souvenir.setReleaseDate(LocalDate.parse(request.getParameter("yyyy,mm,dd")));
        souvenir.setPrice(Double.parseDouble(request.getParameter("price")));

        if(souvenirRepository.update(souvenir)) {
            response.sendRedirect("/souvenir-list");
        } else {
            request.setAttribute("error", "Souvenir with a given name already exists.");
            request.setAttribute("souvenir", souvenir);
            request.getRequestDispatcher("/WEB-INF/pages/edit-souvenir.jsp").forward(request, response);
            souvenir.setName(name);
            souvenir.setManufactoryName(manufactoryName);
            souvenir.setReleaseDate(releaseDate);
            souvenir.setPrice(price);
        }
    }
}
