package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opower.Person;
import Jpa.Jpa;

@SuppressWarnings("serial")
@WebServlet(name="listpersonservlet",
urlPatterns={"/listperson"})
public class ListPersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Jpa jpa = new Jpa("mysql_db");
		
		String html = "<HTML><body>";
		
		List<Person> persons = jpa.getPersons();
		for(Person person : persons){
			html += "<p>"+person+"</p>";
		}
		
		html += "</body></HTML>";
				
		PrintWriter p = new PrintWriter(resp.getOutputStream());
		p.print(html);
		p.flush();
		
	}
}


