//$Id$
package com.servlet;

import org.apache.struts2.components.Select;

public class CreateBean 
{
	private String SelectionNumber;
	public static boolean isValid(String SelectionNumber)
	{
		return (SelectionNumber!=null)?true:false;
	}
}
