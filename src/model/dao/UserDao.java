package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectMySQLDBLibrary;
import model.bean.User;

public class UserDao {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	private ConnectMySQLDBLibrary connectMySQLDBLibrary;

	public UserDao() {
		connectMySQLDBLibrary = new ConnectMySQLDBLibrary();
	}

	public User checkLogin(String username, String password) {
		System.out.println("checkLogin");
		conn = connectMySQLDBLibrary.getConnectMySQL();
		User objUser = null;
		String sql = "SELECT * FROM user WHERE username = ? && password = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				objUser = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objUser;

	}

	public ArrayList<User> getListUser() {
		ArrayList<User> listUsers = new ArrayList<>();
		conn = connectMySQLDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM user";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User objUser = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("role"));
				listUsers.add(objUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listUsers;
	}

	public int addUser(User objUser) {
		int result = 0;
		conn = connectMySQLDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO user(username,password,fullname,role) VALUE (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getPassword());
			pst.setString(3, objUser.getFullName());
			pst.setInt(4, objUser.getRole());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User findByIdUser(int idUser) {
		conn = connectMySQLDBLibrary.getConnectMySQL();
		User objUser = null;
		String sql = "SELECT * FROM user WHERE id_user=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
			rs = pst.executeQuery();
			if (rs.next()) {
				objUser = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objUser;
	}

	public int editUser(User objUser) {
		int result = 0;
		conn = connectMySQLDBLibrary.getConnectMySQL();
		String sql = "UPDATE user SET password = ? ,fullname = ? ,role = ? WHERE id_user = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getPassword());
			pst.setString(2, objUser.getFullName());
			pst.setInt(3, objUser.getRole());
			pst.setInt(4, objUser.getIdUser());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User checkUsername(String username) {
		conn = connectMySQLDBLibrary.getConnectMySQL();
		User objUser = null;
		String sql = "SELECT * FROM user WHERE username = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				objUser = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objUser;
	}

	public int deleteUser(int idUser) {
		int result = 0;
		conn = connectMySQLDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM user WHERE id_user = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<User> getUserByUsernameOrFullName(String keyword) {
		ArrayList<User> listUserSearch = new ArrayList<>();
		conn = connectMySQLDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM user WHERE username LIKE ? OR fullname LIKE ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, keyword);
			pst.setString(2, keyword);
			rs = pst.executeQuery();
			while (rs.next()) {
				User objUser = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("role"));
				listUserSearch.add(objUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUserSearch;
	}
}
