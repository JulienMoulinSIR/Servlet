package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jpa.Jpa;
import opower.Person;

@SuppressWarnings("serial")
@WebServlet(name="addpersonservlet",
urlPatterns={"/person"})
public class AddPersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name");
		 String firstName = req.getParameter("firstName");
		 char genre = req.getParameter("genre").charAt(0);
		 String mail = req.getParameter("mail");
		 String birthDay = req.getParameter("birthDay");
		 
		 Jpa jpa = new Jpa("mysql_db");
		 jpa.persistData(new Person(name,firstName,genre,mail,birthDay));
		 
		 resp.sendRedirect("/listperson");
		
	}	
}


