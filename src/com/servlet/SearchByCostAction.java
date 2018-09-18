//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class SearchByCostAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
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
		  	from = request.getParameter("searchbycost_from");
			destination = request.getParameter("searchbycost_destination");
			String find = (SearchByCostBean.findCost(from,destination));
			request.setAttribute("costresults", find);
			return "success";
		}
}
