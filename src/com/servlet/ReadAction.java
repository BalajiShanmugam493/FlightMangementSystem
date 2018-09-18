//$Id$
package com.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

public class ReadAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	String readtype;
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
	
	  
	public String getReadtype() 
	{
		return readtype;
	}
	public void setReadtype(String readtype) 
	{
		this.readtype = readtype;
	}
	
	
	@Override
	public String execute(){
		System.out.print("entering action");
		Object str = ReadBean.readDetails(readtype);
		if(str!=null) {
			request.setAttribute("details", str);
			return "success";
		}
		else return "error";
	}
}
