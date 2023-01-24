
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// String oculto = "";
			Cookie[] arrayCookies = request.getCookies();
			String mensaje = "";
			if (arrayCookies != null) {
				int i;
				int longitud = arrayCookies.length;
				for (i = 0; i < longitud; i++) {
					if (arrayCookies[i].getName().equals("uid")) {
						mensaje = "Tu cara me suena" + arrayCookies[i].getValue();
						out.print(mensaje);
					}
				}

				if (mensaje.equals("")) {
					mensaje = "No se quién eres pero te recordaré";
					Random rand = new Random();
					int num = rand.nextInt(); // generates a random integer
					String numString = Integer.toString(num); // converts the integer to a string
					Cookie laCookie = new Cookie("uid", numString);
					response.addCookie(laCookie);
					out.print(mensaje);

				}
			} else {
				mensaje = "No se quién eres pero te recordaré";
				Random rand = new Random();
				int num = rand.nextInt(); // generates a random integer
				String numString = Integer.toString(num); // converts the integer to a string
				Cookie laCookie = new Cookie("uid", numString);
				response.addCookie(laCookie);
				out.print(mensaje);

			}

			request.setAttribute("mensaje", mensaje);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vista.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			out.println("Se produce una excepción: ");
			out.println(e.getMessage());
		}
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