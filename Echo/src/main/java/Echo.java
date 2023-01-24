
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Echo
 */
@WebServlet("/Echo")
@MultipartConfig(location = "C:\\Uploads", maxFileSize = 10485760L)
public class Echo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Echo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		String sexo = request.getParameter("sexo");
		String date = request.getParameter("fecha");
		String [] select1 = request.getParameterValues("select1");
		String comentario = request.getParameter("comentario");
		String errors = "";

		if (!Valida.Nombre(nombre)) {
			errors += "El nombre es incorrecto, ";
		}
		if (!Valida.Clave(clave)) {
			errors += " la clave es incorrecta, ";
		}
		if (!Valida.Sexo(sexo)) {
			errors += " sexo no indicado, ";
		}
		
		if (!Valida.Paises(select1)) {
			errors += " país no seleccionado,";
		}

		if (!Valida.Comentario(comentario)) {
			errors += " comentario no añadido";
		}
		request.setAttribute("nombre", nombre);
		request.setAttribute("clave", clave);
		request.setAttribute("sexo", sexo);
		request.setAttribute("date", date);
		request.setAttribute("select1", select1);
		request.setAttribute("errors", errors);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarInputs.jsp");
		dispatcher.forward(request, response);
	}

}
