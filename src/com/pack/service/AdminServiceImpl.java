package com.pack.service;

import com.pack.dao.AdminDaoImpl;
import com.pack.model.Login;
import com.pack.model.Profile;

public class AdminServiceImpl implements AdminService{

	@Override
	public Login fetchLogin(String usr, String pass) {
		AdminDaoImpl ad=new AdminDaoImpl();
		Login l=ad.fetchLogin(usr, pass);
		return l;
	}

	@Override
	public Profile fetchProfile(String usr) {
		AdminDaoImpl ad=new AdminDaoImpl();
		Profile p=ad.fetchProfile(usr);
		return p;
	}

	@Override
	public Login fetchLoginByUser(String usr) {
		AdminDaoImpl ad=new AdminDaoImpl();
		Login l=ad.fetchLoginByUser(usr);
		return l;
	}

	@Override
	public int setLoginStatus(Login l) {
		AdminDaoImpl ad=new AdminDaoImpl();
		int i=ad.setLoginStatus(l);
		return i;
	}



}
