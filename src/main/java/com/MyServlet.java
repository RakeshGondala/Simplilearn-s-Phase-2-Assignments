package com;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	\*/
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("name");
	String password=request.getParameter("password");
	RequestDispatcher rd=null;
	if(username.equalsIgnoreCase("Rakesh") && password.equals("1234")) {
		rd=request.getRequestDispatcher("Sucess");
		rd.forward(request, response);	
	}
	else {
		rd=request.getRequestDispatcher("index.html");
		PrintWriter out=response.getWriter();
		rd.include(request, response);
		out.println("<center> <span style='color:red'>Invalid Login</span></center>");
		
	}
	}
}
