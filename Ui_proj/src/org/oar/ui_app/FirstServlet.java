package org.oar.ui_app;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse rep) throws ServletException, IOException 
	{
	 String name=req.getParameter("nm");
	 String place=req.getParameter("pl");
	 PrintWriter out=rep.getWriter();
	 out.println("<html><body bgcolor='green'>"
	 		+ "<h1>Brasil 2018 "+name+" "+place+"</h1>"+"</body></html>");
	 out.flush();
	 out.close();
		
	}

	}


