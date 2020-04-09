import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/menu")
public class Controller extends HttpServlet {
    public void processRequest(HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String connectionUrl = "jdbc:oracle:thin:@db-oracle.pjwstk.edu.pl:1521:baza";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "select * from USR where login = "+login;
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                out.println(rs.getString("name") + " " + rs.getString("surname"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        processRequest(request,response);
    }
}
