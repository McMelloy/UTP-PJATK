package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.classes.Group;
import eu.glowacki.utp.assignment10.classes.Group;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryTest extends RepositoryTestBase<GroupDTO, IGroupRepository> {
	GroupDTO group_1 = new GroupDTO(1,"11","first");
	GroupDTO group_2 = new GroupDTO(2,"12","second");
	GroupDTO group_3 = new GroupDTO(3, "13", "third");
	UserDTO user_1 = new UserDTO(1,"badass","password");
	UserDTO user_2 = new UserDTO(2,"clever","123");
	UserDTO user_3 = new UserDTO(3,"pretty","P_A_S");
	List<UserDTO> list_1 = new ArrayList<>();
	List<UserDTO> list_2 = new ArrayList<>();
	List<UserDTO> list_3 = new ArrayList<>();


	@Test
	public void add() {
		Group grouprep =  new Group();

		GroupDTO newgroup = new GroupDTO(4,"14","fourth");
		list_2.add(user_3);
		newgroup.setUsers(list_2);

		grouprep.add(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findById(4).getName(),"14");
	}

	@Test
	public void update() {
		Group grouprep =  new Group();

		Assert.assertEquals(grouprep.findByName("13").get(0).getDescription(),"third");
		GroupDTO newgroup = new GroupDTO(3,"13","reformed third");
		list_2.add(user_3);
		newgroup.setUsers(list_2);

		grouprep.update(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findByName("13").get(0).getDescription(),"reformed third");

	}

	@Test
	public void addOrUpdate() {
		Group grouprep =  new Group();

		GroupDTO newgroup = new GroupDTO(4,"14","fourth");
		list_2.add(user_3);
		newgroup.setUsers(list_2);

		grouprep.addOrUpdate(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findByName("14").get(0).getDescription(),"fourth");

		newgroup = new GroupDTO(4,"24","master fourth");
		grouprep.addOrUpdate(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findByName("24").get(0).getDescription(),"master fourth");
	}

	@Test
	public void delete() {
		Group grouprep =  new Group();

		GroupDTO newgroup = new GroupDTO(4,"to_delete","rubbish");
		list_2.add(user_3);
		newgroup.setUsers(list_2);

		grouprep.addOrUpdate(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findByName("to_delete").size(),1);


		grouprep.delete(newgroup);
		grouprep.commitTransaction();
		Assert.assertEquals(grouprep.findByName("to_delete").size(),0);

	}

	@Test
	public void findByName() {
		Group grouprep =  new Group();
		Assert.assertEquals(grouprep.findByName("11").size(),1);
		Assert.assertEquals(grouprep.findByName("1%").size(),3);
	}

	@Override
	protected IGroupRepository Create() {
		Group grouprep =  new Group();

		list_1.add(user_2);
		list_1.add(user_3);

		list_2.add(user_1);
		list_2.add(user_3);

		list_3.add(user_3);

		group_1.setUsers(list_1);
		group_2.setUsers(list_2);
		group_3.setUsers(list_3);

		grouprep.add(group_1);
		grouprep.add(group_2);
		grouprep.add(group_3);
		grouprep.commitTransaction();
		return grouprep;
	}

	@After
	public void after() {
		Group u = new Group();
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