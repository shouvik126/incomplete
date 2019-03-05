package com.pack.service;

import com.pack.model.Login;
import com.pack.model.Profile;

public interface AdminService {
	public Login fetchLogin(String usr,String pass);
	public Login fetchLoginByUser(String usr);
	public Profile fetchProfile(String usr);
	public int setLoginStatus(Login l);
}
