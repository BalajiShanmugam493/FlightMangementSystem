package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchByCostBean {
	
	static int cost = 0;
	static int row = 0;
	static int[][] matrix ;
	static ArrayList<String> arr = new ArrayList<String>();
	static int vertices = 0;
	public static void determineMatrix()
	{
		String locationname = null ;
		String distance = null ;
		int count = 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select * from locations";
			ResultSet rs = st.executeQuery(myStatement);
			while(rs.next())
			{
				locationname = rs.getString("locationname");
				distance = rs.getString("distance");
				System.out.println("location name:"+locationname+" distance:"+distance);
				arr.add(locationname);
				String[] splitted = distance.split("\\s+");
				System.out.println("The length is "+splitted.length);
				if(count == 0)
				{
					count++;
					matrix = new int[splitted.length][splitted.length]; 
					vertices = splitted.length;
				}
				for(int col = 0 ; col < splitted.length;col ++)
				{
					matrix[row][col] = Integer.parseInt(splitted[col]);
				}
				row++;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println();
		}
		
	}
	
	public static String findCost(String from, String destination) 
	{
		determineMatrix();
		printMatrix();
		System.out.println("from : "+from+" dest:"+destination);
		String str = "0";
		if(from.equalsIgnoreCase(destination)) return str;
		int i=0;
		for(i=0;i<arr.size();i++)
		{
			if(arr.get(i).equalsIgnoreCase(from)) break;
		}
		getMinimumDistance(i,from,destination);
		
		return Integer.toString(cost * 1000);
	}
	
	private static void printMatrix() 
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
	}

	
	public static void getMinimumDistance(int sourceVertex,String from,String destination)
	{
        boolean[] visited = new boolean[vertices];
        int [] distance = new int[vertices];
        int INFINITY = Integer.MAX_VALUE;
        for (int i = 0; i <vertices ; i++)
        {
            distance[i] = INFINITY;
        }
        distance[sourceVertex] = 0;
        for (int i = 0; i <vertices ; i++) 
        {
            int vertex_U = getMinimumVertex(visited, distance);
            visited[vertex_U] = true;
            for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) 
            {          
                if(matrix[vertex_U][vertex_V]>0)
                {
                    if(visited[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY)
                    {
                        int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                        if(newKey<distance[vertex_V])
                            distance[vertex_V] = newKey;
                    }
                }
            }
        } 
        findShortestpath(sourceVertex, distance,from,destination);
    }
	
	
	static int getMinimumVertex(boolean [] visited, int [] distance)
	{
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i <vertices ; i++) 
        {
            if(visited[i]==false && minKey>distance[i])
            {
                minKey = distance[i];
                vertex = i;
            }
        }
        return vertex;
    }
	
	
	public static void findShortestpath(int sourceVertex, int [] key,String from,String destination)
	{
        for (int i = 0; i <vertices ; i++) 
        {
        	if(arr.get(i).equalsIgnoreCase(destination))
        	{
        		System.out.println("Source Vertex: "+ from +"   "+ sourceVertex + " to vertex " +   + i +" distance: "+arr.get(i)+"  "+ key[i]);
        		cost = key[i];
        	}
        }
    }

}
