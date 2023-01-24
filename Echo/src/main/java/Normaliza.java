import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Normaliza {
	
	@SuppressWarnings("deprecation")
	static Date Fecha(String fecha) throws ParseException {
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
		return date;
	}
//	
//	static String modifyDateLayout(String inputDate) throws ParseException{
//	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
//	    return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
//	}
}
