

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Saludo
 */
public class Saludo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saludo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {out.print("<HTML>" 
				+ "<head><title>Saludo</title></head>" 
				+ "<body>"
				+ "<p>Hola " + request.getParameter("nombre") + "</p>"
				+ "</body>" 
				+ "</HTML>");} 
		finally {out.close();}
		response.setContentType("text/html");
		
	}

}
