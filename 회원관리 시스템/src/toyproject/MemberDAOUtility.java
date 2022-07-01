package toyproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.Driver;

public class MemberDAOUtility {

	public static Connection getConnection() {

		Connection con = null;

		try {
			DriverManager.registerDriver(new Driver());
			String memberURL = "jdbc:h2:tcp://localhost/~/test";
			con = DriverManager.getConnection(memberURL, "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public static void close(PreparedStatement stm, Connection con) {

		try {
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs, PreparedStatement stm, Connection con) {

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
