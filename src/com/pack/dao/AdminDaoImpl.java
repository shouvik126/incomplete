package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack.DBUtility;
import com.pack.model.Login;
import com.pack.model.Profile;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Login fetchLogin(String usr, String pass) {
		Connection con=null;
		PreparedStatement ps=null;
		Login l=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select id,password,status,usertype from login where id=? and password=?");
			ps.setString(1, usr);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				l=new Login();
				l.setId(rs.getString("id"));
				l.setPassword(rs.getString("password"));
				l.setStatus(rs.getInt("status"));
				l.setUsertype(rs.getString("usertype"));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return l;
	}

	@Override
	public Profile fetchProfile(String usr) {
		Connection con=null;
		PreparedStatement ps=null;
		Profile p=null;
		try
		{
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select id,firstname,middlename,lastname,designation,address from profile where id=?");
			ps.setString(1, usr);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p.setId(rs.getString("id"));
				p.setFirstname(rs.getString("firstname"));
				p.setMiddlename(rs.getString("middlename"));
				p.setLastname(rs.getString("lastname"));
				p.setDesignation(rs.getString("designation"));
				p.setAddress(rs.getString("address"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return p;
	}

	@Override
	public Login fetchLoginByUser(String usr) {
		Connection con=null;
		PreparedStatement ps=null;
		Login l=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select id,password,status,usertype from login where id=?");
			ps.setString(1, usr);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				l=new Login();
				l.setId(rs.getString("id"));
				l.setPassword(rs.getString("password"));
				l.setStatus(rs.getInt("status"));
				l.setUsertype(rs.getString("usertype"));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return l;
	}

	@Override
	public int setLoginStatus(Login l) {
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			int status=l.getStatus();
			status+=1;
			String sql="update login set status="+status+" where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, l.getId());
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return i;
	}

}
