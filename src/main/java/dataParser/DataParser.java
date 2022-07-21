package dataParser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParser {
    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Date parse(String s) throws ParseException{
        return format.parse(s);
    }


}
