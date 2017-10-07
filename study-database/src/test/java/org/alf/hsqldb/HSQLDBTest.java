package org.alf.hsqldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		while (rs.next()) {
			System.out.println("id:" + rs.getInt(1) + ", name:" + rs.getString(2) + ", email:" + rs.getString(3) + ", dob:" + rs.getDate(4));
		}
		
		rs.close();
		stmt.close();
		connection.close();
		context.close();
	}

}
