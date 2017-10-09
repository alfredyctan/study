package org.alf.hsqldb;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HSQLDBTest {

	@Test
	public void testConnection() throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/datasource.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		
		Connection connection = dataSource.getConnection();
		PreparedStatement stmt = connection.prepareStatement("select * from User");
		ResultSet rs = stmt.executeQuery();
		List<String> actual = new LinkedList<>();
		while (rs.next()) {
			String user = "id:" + rs.getInt(1) + ", name:" + rs.getString(2) + ", email:" + rs.getString(3) + ", dob:" + rs.getDate(4);
			actual.add(user);
			System.out.println(user);
		}
		
		assertThat("equals", actual, containsInAnyOrder(
			"id:1, name:Alfred Tan, email:alfred.yctan@gmail.com, dob:1977-02-05", 
			"id:2, name:Alfred Tan 2, email:alfred.yctan.2@gmail.com, dob:1977-02-05"
		));
		
		rs.close();
		stmt.close();
		connection.close();
		context.close();
	}

}
