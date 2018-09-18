//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateFlightAction extends ActionSupport implements ServletRequestAware
{
	HttpServletRequest request;
	String flightid;
	String newflightid;
	String newfrom;
	String newdestination;
	//String
	public void setServletRequest(HttpServletRequest req)
	{
	    request = req;
	}
	
	public String execute()
	{
		flightid = request.getParameter("flightid");
		newflightid = request.getParameter("newflightid");
		newfrom = request.getParameter("newfrom");
		newdestination = request.getParameter("newdestination");
		if(UpdateFlightBean.update(flightid,newflightid,newfrom,newdestination))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
