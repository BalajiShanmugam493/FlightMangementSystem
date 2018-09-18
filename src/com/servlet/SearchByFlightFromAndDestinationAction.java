//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SearchByFlightFromAndDestinationAction extends ActionSupport implements ServletRequestAware 
{
	String from;
	String destination;
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
			from = request.getParameter("searchbyflightfromanddestination_from");
			destination = request.getParameter("searchbyflightfromanddestination_destination");
			String find = (SearchByFlightFromAndDestinationBean.search("flight",from,destination));
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
