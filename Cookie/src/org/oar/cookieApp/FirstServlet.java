package org.oar.cookieApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fs")
public class FirstServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
 String name=req.getParameter("nm");
 Cookie ck=new Cookie("nmg",name);
 ck.setMaxAge(-1);
 resp.addCookie(ck);
 PrintWriter out=resp.getWriter();
 out.print("<html><body>"+"<form action='ss'>"+"<input type='submit' value='NextServlet'>"+"</form>" + 
 		"</body>" + 
 		"</html>");
 out.flush();
 out.close();
}
}
