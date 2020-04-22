package eu.glowacki.utp.assignment10.classes;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User implements IUserRepository {
    private Connection connection;

    public User() {
        String driverName = "com.mysql.cj.jdbc.Driver";//com.mysql.jdbc.Driver
        String url = "jdbc:mysql://localhost:3306/app10?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CET";
        String user = "root";
        String password = "root";

		try {
			Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException exc) {
            System.out.println("Driver could not be loaded");
            System.out.println(exc);
            System.exit(1);

        } catch (SQLException exc) {
            System.out.println("Connection could not be established: " + url);
            System.out.println(exc);
            System.exit(1);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void add(UserDTO dto) {
        beginTransaction();
        PreparedStatement stmt;
        String login = dto.getLogin();
        String password = dto.getPassword();

        List<GroupDTO> groupList = dto.getGroups();
        try {
            stmt = getConnection().prepareStatement("INSERT INTO users VALUES(?, ?)");
            stmt.setString(1, login);
            stmt.setString(2, password);
            stmt.executeUpdate();


            for (GroupDTO group : groupList) {
                stmt = getConnection().prepareStatement("INSERT INTO groups_users VALUES (?, ?)");
                stmt.setString(1, login);
                stmt.setInt(2, group.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
    }

    @Override
    public void update(UserDTO dto) {
        beginTransaction();
        PreparedStatement stmt;
        String login = dto.getLogin();
        String password = dto.getPassword();
        List<GroupDTO> list = dto.getGroups();
        try  {
            stmt = getConnection().prepareStatement("UPDATE users SET user_password = ? WHERE user_login = ?");
            stmt.setString(1, password);
            stmt.setString(2, login);
            stmt.executeUpdate();
        } catch(SQLException exc)  {
            System.out.println(exc);
            rollbackTransaction();
        }
    }

    @Override
    public void addOrUpdate(UserDTO dto) {
        if (exists(dto)) {
            update(dto);
        } else {
            add(dto);
        }
    }

    @Override
    public void delete(UserDTO dto) {
        beginTransaction();
        String login = dto.getLogin();
        String password = dto.getPassword();
        if(exists(dto)) {
            PreparedStatement stmt;
            try {
                stmt = getConnection().prepareStatement("DELETE FROM groups_users WHERE user_login = ?");
                stmt.setString(1,login);
                stmt.executeUpdate();

                stmt = getConnection().prepareStatement("DELETE FROM users WHERE user_login = ? AND user_password = ?");
                stmt.setString(1, login);
                stmt.setString(2, password);
                stmt.execute();

            } catch (SQLException exc) {
                System.out.println(exc);
                rollbackTransaction();
            }

        }
    }

    @Override
    public UserDTO findById(int id) {
        return null;
    }

    @Override
    public List<UserDTO> findByName(String username) {
        PreparedStatement stmt;
        List<UserDTO> usersList = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM users WHERE user_login LIKE ?");
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("user_login");
                String password = resultSet.getString("user_password");
                System.out.println(name + " "+password);

                UserDTO user = new UserDTO();
                user.setLogin(name);
                user.setPassword(password);
                usersList.add(user);
            }

        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
        return usersList;
    }


    @Override
    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void commitTransaction() {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        PreparedStatement stmt;

        int count = 0;
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM users");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                count++;
            }

        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
        return count;
    }

    @Override
    public boolean exists(UserDTO dto) {
        PreparedStatement stmt;
        String login = dto.getLogin();
        int count = 0;
        try {
            stmt = getConnection().prepareStatement("SELECT  count(1) FROM users WHERE user_login = ? ");
            stmt.setString(1, login);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.first();
            count = resultSet.getInt(1);

        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

}