package Control;

import Model.Categoria;
import Model.CategoriaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> lista_categorie= CategoriaDAO.doRetrieveAll();
        request.setAttribute("categorie", lista_categorie);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
