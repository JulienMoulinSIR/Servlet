package servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.*;

@SuppressWarnings("serial")
@WebServlet(name="parameters",
urlPatterns={"/parameters"})
public class Parameters extends HttpServlet {
  public void doGet(HttpServletRequest request,
					HttpServletResponse response)
	  throws ServletException, IOException {
	response.setContentType("text/html");

	PrintWriter out = response.getWriter();

	out.println("<html><body>\n" +
				"<h1>Tableau des paramètres</h1>\n" +
				"<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"<tr>\n" +
				"<th>Nom</th><th>Valeur(s)</th>");

	Enumeration<String> NomsParam = request.getParameterNames();

	while(NomsParam.hasMoreElements()) {
	  String NomParam = (String)NomsParam.nextElement();

	  out.println("<tr><td>" + NomParam + "</td>");

	  String ValeurParam = request.getParameter(NomParam);
	  
	  if(ValeurParam == "")
			  out.println("<td>Aucune valeur</td></tr>\n");
	  else 
		  out.println("<td>"+ValeurParam+"</td></tr>\n");
	}  
	  
	out.println("</table>\n</body></html>");  
  }
  
  public void doPost(HttpServletRequest request,
					 HttpServletResponse response)
	  throws ServletException, IOException {	
	doGet(request, response);  
  }
}