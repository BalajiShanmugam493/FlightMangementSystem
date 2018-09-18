//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateNewLocationAction extends ActionSupport implements ServletRequestAware
{
	String location;
	String distance;
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
	  public String execute() throws Exception
	  {
			distance = request.getParameter("distance");
			location = request.getParameter("newlocation");
			System.out.println(distance+"  "+location);
			if(CreateNewLocationBean.search("locations", location ,distance))
			{
				return "success";
			}
			else
			{
				return "error";
			}
		}
}
