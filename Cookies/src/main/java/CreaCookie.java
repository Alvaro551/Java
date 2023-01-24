
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Servlet implementation class CreaCookie
 */
public class CreaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		Random rand = new Random();
		String aleatorio = String.valueOf(rand.nextInt(1000));

		out.print("<html><head></head><body>");

		Cookie[] listaCookies = request.getCookies();
		boolean boo = false;
		String valor = "";

		if (listaCookies != null) { // si se ha recibido una cookie
			for (int i = 0; i < listaCookies.length; i++) {
				if (listaCookies[i].getName().equals("uid")) {
					boo = true;
					valor = listaCookies[i].getValue() ;
					out.print("<h1>Hola! " + listaCookies[i].getValue() + "</h1>");
				}
			}

			if (!boo) { // si no se ha encontrado la cookie
				Cookie uid = new Cookie("uid", aleatorio);
				response.addCookie(uid);
				out.print("<h1>Hola! " + valor + "</h1>");
			}
		} else { // si no se ha recibido una cookie			
			Cookie uid = new Cookie("uid", aleatorio);
			response.addCookie(uid);
			out.print("<h1>Hola! " + uid.getValue() + "</h1>");
		}

		out.print("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
