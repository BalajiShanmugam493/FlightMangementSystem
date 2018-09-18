//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateNewLocationBean 
{

	public static boolean search(String table, String location, String distance) 
	{
		
		String arr[] = distance.split("\\s+");
		//finding the number of columns
		int num = 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select count(*) as total from locations";
			ResultSet rs = st.executeQuery(myStatement);
			
			while(rs.next())
			{
				num = (rs.getInt(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		
		System.out.println("num is "+num);
		
		for(int i=0;i < num;i++)
		{
			String dis = null;
			String locname = null;
			
			//getting the distance
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select * from `locations` limit "+i+",1";
				System.out.println(myStatement);
				ResultSet rs = st.executeQuery(myStatement);
				while(rs.next())
				{
					locname = rs.getString("locationname");
					dis = rs.getString("distance");
				}
				System.out.println(dis);
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
			dis = dis +" "+arr[i];
			
			//updating the distance
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "update locations set `distance`='"+dis+"' where locationname = '"+locname+"'";
				System.out.println(myStatement);
				Statement statement= con.createStatement();
				statement.executeUpdate(myStatement);
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}
		
		
		//inserting the new location into the table locations
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "insert into locations(`locationname`,`distance`) values (?,?)";
			PreparedStatement statement= con.prepareStatement(myStatement );
			statement.setString(1,location);
			statement.setString(2,distance);
			statement.executeUpdate();
			con.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return true;
	}

}
