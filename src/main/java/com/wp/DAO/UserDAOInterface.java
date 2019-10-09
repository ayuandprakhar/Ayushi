package com.wp.DAO;

import java.util.List;

import com.wp.entities.Users;

public interface UserDAOInterface {
	public void addUser(Users u);

	public void removeUser(String email);

	public void updateUser(Users u);

	public Users getUser(String email);

	public List<Users> getAllUser();
	
	public Users verifyUser(Users u);
	public List<Users> getAllMails();

}
