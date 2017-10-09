package org.alf.hsqldb;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.alf.dao.UserGroupDAO;
import org.alf.model.UserGroup;
import org.alf.model.jpa.JPAUserGroup;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPAUserGroupQueryTest {

	@Test
	public void testGetById() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-group-dao-jpa-query.xml");
		
		UserGroupDAO userGroupDAO = context.getBean("userGroupDAO", UserGroupDAO.class);
		
		UserGroup group = userGroupDAO.getUserGroupById(1);
		System.out.println("group:" + group);

		context.close();
	}

	@Test
	public void testAddGroup() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-group-dao-jpa-query.xml");
		
		UserGroupDAO userGroupDAO = context.getBean("userGroupDAO", UserGroupDAO.class);

		UserGroup group = new JPAUserGroup(3, "admin");

		userGroupDAO.addUserGroup(group);

		context.close();
	}

	@Test
	public void testRemoveGroup() throws SQLException, ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-group-dao-jpa-query.xml");
		
		UserGroupDAO userGroupDAO = context.getBean("userGroupDAO", UserGroupDAO.class);

		userGroupDAO.removeUserGroup(new JPAUserGroup(2, "guest"));
		
		List<UserGroup> groups = userGroupDAO.getUserGroupsByIdRange(0, 10);
		System.out.println("group:" + groups);
		
		context.close();
	}

	@Test
	public void testModify() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-group-dao-jpa-query.xml");
		UserGroupDAO userGroupDAO = context.getBean("userGroupDAO", UserGroupDAO.class);

		userGroupDAO.modifyUserGroup(new JPAUserGroup(1, "root"));

		List<UserGroup> groups = userGroupDAO.getUserGroupsByIdRange(0, 10);
		System.out.println("after modify group:" + groups);
		
		context.close();
	}
}
