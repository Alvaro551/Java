import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HolaMundoServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
// Establece el tipo MIME del mensaje de respuesta
		response.setContentType("text/html");
// Crea un flujo de salida para escribir la respuesta a la peticion del cliente
		PrintWriter out = response.getWriter();
// Escribe el mensaje de respuesta en una p´agina html
		try {
			out.println("<html>");
			out.println("<head><title>Hola Mundo</title></head>");
			out.println("<body>");
			out.println("<h1>Hola Mundo</h1>"); // dice hola
// Muestra informaci´on de la petici´on del cliente
			out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
			out.println("<p>Protocolo: " + request.getProtocol() + "</p>");
			out.println("<p>Dirección remota: " + request.getRemoteAddr() + "</p>");
// Genera un n´umero aleatorio para cada petici´on
			out.println("<p>Número aleatorio: <strong>" + Math.random() + "</strong></p>");
			out.println("</body></html>");
		} finally {
			out.close(); // Cierra el flujo de salida
		}
	}
}