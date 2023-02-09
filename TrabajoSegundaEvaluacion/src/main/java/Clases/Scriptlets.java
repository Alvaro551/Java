package Clases;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scriptlets {
	public static String generaArrayCajasChequeo(String nombreControl,
			LinkedHashMap<Integer, String> arrayValoresYEtiquetas, int[] valoresSeleccionados) {
		String salida = "";
		if (valoresSeleccionados != null && valoresSeleccionados.length > 0 ) { // hay alg�n valor seleccionado
			int contadorValoresSeleccionados = 0; // cu�ntos valores seleccionados ya se han recorrido
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				int clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				if ((contadorValoresSeleccionados < valoresSeleccionados.length)
						&& (valoresSeleccionados[contadorValoresSeleccionados] == (clave))) {
					salida += " <div class='inputslabels'> <label>" + valor + "</label><input type=\"checkbox\" name=\"" + nombreControl
							+ "\" value=\"" + clave + "\" checked=\"checked\" /> </div>" + "\n";
					contadorValoresSeleccionados++;
				} else {
					salida += " <div class='inputslabels'> <label>" + valor + "</label><input type=\"checkbox\" name=\"" + nombreControl
							+ "\" value=\"" + clave + "\" /> </div>" + "\n";
				}
			}
		} else {
			Iterator<Integer> iteradorConjuntoClaves = arrayValoresYEtiquetas.keySet().iterator();
			while (iteradorConjuntoClaves.hasNext()) {
				int clave = iteradorConjuntoClaves.next();
				String valor = arrayValoresYEtiquetas.get(clave);
				salida += "<div class='inputslabels'> <label>" + valor + "</label><input type=\"checkbox\" name=\"" + nombreControl + "\" value=\""
						+ clave + "\" /> </div> " + "\n";
			}
		}
		return salida;
	}
}
