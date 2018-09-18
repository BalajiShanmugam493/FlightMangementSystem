//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SearchByPassengerIdAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	String searchbypassengerid;
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
		    searchbypassengerid = request.getParameter("searchbypassengerid");
			String find = (SearchByPassengerIdBean.search("passengers",searchbypassengerid));
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
