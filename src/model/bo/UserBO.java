package model.bo;

import java.util.ArrayList;

import model.bean.User;
import model.dao.UserDao;

public class UserBO {
	UserDao userDao = new UserDao();

	public UserBO() {
		super();
	}

	public int deleteUser(int idUser) {
		return userDao.deleteUser(idUser);
	}

	public User findByIdUser(int idUser) {
		return userDao.findByIdUser(idUser);
	}

	public int editUser(User objUser) {
		return userDao.editUser(objUser);
	}

	public ArrayList<User> getUserByUsernameOrFullName(String keyword) {
		return userDao.getUserByUsernameOrFullName(keyword);
	}

	public User checkLogin(String username, String password) {
		System.out.println("huhu");
		return userDao.checkLogin(username, password);
	}

	public User checkUsername(String username) {
		return userDao.checkUsername(username);
	}

	public int addUser(User objUser) {
		return userDao.addUser(objUser);
	}

	public ArrayList<User> getListUser() {
		return userDao.getListUser();
	}

}
