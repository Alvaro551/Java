
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Clases.*;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession sesion = request.getSession();

		boolean bandera = false;

		do {

			int contador = (int) sesion.getAttribute("contador");

			String buttonValue = request.getParameter("boton");

			ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) sesion.getAttribute("preguntas");

			if (buttonValue.equals("Avanzar") && contador == 1) {
				String[] lista = (String[]) request.getParameterValues("respuestas" + contador);
				sesion.setAttribute("respuesta1", lista);
				String[] prueba = (String[]) sesion.getAttribute("respuesta1");
				if (prueba == null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta1.jsp");
					dispatcher.forward(request, response);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta2.jsp");
				dispatcher.forward(request, response);
			}

			if (contador == 2) {
				if (buttonValue.equals("Retroceder")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta1.jsp");
					dispatcher.forward(request, response);
				} else {
					String[] lista = (String[]) request.getParameterValues("respuestas" + contador);
					sesion.setAttribute("respuesta2", lista);
					String[] prueba = (String[]) sesion.getAttribute("respuesta2");
					if (prueba == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta2.jsp");
						dispatcher.forward(request, response);
					}
					RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta3.jsp");
					dispatcher.forward(request, response);
				}

			}
			if (contador == 3) {
				if (buttonValue.equals("Retroceder")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta2.jsp");
					dispatcher.forward(request, response);
				} else {
					// ir final
					String[] lista = (String[]) request.getParameterValues("respuestas" + contador);
					sesion.setAttribute("respuesta3", lista);
					bandera = true;
					String[] prueba = (String[]) sesion.getAttribute("respuesta3");
					if (prueba == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta3.jsp");
						dispatcher.forward(request, response);
					}
					puntuación(sesion);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Resultados.jsp");
					dispatcher.forward(request, response);
				}
			}

		} while (bandera == true);

	}

	public Connection conectaBaseDatos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajo", "root", "");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private ArrayList<Pregunta> obtenerPreguntasAleatorias(int cantidad, int index)
			throws SQLException, ClassNotFoundException {
		ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
		for (int i = 0; i < cantidad; i++) {
			try (Connection con = conectaBaseDatos()) {
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM preguntas WHERE id = ?");
				pstmt.setInt(1, index);
				ResultSet randomRecord = pstmt.executeQuery();
				// Procesar el registro aleatorio
				if (randomRecord.next()) {
					// Obtener los valores de las columnas
//					int id = randomRecord.getInt("id");
//					String preguntas = randomRecord.getString("texto");

					listaPreguntas.add(new Pregunta(obtenerRespuestasAleatorias(index), randomRecord.getInt("id"),
							randomRecord.getString("texto")));
					index = obtenerRandom();
				}
			}

		}
		return listaPreguntas;
	}

	private ArrayList<Respuesta> obtenerRespuestasAleatorias(int index) throws SQLException, ClassNotFoundException {
		ArrayList<Respuesta> listaRespuestas = new ArrayList<Respuesta>();
		try (Connection con = conectaBaseDatos()) {
			// Hacer una consulta para seleccionar el registro aleatorio
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM respuestas WHERE id_pregunta = ?");
			pstm.setInt(1, index);
			ResultSet randomRecord2 = pstm.executeQuery();
			while (randomRecord2.next()) {
				listaRespuestas.add(new Respuesta(randomRecord2.getInt("id"), randomRecord2.getInt("id_pregunta"),
						randomRecord2.getString("respuesta"), randomRecord2.getBoolean("Correcta")));

				index++;
			}
		}
		return listaRespuestas;
	}

	private int obtenerRandom() throws SQLException, ClassNotFoundException {
		try (Connection con = conectaBaseDatos()) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM preguntas");
			rs.next();
			int total = rs.getInt(1);
			// Generar un número aleatorio como índice
			Random rand = new Random();
			int index = rand.nextInt(total) + 1;
			return index;

		}

	}

	private double puntuación(HttpSession sesion) {

		ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) sesion.getAttribute("preguntas");

		int[] seleccionados1 = null;
		int[] seleccionados2 = null;
		int[] seleccionados3 = null;

		String[] respuestas1 = (String[]) sesion.getAttribute("respuesta1");
		String[] respuestas2 = (String[]) sesion.getAttribute("respuesta2");
		String[] respuestas3 = (String[]) sesion.getAttribute("respuesta3");

		if (respuestas1 != null) {
			seleccionados1 = new int[respuestas1.length];
			for (int i = 0; i < seleccionados1.length; i++) {
				seleccionados1[i] = Integer.parseInt(respuestas1[i]);
				System.out.print(seleccionados1[i]);
			}
		}
		
		int [] marcados1 = sacarMarcadas(seleccionados1,preguntas,0);

		if (respuestas2 != null) {
			seleccionados2 = new int[respuestas2.length];
			for (int i = 0; i < seleccionados2.length; i++) {
				seleccionados2[i] = Integer.parseInt(respuestas2[i]);
				System.out.print(seleccionados2[i]);
			}
		}
		
		int [] marcados2 = sacarMarcadas(seleccionados2,preguntas,1);

		if (respuestas3 != null) {
			seleccionados3 = new int[respuestas3.length];
			for (int i = 0; i < seleccionados3.length; i++) {
				seleccionados3[i] = Integer.parseInt(respuestas3[i]);
				System.out.print(seleccionados3[i]);
			}
		}
		
		
		int [] marcados3 = sacarMarcadas(seleccionados3,preguntas,2);
		
		
		double nota1 = notaPregunta(marcados1,preguntas,0);
		double nota2 = notaPregunta(marcados2,preguntas,0);
		double nota3 = notaPregunta(marcados3,preguntas,0);
		
		System.out.println(nota1);
		
		

		return 0;
	}

	public int[] sacarMarcadas(int[] seleccionados, ArrayList<Pregunta> preguntas, int pregunta) {

		int[] marcados = new int[seleccionados.length];
		int contador = 0;
		for (int i = 0; i < preguntas.get(pregunta).getRespuestas().size(); i++) {
			if (contador < seleccionados.length && seleccionados[contador] == i) {
				marcados[contador] = seleccionados[contador];
				contador++;
			}
			
		}

		return marcados;
	}
	
	//Recorrer 
	public double notaPregunta(int[] marcada, ArrayList<Pregunta> preguntas,int pregunta) {
		
		double nota = 0;
		int contador = 0;
		for(int i = 0 ; i < preguntas.get(pregunta).getRespuestas().size();i++) {
			if(contador <marcada.length && marcada[contador]==i) {
				if(preguntas.get(pregunta).getRespuestas().get(i).isCorrecta()) {
					nota += 1;
				} else {
					nota -= 0.5;
					//si es multi poner un return y pum 
				}
				contador++;
			}
		}
		
		return nota;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		int index;

		try {

			index = obtenerRandom();

			ArrayList<Pregunta> preguntas = obtenerPreguntasAleatorias(3, index);

			int contador = 1;

			sesion.setAttribute("preguntas", preguntas);
			sesion.setAttribute("contador", contador);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/pregunta1.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

	}

}
