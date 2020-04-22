package eu.glowacki.utp.assignment10.classes;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;
import eu.glowacki.utp.assignment10.repositories.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Group implements IGroupRepository {
    private Connection connection;

    public Group() {
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
    public void add(GroupDTO dto) {
        beginTransaction();
        PreparedStatement stmt;
        int id = dto.getId();
        String name = dto.getName();
        String description = dto.getDescription();

        List<UserDTO> list = dto.getUsers();

        try {
            stmt = getConnection().prepareStatement("INSERT INTO group_s VALUES(?, ?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.executeUpdate();
            if(list != null) {
                for (UserDTO user : list) {
                    stmt = getConnection().prepareStatement("INSERT INTO groups_users VALUES (?, ?)");
                    stmt.setString(1, user.getLogin());
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                }
            }
        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
    }

    @Override
    public void update(GroupDTO dto) {
        beginTransaction();
        PreparedStatement stmt;
        int id = dto.getId();
        String name = dto.getName();
        String description = dto.getDescription();
        try  {
            stmt = getConnection().prepareStatement("UPDATE group_s SET group_name = ?, group_description = ? WHERE group_id = ?");
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, id);
            stmt.executeUpdate();

        } catch(SQLException exc)  {
            System.out.println(exc);
            rollbackTransaction();
        }
    }

    @Override
    public void addOrUpdate(GroupDTO dto) {
        if (exists(dto)) {
            update(dto);
        } else {
            add(dto);
        }
    }

    @Override
    public void delete(GroupDTO dto) {
        beginTransaction();
        int id = dto.getId();
        if(exists(dto)) {
            PreparedStatement stmt;
            try {
                stmt = getConnection().prepareStatement("DELETE FROM groups_users WHERE group_id = ?");
                stmt.setInt(1,id);
                stmt.executeUpdate();

                stmt = getConnection().prepareStatement("DELETE FROM group_s WHERE group_id = ?");
                stmt.setInt(1, id);
                stmt.execute();

            } catch (SQLException exc) {
                System.out.println(exc);
                rollbackTransaction();
            }

        }
    }

    @Override
    public GroupDTO findById(int id) {
        PreparedStatement stmt;
        GroupDTO group = null;
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM group_s WHERE group_id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            group = new GroupDTO();

            while (resultSet.next()) {
                int gid = resultSet.getInt("group_id");
                String gname = resultSet.getString("group_name");
                String desc = resultSet.getString("group_description");
                System.out.println(gname + " "+desc);
                group.setId(gid);
                group.setName(gname);
                group.setDescription(desc);
            }

        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
        return group;
    }

    @Override
    public List<GroupDTO> findByName(String name) {
        PreparedStatement stmt;
        List<GroupDTO> groupsList = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM group_s WHERE group_name LIKE ?");
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("group_id");
                String gname = resultSet.getString("group_name");
                String desc = resultSet.getString("group_description");
                System.out.println(gname + " "+desc);
                GroupDTO group = new GroupDTO();
                group.setId(id);
                group.setName(gname);
                group.setDescription(desc);
                groupsList.add(group);
            }



        } catch (SQLException exc) {
            System.out.println(exc);
            rollbackTransaction();
        }
        return groupsList;
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
            stmt = getConnection().prepareStatement("SELECT * FROM group_s");
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
    public boolean exists(GroupDTO dto) {
        PreparedStatement stmt;
        String login = dto.getName();
        int count = 0;
        try {
            stmt = getConnection().prepareStatement("SELECT  count(1) FROM group_s WHERE group_name = ? ");
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