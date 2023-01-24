
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class RecuperaCookie
 */
public class RecuperaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecuperaCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] arrayCookies = request.getCookies();
		int longitud = arrayCookies.length;
		PrintWriter out = response.getWriter();
		if (arrayCookies != null && longitud > 0) {
			String nombreCookie = arrayCookies[arrayCookies.length - 1].getName();
			String contenidoCookie = arrayCookies[arrayCookies.length - 1].getValue();
			 out.print("Nombre: <b>" + nombreCookie + "</b>" + " <br />");
			 List <String> separado = Arrays.asList(contenidoCookie.split("|"));
			 
			 out.print("Contenido: ");
			 
			 
		}
	}

}