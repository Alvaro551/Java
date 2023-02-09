package Clases;

import java.util.ArrayList;

public class Examen {
	
	ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
	
	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	
	//añadir añadir preguntas
	
	public Examen(ArrayList<Pregunta> listaPreguntas) {
		super();
		this.listaPreguntas = listaPreguntas;
	}

	public void AñadirPregunta(Pregunta pregunta) {
		this.listaPreguntas.add(pregunta);
	}
	
	
	
	
	

}
