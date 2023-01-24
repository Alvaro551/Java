
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class Core
 */
public class Core extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Core() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Conexión a la BD
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");

			// Preparación de sentencia
			String sql = "SELECT * FROM empleados NATURAL JOIN departamentos";
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);

			// Recorremos el resultado para visualizar cada fila
			PrintWriter out = response.getWriter();
			out.print(
					"<html><head></head><body><table border=1px cellpadding=5px cellspacing=0><tr>"
							+ "<th>Id de dept</th>"
							+ "<th>Emp_no</th>"
							+ "<th>Apellido</th>"
							+ "<th>Oficio</th>"
							+ "<th>Dir</th>"
							+ "<th>Fecha_alt</th>"
							+ "<th>Salario</th>"
							+ "<th>Comision</th>"
							+ "<th>Nombre de departamento</th>"
							+ "<th>Localidad</th>"
							+ "</tr>");
			while (resultado.next()) {
				out.print("<tr>");
				out.print("<td>" + resultado.getInt(1) + "</td>");
				out.print("<td>" + resultado.getString(2) + "</td>");
				out.print("<td>" + resultado.getString(3) + "</td>");
				out.print("<td>" + resultado.getString(4) + "</td>");
				out.print("<td>" + resultado.getString(5) + "</td>");
				out.print("<td>" + resultado.getString(6) + "</td>");
				out.print("<td>" + resultado.getFloat(7) + "</td>");
				out.print("<td>" + resultado.getInt(8) + "</td>");
				out.print("<td>" + resultado.getString(9) + "</td>");
				out.print("<td>" + resultado.getString(10) + "</td>");
				out.print("</tr>");
			}
			out.print("</body></html>");

			printResultSet(resultado, out, 0);

			resultado.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printResultSet(ResultSet rs, PrintWriter out, int top) {
		int i, fieldNum, count;
		ResultSetMetaData rsMeta;

		try {
			count = 0;
			rsMeta = rs.getMetaData();
			fieldNum = rsMeta.getColumnCount();
			while (rs.next() && (count < top || top <= 0)) {
				for (i = 0; i < fieldNum; i++)
					out.write(rs.getString(i + 1) + ", ");
				out.write("\n");
				out.flush();
				count++;
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
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
