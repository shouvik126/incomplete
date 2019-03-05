package com.pack.dao;

import com.pack.model.Login;
import com.pack.model.Profile;

public interface AdminDao {
	public Login fetchLogin(String usrname,String password);
	public Login fetchLoginByUser(String usr);
	public Profile fetchProfile(String usr);
	public int setLoginStatus(Login l);
	
}
