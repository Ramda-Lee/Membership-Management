package toyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection con = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;

	private String MEMBER_LIST = "select * from member";
	private String MEMBER_INSERT = "insert into member values(?, ?, ?)";
	private String MEMBER_UPDATE = "update member set phone_number =? where member_ID =?";
	private String MEMBER_DELETE = "delete member where member_ID = ?";
	private String MEMBER_SELECT = "select * from member where member_ID = ?";

	Member mb = new Member();

	public void getMemberList() {

		try {

			con = MemberDAOUtility.getConnection();
			stm = con.prepareStatement(MEMBER_LIST);
			rs = stm.executeQuery();

			if (rs.next() == false) {
				System.out.println("등록된 회원이 아닙니다.");
			} else {
				System.out.println("현재 등록된 회원 목록 입니다.");
			}

			while (rs.next()) {

				mb.setMember_ID(rs.getString("MEMBER_ID"));
				mb.setName(rs.getString("NAME"));
				mb.setPhone_number(rs.getString("PHONE_NUMBER"));
				System.out.println(mb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAOUtility.close(rs, stm, con);
		}

	}

	public void insertMember(String member_ID, String name, String phone_Number) {

		try {
			con = MemberDAOUtility.getConnection();
			stm = con.prepareStatement(MEMBER_INSERT);
			stm.setString(1, member_ID);
			stm.setString(2, name);
			stm.setString(3, phone_Number);
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAOUtility.close(stm, con);
		}
	}

	public void updateMember(String phone_number, String member_ID) {
		try {
			con = MemberDAOUtility.getConnection();
			stm = con.prepareStatement(MEMBER_UPDATE);
			stm.setString(1, phone_number);
			stm.setString(2, member_ID);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAOUtility.close(stm, con);
		}
	}

	public void deleteMember(String member_ID) {
		try {
			con = MemberDAOUtility.getConnection();
			stm = con.prepareStatement(MEMBER_DELETE);
			stm.setString(1, member_ID);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAOUtility.close(stm, con);
		}
	}

	public boolean selectMember(String member_ID) {
		try {
			con = MemberDAOUtility.getConnection();
			stm = con.prepareStatement(MEMBER_SELECT);
			stm.setString(1, member_ID);
			stm.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAOUtility.close(stm, con);
		}
		return false;

	}

}
