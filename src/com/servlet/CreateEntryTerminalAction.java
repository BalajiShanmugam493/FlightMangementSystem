//$Id$
package com.servlet;

import com.opensymphony.xwork2.ActionSupport;

public class CreateEntryTerminalAction extends ActionSupport 
{
	String terminaltype;
	String flightid_terminal;
	String location;
	public String execute()
	{
		if(CreateEntryTerminalBean.insertTerminal(terminaltype,flightid_terminal,location))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	public String getTerminaltype() 
	{
		return terminaltype;
	}
	public void setTerminaltype(String terminaltype)
	{
		this.terminaltype = terminaltype;
	}
	public String getFlightid_terminal() 
	{
		return flightid_terminal;
	}
	public void setFlightid_terminal(String flightid_terminal) 
	{
		this.flightid_terminal = flightid_terminal;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	
	
}
