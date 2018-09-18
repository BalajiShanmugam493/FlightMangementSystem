//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class SearchByFlightAction extends ActionSupport implements ServletRequestAware 
{
	String flightid;
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
	@Override
	public String execute() throws Exception
	{
		flightid = request.getParameter("searchbyflight");
		String find = (SearchByFlightBean.search("flight",flightid));
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
