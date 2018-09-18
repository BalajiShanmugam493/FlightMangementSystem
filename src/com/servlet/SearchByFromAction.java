//$Id$
package com.servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

public class SearchByFromAction extends ActionSupport implements ServletRequestAware
{
	String from;
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
		  
			from = request.getParameter("searchbyfrom");
			System.out.println("from "+from);
			String find = (SearchByFromBean.search("flight",from));
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
