package Clases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import Clases.*;

public class Datos {

	public static LinkedHashMap<Integer, String> hacerMapa(ArrayList<Pregunta> preguntas, int numeroPregunta) {

		LinkedHashMap<Integer, String> arrayRespuestas = new LinkedHashMap<Integer, String>() {
			{

				for (int i = 0; i < preguntas.get(numeroPregunta).getRespuestas().size(); i++) {
					put(i, preguntas.get(numeroPregunta).getRespuestas().get(i).getRespuesta());
					
				}

			}

		};

		return arrayRespuestas;

	}

}
