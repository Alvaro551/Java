
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Valida {
	static boolean Nombre(String nombre) {
		return nombre != null && nombre.length() != 0;
	}
	
	static boolean Clave(String clave) {
		return clave != null && (clave.length() > 5 && clave.length() < 13);
	}
	
	@SuppressWarnings("deprecation")
	static boolean Edad(String date) throws ParseException {
		Date now = new Date();		
		Date dateAsDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		return (now.getYear() - dateAsDate.getYear() >= 18);
	}
	
	static boolean Sexo(String genero) {
		return genero == "Mujer" || genero == "Hombre";
	}	
	
	static boolean Paises(String [] paises) {
		return paises != null;
	}
	
	static boolean Comentario (String comentario) {
		return comentario != null && comentario.length() != 0;
	}
}
