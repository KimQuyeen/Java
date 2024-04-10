package ktgk2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectSQL {

	private static String url = "jdbc:mysql://localhost:3306/KTKy2Java";
	private static String user = "root";
	private static String password = "@Trankimquyen123";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	public static List<Employee> findAll() {
		List<Employee> employeeList = new ArrayList<>();
		String query = "select * from employee";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Employee e = new Employee(rs.getString("id"), rs.getString("fullname"), rs.getString("birthday"),
						rs.getString("phone"), rs.getString("email"), query, 0);
				employeeList.add(e);
			}

		} catch (Exception e) {

		}
		return employeeList;
	}

	public static void insert(Employee e) {
		String query = "insert into student (id,fullname, birthday, phone, email) values (?, ?, ?, ?, ?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, e.getID());
			pstmt.setString(2, e.getFullName());
			pstmt.setString(3, e.getBirthDay());
			pstmt.setString(4, e.getPhone());
			pstmt.setString(5, e.getEmail());

			pstmt.executeUpdate();

		} catch (Exception ex) {
			String message = ex.getMessage();
			System.out.println("Err msg: " + message);
		}
	}
//
	public static void delete(Employee e) {
		String query = "delete from employee where name = '" + e.getFullName() + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			String message = ex.getMessage();
			System.out.println("Err msg: " + message);

		}

	}

	public static void Update(Employee e) {
		String query = "Update student set fullname= ?, id = ?, birthday = ?, phone = ?, email = ?, empolyee_type = ? where name = '"
				+ e.getFullName() + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, e.getID());
			pstmt.setString(2, e.getFullName());
			pstmt.setString(3, e.getBirthDay());
			pstmt.setString(4, e.getPhone());
			pstmt.setString(5, e.getEmail());
			pstmt.setFloat(6, e.getEmployeeCount());

			pstmt.executeUpdate();

		} catch (Exception ex) {
			String message = ex.getMessage();
			System.out.println("Err msg: " + message);
			
			
		}
	}

	public static List<Employee> findByName(Employee e) {
		List<Employee> employee1 = new ArrayList<>();
		String query = "select * from student where student.name ='" + e.getFullName() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Employee st = new Employee(rs.getString("id"), rs.getString("fullname"), rs.getString("birthday"), rs.getString("phone"),
						rs.getFloat("email"), rs.getString("employeetype"));
				employee1.add(st);
			}
		} catch (Exception ex) {
			String message = ex.getMessage();
			System.out.println("Err msg: " + message);

		}
		return employee1;
	}

}
