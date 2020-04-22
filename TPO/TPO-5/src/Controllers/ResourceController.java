package Controllers;

import DTO.ResourceContent;
import Logic.ResourceLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/res")
public class ResourceController extends HttpServlet {
    public void doPost(HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
        Cookie[] ck = request.getCookies();
        System.out.println("Resource");
        System.out.println(ck[1].getName()+" = "+ck[1].getValue());
        System.out.println(ck[2].getName()+" = "+ck[2].getValue());

        ResourceLogic rl = new ResourceLogic(request);
        request.setAttribute("Content",rl.getContent());
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/resource.jsp");
        dispatcher.forward(request, response);

    }
}
