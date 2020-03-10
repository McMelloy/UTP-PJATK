package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.classes.User;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import org.junit.*;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class UserRepositoryTest extends RepositoryTestBase<UserDTO, IUserRepository> {
	GroupDTO group_1 = new GroupDTO(1,"11","first");
	GroupDTO group_2 = new GroupDTO(2,"12","second");
	GroupDTO group_3 = new GroupDTO(3, "13", "third");
	UserDTO user_1 = new UserDTO(1,"badass","password");
	UserDTO user_2 = new UserDTO(2,"clever","123");
	UserDTO user_3 = new UserDTO(3,"bold","P_A_S");
	List<GroupDTO> list_1 = new ArrayList<>();
	List<GroupDTO> list_2 = new ArrayList<>();
	List<GroupDTO> list_3 = new ArrayList<>();


	@Test
	public void add() {
		User userrep =  new User();

		UserDTO newuser = new UserDTO(0,"Very","Cool");
		list_2.add(group_3);
		newuser.setGroups(list_2);

		userrep.add(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("Very").size(),1);
	}

	@Test
	public void update() {
		User userrep =  new User();

		userrep.findByName("badass");
		UserDTO newuser = new UserDTO(0,"badass","better_password");;
		list_2.add(group_3);
		newuser.setGroups(list_2);

		userrep.update(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("badass").get(0).getPassword(),"better_password");
	}
	
	@Test
	public void addOrUpdate() {
		User userrep =  new User();

		UserDTO newuser = new UserDTO(0,"newbie","new_pass");
		list_2.add(group_3);
		newuser.setGroups(list_2);

		userrep.addOrUpdate(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("newbie").get(0).getPassword(),"new_pass");

		newuser = new UserDTO(0,"newbie","new_new_pass");
		userrep.addOrUpdate(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("newbie").get(0).getPassword(),"new_new_pass");

	}

	@Test
	public void delete() {
		User userrep =  new User();

		UserDTO newuser = new UserDTO(0,"to_delete","rubbish");
		list_2.add(group_3);
		newuser.setGroups(list_2);

		userrep.addOrUpdate(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("to_delete").size(),1);

		userrep.delete(newuser);
		userrep.commitTransaction();
		Assert.assertEquals(userrep.findByName("to_delete").size(),0);
	}
	
	@Test
	public void findByName() {
		User userrep =  new User();
		Assert.assertEquals(userrep.findByName("badass").size(),1);
		Assert.assertEquals(userrep.findByName("b%").size(),2);
	}
	
	@Override
	protected IUserRepository Create() {
		User userrep =  new User();

		list_1.add(group_2);
		list_1.add(group_3);

		list_2.add(group_1);
		list_2.add(group_3);

		list_3.add(group_3);

		user_1.setGroups(list_1);
		user_2.setGroups(list_2);
		user_3.setGroups(list_3);

		userrep.add(user_1);
		userrep.add(user_2);
		userrep.add(user_3);
		userrep.commitTransaction();
		return userrep;
	}

	@After
	public void after() {
		User u = new User();
		try {
			PreparedStatement stmt = u.getConnection().prepareStatement("DELETE FROM groups_users");
			stmt.executeUpdate();
			stmt = u.getConnection().prepareStatement("DELETE FROM group_s");
			stmt.executeUpdate();
			stmt = u.getConnection().prepareStatement("DELETE FROM users");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}