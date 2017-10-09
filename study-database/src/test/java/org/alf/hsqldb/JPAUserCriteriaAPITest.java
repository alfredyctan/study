package org.alf.hsqldb;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import org.alf.dao.UserDAO;
import org.alf.model.User;
import org.alf.model.jpa.JPAUser;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPAUserCriteriaAPITest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void testGetById() throws SQLException, ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
		
		User user = userDAO.getUserById(1);
		System.out.println("user:" + user);
		assertThat("found user", user, is(new JPAUser(1, "Alfred Tan", "alfred.yctan@gmail.com", "1977-02-05")));
		context.close();
	}

	@Test
	public void testByIdRange() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
		
		List<User> users = userDAO.getUsersByIdRange(0, 3);
		System.out.println("user:" + users);
		assertThat("found 1 and 2", users, containsInAnyOrder(
			new JPAUser(1, "Alfred Tan", "alfred.yctan@gmail.com", "1977-02-05"),
			new JPAUser(2, "Alfred Tan 2", "alfred.yctan.2@gmail.com", "1977-02-05")
		));

		context.close();
	}

	@Test
	public void testAddUser() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		User user = new JPAUser(3, "Alfred Tan Add", "alfred.yctan@gmail.com", "1999-02-02");

		userDAO.addUser(user);

		user = userDAO.getUserById(3);
		System.out.println("user:" + user);
		assertThat("found user", user, is(new JPAUser(3, "Alfred Tan Add", "alfred.yctan@gmail.com", "1999-02-02")));

		context.close();
	}

	@Test
	public void testAddUsers() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		List<User> users = new LinkedList<>();
		users.add(new JPAUser(3, "Alfred Tan Add", "alfred.yctan@gmail.com", "2000-01-01"));
		users.add(new JPAUser(4, "Alfred Tan Add", "alfred.yctan@gmail.com", "1999-01-01"));

		userDAO.addUsers(users);
		
		users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("user:" + users);
		assertThat("found 1 - 4", users, containsInAnyOrder(
			new JPAUser(1, "Alfred Tan", "alfred.yctan@gmail.com", "1977-02-05"),
			new JPAUser(2, "Alfred Tan 2", "alfred.yctan.2@gmail.com", "1977-02-05"),
			new JPAUser(3, "Alfred Tan Add", "alfred.yctan@gmail.com", "2000-01-01"),
			new JPAUser(4, "Alfred Tan Add", "alfred.yctan@gmail.com", "1999-01-01")
		));
		
		context.close();
	}

	@Test
	public void testRemoveUser() throws SQLException, ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		userDAO.removeUser(new JPAUser(2, "Alfred Tan 2", "alfred.yctan.2@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1977-02-05")));
		
		List<User> users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("user:" + users);
		
		context.close();
	}

	@Test
	public void testRemoveByIdRange() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		List<User> users = new LinkedList<>();
		users.add(new JPAUser(3, "Alfred Tan Add", "alfred.yctan@gmail.com", new Date()));
		users.add(new JPAUser(4, "Alfred Tan Add", "alfred.yctan@gmail.com", new Date()));

		userDAO.addUsers(users);
		users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("after added user:" + users);

		userDAO.removeUsersByIdRange(2, 3); //2,3 inclusive
		users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("after remove user:" + users);
		
		context.close();
	}
	
	@Test
	public void testModify() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		userDAO.modifyUser(new JPAUser(1, "Alfred Tan Updated", "alfred.yctan@gmail.com", new Date()));

		List<User> users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("after modify user:" + users);
		
		context.close();
	}

	@Test
	public void testModifyByIdRange() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/user-dao-jpa-criteria-api.xml");
		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		List<User> users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("before modify user:" + users);
		userDAO.modifyUsersAttributeByIdRange(1, 2, User.NAME, "Alftank");
		
		users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("after modify user name:" + users);
		
		userDAO.modifyUsersAttributeByIdRange(1, 2, User.EMAIL, "char@yahoo.com.hk");
		users = userDAO.getUsersByIdRange(0, 10);
		System.out.println("after modify user email:" + users);
		
		context.close();
	}
}