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
        response.setContentType("text/plain");
        System.out.println("Controller");
        PrintWriter out = response.getWriter();

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        System.out.println(a + " " +b);

        try {
            int answer = Integer.parseInt(a) + Integer.parseInt(b);
            out.println(answer);
            System.out.println(answer);
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
