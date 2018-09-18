//$Id$
package com.servlet;

import com.opensymphony.xwork2.ActionSupport;

public class CreateEntryFlightAction extends ActionSupport
{
	String flightid;
	String fromflight;
	String destinationflight;
	public String execute() 
	{
		if(CreateEntryFlightBean.insertFlight(flightid,fromflight,destinationflight))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	public String getFlightid() 
	{
		return flightid;
	}
	public void setFlightid(String flightid)
	{
		this.flightid = flightid;
	}
	public String getFromflight()
	{
		return fromflight;
	}
	public void setFromflight(String fromflight) 
	{
		this.fromflight = fromflight;
	}
	public String getDestinationflight() 
	{
		return destinationflight;
	}
	public void setDestinationflight(String destinationflight) 
	{
		this.destinationflight = destinationflight;
	}
	
	
}
