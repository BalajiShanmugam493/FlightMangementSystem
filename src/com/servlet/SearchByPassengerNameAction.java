//$Id$
package com.servlet;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

public class SearchByPassengerNameAction extends ActionSupport implements ServletRequestAware
{
	String searchbypassengername;
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
		    searchbypassengername = request.getParameter("searchbypassengername");
			String find = (SearchByPassengerNameBean.search("passengers",searchbypassengername));
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
