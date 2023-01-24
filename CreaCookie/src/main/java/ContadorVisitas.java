
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
 * Servlet implementation class ContadorVisitas
 */
public class ContadorVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContadorVisitas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		Cookie viewCountCookie = null; // Valor por defecto de la cookie 

		if (cookies != null) { // Si está definida 
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("view_count")) {
		            viewCountCookie = cookie; // Trae el valor de vuelta
		        }
		    }
		}

		if (viewCountCookie == null) { // Si no se ha enviado
		    viewCountCookie = new Cookie("view_count", "1"); // Define la cookie
		} else { // Si se ha enviado
		    int viewCount = Integer.parseInt(viewCountCookie.getValue()) + 1; // Obtén el valor y súmale 1
		    viewCountCookie.setValue(Integer.toString(viewCount)); // Establece el nuevo valor de la cookie 
		}
		
		// Añadir la cookie con el valor correspondiente
		response.addCookie(viewCountCookie);
		
		// Enviar a la vista
		request.setAttribute("mensaje", viewCountCookie);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contadorVisitas.jsp");	
		dispatcher.forward(request, response);
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
