
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Jsp
 */
public class HolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			try {
				out.println("<html>");
				out.println("<head><title>Hola, alumno!</title></head>");
				out.println("<body>");
				out.println("<hi>Hola, alumno!</h1>");
				out.println("<p>URI: " + request.getRequestURI() + "</p>");
				out.println("<p>Protocolo: " + request.getProtocol() + "</p>");
				out.println("<p>Ip del cliente: " + request.getRemoteAddr() + "</p>");

				out.println("</body></html>");

			} finally {

			}
			out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
