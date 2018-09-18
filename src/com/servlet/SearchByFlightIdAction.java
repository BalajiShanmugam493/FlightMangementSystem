//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SearchByFlightIdAction extends ActionSupport implements ServletRequestAware
{
	String searchbypassengerflightid;
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
		  	System.out.println("entering execute");
		    searchbypassengerflightid = request.getParameter("searchbypassengerflightid");
			String find = (SearchByFlightIdBean.search("passengers",searchbypassengerflightid));
			if(find!=null)
			{
				System.out.println("find is "+find);
				request.setAttribute("searchresults", find);
			}
			else
			{
				request.setAttribute("searchresults", "No results Found!!!!!");
			}
			return "success";
		}
}
