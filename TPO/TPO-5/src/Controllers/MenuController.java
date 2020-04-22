package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Logic.MenuLogic;

@WebServlet("/menu")
public class MenuController extends HttpServlet{
    public void processRequest(HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/menu.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        Cookie login = new Cookie("login", request.getParameter("login"));
        Cookie password = new Cookie("password", request.getParameter("password"));
        response.addCookie(login);
        response.addCookie(password);

        MenuLogic logic = new MenuLogic(request, response); //after login -> login and password through parameters
        if(logic.getContent() == null){
            out.println("LOGIN ERROR");
        }
        else {
            request.setAttribute("Content", logic.getContent());
            processRequest(request, response);
        }
    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        Cookie[] ck = request.getCookies();

        MenuLogic logic = new MenuLogic(ck[1].getValue(), ck[2].getValue(), response); //return from Resource -> login and pass through cookies
        request.setAttribute("Content",logic.getContent());

        processRequest(request,response);
    }

}
