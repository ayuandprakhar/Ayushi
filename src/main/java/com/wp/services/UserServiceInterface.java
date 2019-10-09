package com.wp.services;

import java.util.List;

import com.wp.entities.Transporter;
import com.wp.entities.Users;


public interface UserServiceInterface {
	public void addUser(Users u);

	public void removeUser(String email);

	public void updateUser(Users u);

	public Users getUser(String email);

	public List<Users> getAllUser();
	public List<Users> getAllMails();

	public Users verifyUser(Users u);
}
