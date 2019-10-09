package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.UserDAOInterface;
import com.wp.DAO.UserImplementation;
import com.wp.entities.Users;

@Service
public class UserServiceImplementation implements UserServiceInterface {
	@Autowired
	private UserDAOInterface user;

	public void addUser(Users u) {
		user.addUser(u);

	}

	public void removeUser(String email) {
		user.removeUser(email);

	}

	public void updateUser(Users u) {
		user.updateUser(u);

	}

	public Users getUser(String email) {

		return user.getUser(email);
	}

	public List<Users> getAllUser() {

		return user.getAllUser();
	}

	public Users verifyUser(Users u) {

		return user.verifyUser(u);
	}

	public List<Users> getAllMails() {
		return user.getAllMails();
	}
}
