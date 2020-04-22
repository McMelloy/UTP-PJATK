import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class hello extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1> Well Hello There - "+request.getMethod()+"</h1>");

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        try {
            int answer = Integer.parseInt(a) + Integer.parseInt(b);
            out.println(a + " + " + b + " = " + answer);
        }catch (NumberFormatException e){
            out.println("Invalid input");
        }catch (NullPointerException e){
            out.println("Invalid input");
        }

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
