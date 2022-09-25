package ua.com.alevel;

import ua.com.alevel.model.Request;
import ua.com.alevel.repository.RequestRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestRepository requestRepository = RequestRepository.getInstance();
        Request request = new Request(
                req.getRemoteAddr(),
                req.getHeader("user-agent"),
                new Date()
        );
        requestRepository.save(request);

        req.setAttribute("request-repository", requestRepository.findAll());
        resp.setContentType("text/html");

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
