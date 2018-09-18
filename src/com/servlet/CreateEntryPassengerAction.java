//$Id$
package com.servlet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
public class CreateEntryPassengerAction extends ActionSupport implements ServletRequestAware
{
	Random random = new Random();
	String passengerid = String.format("%04d", random.nextInt(10000));;
	String passengername;
	String flightid_passenger;
	
	HttpServletRequest request;
	HttpServletResponse response;
   
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }
	  public void setServletRequest(HttpServletRequest req)
	  {
	    request = req;
	  }
	public String execute() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//System.out.println(passengerid+" "+passengername+" "+from+" "+destination);
		String str = CreateEntryPassengerBean.insertPassengers(passengerid,passengername,flightid_passenger);
		if( str == "true")
		{
			return "success";
		}
		else if(str== "error")
		{
			return "error";
		}
		else
		{
			ArrayList<String> sourcear = CreateEntryPassengerBean.findSource(flightid_passenger);
			ArrayList<String> destar = CreateEntryPassengerBean.findDestination(flightid_passenger);
			boolean check = false;
			System.out.println(sourcear+"   and   "+destar);
			Break:
			for(int i = 1; i<destar.size();i++)
			{
				for(int j=1;j<sourcear.size();j++)
				{
					String split1[] = sourcear.get(j).split("\\s+");
					String split2[] = destar.get(i).split("\\s+");
					System.out.println(sourcear.get(j)+"   "+destar.get(i));
					if((split1[0].equals(split2[0]) == true) && (split1[1].equals(split2[1]) == false)) 
					{
						check = true;
						System.out.println(split1[0]+" "+split2[0]);
						System.out.println(split1[1]+" "+split2[1]);
						request.setAttribute("result", "Path available through "+ split1[0]);
						
						
						String str_1 = CreateEntryPassengerBean.insertPassengers(passengerid,passengername,split1[1]);
						String str_2 = CreateEntryPassengerBean.insertPassengers(passengerid,passengername,split2[1]);
						if(str_1 == "true" && str_2 == "true")
						{
							System.out.println("success");
							return "failure";
						}
						else
						{
							System.out.println("failure");
							return "failure";
						}
						
							
					}
					if(check == true) break Break;
				}
			}
			if(check == false)
			{
				request.setAttribute("result", "No Tickets Available");
			}
			return "failure";
		}
	}
	public String getPassengername() 
	{
		return passengername;
	}
	public void setPassengername(String passengername) 
	{
		this.passengername = passengername;
	}
	public String getFlightid_passenger()
	{
		return flightid_passenger;
	}
	public void setFlightid_passenger(String flightid_passenger) 
	{
		this.flightid_passenger = flightid_passenger;
	}
}
