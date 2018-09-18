//$Id$
package com.servlet;
import com.opensymphony.xwork2.ActionSupport;
public class CreateAction extends ActionSupport
{
	String SelectionNumber;
	@Override 
	public String execute() throws Exception 
	{
		System.out.println("entering");
		if(CreateBean.isValid(SelectionNumber))
		{
			if(SelectionNumber.equalsIgnoreCase("1"))
			{
				return "success1";
				
			}
			if(SelectionNumber.equalsIgnoreCase("2"))
			{
				return "success2";
				
			}
			if(SelectionNumber.equalsIgnoreCase("3"))
			{
				return "success3";
				
			}
			if(SelectionNumber.equalsIgnoreCase("4"))
			{
				return "success4";
				
			}
			if(SelectionNumber.equalsIgnoreCase("5"))
			{
				return "success5";
				
			}
			else
			{
				return "error";
				
			}	
		}
		return SelectionNumber;
	}
	
	public String getSelectionNumber()
	{
		return SelectionNumber;
	}
	public void setSelectionNumber(String SelectionNumber)
	{
		this.SelectionNumber = SelectionNumber;
	}
	

}
