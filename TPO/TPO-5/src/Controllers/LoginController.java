package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        Cookie login = new Cookie("login","");//deleting value of cookie
        Cookie password = new Cookie("password", "");
        response.addCookie(login);
        response.addCookie(password);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/index.jsp");
        dispatcher.forward(request, response);
    }

}
