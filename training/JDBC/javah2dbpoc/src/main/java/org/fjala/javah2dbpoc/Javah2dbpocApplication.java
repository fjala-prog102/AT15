package org.fjala.javah2dbpoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javah2dbpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(Javah2dbpocApplication.class, args);

		// JDBC sample test code
		try {
			jdbcTest();
		} catch (SQLException e) {
			System.err.println("jdbcTest() has failed.\n" + e);
		}
	}

	public static void jdbcTest() throws SQLException {
		String driverClassName = "org.h2.Driver";
		try {
			Class.forName (driverClassName);
		} catch (ClassNotFoundException e) {
			System.err.println("The driver '" + driverClassName + " is not available in the classpath.\n" + e);
			System.exit(1);
		}
		Properties properties = new Properties();
		properties.setProperty("user", "sa");
		properties.setProperty("password", "passwd");
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:jdbcpocdb", properties);

		// DDL
		connection.createStatement().execute("CREATE TABLE IF NOT EXISTS product (id INTEGER PRIMARY KEY, name VARCHAR(20))");
		connection.createStatement().execute("CREATE TABLE IF NOT EXISTS customer (id LONG PRIMARY KEY, first_name VARCHAR(30), last_name VARCHAR(30))");

		// Create some objects
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("My Product");

		Customer c1 = new Customer();
		c1.setCustomerId(1001L);
		c1.setFirstName("Joe");
		c1.setLastName("Black");

		// DML
		
		//connection.createStatement().execute("INSERT INTO product VALUES(1, 'test product')");
		insertProduct(connection, p1);
		insertCustomer(connection, c1);

		// TODO: clean up unused resources
	}

	public static void insertProduct(Connection connection, Product p) throws SQLException {
		PreparedStatement statement;
		statement = connection.prepareStatement("INSERT INTO product VALUES(?, ?)");
		statement.setInt(1, p.getId());
		statement.setString(2, p.getName());
		statement.execute();
	}

	public static void insertCustomer(Connection connection, Customer c) throws SQLException {
		PreparedStatement statement;
		statement = connection.prepareStatement("INSERT INTO customer VALUES(?, ?, ?)");
		statement.setLong(1, c.getCustomerId());
		statement.setString(2, c.getFirstName());
		statement.setString(3, c.getLastName());
		statement.execute();
	}

	// Non working code, just some pseudocode to illustrate how JPA might work internally
	/*public static void insertEntity(Connection connection, T t) throws SQLException {
		PreparedStatement statement;
		// introspection to get the fields and the number of "persistent" fields
		statement = connection.prepareStatement("INSERT INTO Customer VALUES(?...)");

		// introspection to set all fields
		for (PersistentField f : getPersistentFields(t)) {
			statement.setLong(f.getPosition(), c.get...());
		}

		statement.execute();
	}*/
}
