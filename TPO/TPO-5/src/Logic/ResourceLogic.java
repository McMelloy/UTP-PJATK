package Logic;

import DTO.ResourceContent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;

public class ResourceLogic {
    int id;
    Cookie[] ck;
    ResourceContent content;
    DataSource dataSource;

    public ResourceLogic(HttpServletRequest request) throws ServletException {
        ck = request.getCookies();
        id = Integer.parseInt(request.getParameter("id"));
        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/task5");
        } catch (NamingException exc) {
            throw new ServletException(
                    "Nie mogę uzyskać źródła java:comp/env/jdbc/ksidb", exc);
        }
        doLogic();
    }

    private void doLogic(){
        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }

            PreparedStatement stmt = con.prepareStatement("select r_name, r_content from resources where r_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            String resName = rs.getString("r_name");
            String resContent = rs.getString("r_content");

            stmt = con.prepareStatement("select * from users where u_login = ? and u_password = ?");
            //System.out.println(ck[1].getName()+" = "+ck[1].getValue());
            stmt.setString(1, ck[1].getValue());
            stmt.setString(2, ck[2].getValue());
            rs = stmt.executeQuery();
            rs.first();

            content = new ResourceContent(
                    rs.getString("u_name"),
                    rs.getString("u_surname"),
                    resName, resContent);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { con.close(); } catch (Exception exc) {}
        }
    }

    public ResourceContent getContent(){
        return content;
    }
}
