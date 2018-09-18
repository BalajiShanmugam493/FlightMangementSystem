//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePassengerAction extends ActionSupport implements ServletRequestAware
{
	HttpServletRequest request;
	String passengerid;
	String newpassengername;
	String newflightid;
	//String
	public void setServletRequest(HttpServletRequest req)
	{
	    request = req;
	}
	
	public String execute()
	{
		passengerid = request.getParameter("passengerid");
		newpassengername = request.getParameter("newpassengername");
		newflightid = request.getParameter("newflightid");
		if(UpdatePassengerBean.update(passengerid,newpassengername,newflightid))
		{
			
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
