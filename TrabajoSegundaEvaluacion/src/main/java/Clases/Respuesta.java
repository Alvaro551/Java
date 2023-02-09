package Clases;

public class Respuesta {
	
	private int id;
	private int id_pregunta;
	private String respuesta;
	private boolean Correcta;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isCorrecta() {
		return Correcta;
	}

	public void setCorrecta(boolean correcta) {
		Correcta = correcta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	public int getId_respuesta() {
		return id_pregunta;
	}

	public void setId_respuesta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	
	

	public Respuesta(int id, int id_pregunta, String respuesta, boolean correcta) {
		super();
		this.id = id;
		this.id_pregunta = id_pregunta;
		this.respuesta = respuesta;
		Correcta = correcta;
	}

	

	

	
	
	
}
