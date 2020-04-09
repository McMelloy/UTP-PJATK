import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class Controller extends HttpServlet {
    public void processRequest(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        request.setAttribute("a", a);
        request.setAttribute("b", b);

        try{
            Add add = new Add(a,b);
            int res = add.getResult();
            request.setAttribute("res", res);
        }catch (NumberFormatException e){
            request.setAttribute("res", null);
        }catch (NullPointerException e){
            request.setAttribute("res", null);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/add.jsp");
        dispatcher.forward(request, response);
    }


    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        processRequest(request,response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        processRequest(request,response);
    }
}
