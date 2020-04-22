package Logic;

import DTO.MenuContent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;

public class MenuLogic {
    PrintWriter out;
    String login; String password;
    MenuContent content;

    DataSource dataSource;

    public MenuLogic(HttpServletRequest request,
                     HttpServletResponse response) throws IOException, ServletException {
        out = response.getWriter();
        login = request.getParameter("login");
        password = request.getParameter("password");

        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/task5");
        } catch (NamingException exc) {
            throw new ServletException(
                    "didn't find data source", exc);
        }
        useLogic();
    }

    public MenuLogic(String login, String password, HttpServletResponse response) throws IOException, ServletException {
        out = response.getWriter();
        this.login = login;
        this.password = password;

        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/task5");
        } catch (NamingException exc) {
            throw new ServletException(
                    "didn't find data source", exc);
        }

        useLogic();
    }


    private void useLogic(){
        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            PreparedStatement stmt = con.prepareStatement("select * from users where u_login = ? and u_password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next()){
                content = null;
            }
            else {
                String name = rs.getString("u_name");
                String surname = rs.getString("u_surname");

                stmt = con.prepareStatement("select resources.r_id, r_name from users, permissions, resources " +
                        "where users.u_id = permissions.u_id and resources.r_id = permissions.r_id " +
                        "and u_login = ? and u_password = ?");
                stmt.setString(1, login);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                HashMap<Integer, String> resources = new HashMap<>();
                while (rs.next()) {
                    resources.put(rs.getInt("resources.r_id"), rs.getString("r_name"));
                }

                content = new MenuContent(name, surname, resources);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            content = null;
        } finally {
            try { con.close(); } catch (Exception exc) {}
        }
    }

    public MenuContent getContent(){
        return content;
    }
}
