package licence.spin.ba.Licence.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Date convertStringToDate(final String str){
        try{
            return DATE_FORMAT.parse(str);
        } catch(Exception ex){
            //TODO: Log exception
            return null;
        }
    }

    public static String convertDateToString(final Date date){
        try{
            return DATE_FORMAT.format(date);
        } catch(Exception ex){
            //TODO: Log exception
            return null;
        }
    }

}
