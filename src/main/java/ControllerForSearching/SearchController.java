package ControllerForSearching;

import model.Manufactory;
import repository.ManufactoryRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/search-page")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/search-page.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Manufactory> manufactoryList = ManufactoryRepository.getManufactoryRepository().all();
        String search;
        search = request.getParameter("search");
        List<Manufactory> searchList = new ArrayList<>();
        for (Manufactory m: manufactoryList) {
            if(search.equals(m.getName())) searchList.add(m);
        }

        request.setAttribute("searchList", searchList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("search-page.jsp");
        dispatcher.forward(request, response);
    }
}
