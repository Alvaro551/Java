package Clases;

import java.util.ArrayList;

public class Pregunta {
	
	ArrayList<Respuesta> listaRespuestas = new ArrayList<Respuesta>();
	private int id ;
	private String texto;

	public ArrayList<Respuesta> getRespuestas() {
		return listaRespuestas;
	}

	public void setRespuesta(ArrayList<Respuesta> ListaRespuestas) {
		ListaRespuestas = ListaRespuestas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	public void añadirRespuesta(Respuesta respuesta) {
		this.listaRespuestas.add(respuesta);
	}

	public Pregunta(ArrayList<Respuesta> listaRespuestas, int id, String texto) {
		super();
		this.listaRespuestas = listaRespuestas;
		this.id = id;
		this.texto = texto;
	}

	
	
	

	
	
	
}
