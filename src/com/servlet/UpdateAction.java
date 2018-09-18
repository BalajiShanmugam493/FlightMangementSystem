
package com.servlet;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateAction extends ActionSupport implements ServletRequestAware
{
	
	HttpServletRequest request;
	//String
	public void setServletRequest(HttpServletRequest req)
	{
	    request = req;
	}
	public String execute()
	{
		System.out.println(request.getParameter("updatetype"));
		String str = request.getParameter("updatetype");
		System.out.println("str "+str);
		if(str.equals("1"))
		{
			return "success1";
		}
		if(str.equals("2"))
		{
			return "success2";
		}
		if(str.equals("3"))
		{
			return "success3";
		}
		else
		{
			return "error";
		}
	}
}
