package dataParser;

import java.text.ParseException;
import java.util.Date;

public class DataParseRunner {
    public static void main(String[] args) throws ParseException {
        final DataParser parser = new DataParser();
        final String dateString = "2012-01-01";
        final Date dateParsed = parser.parse(dateString);

        class ParsingThread extends Thread{
            @Override
            public void run() {
                try{
                    while (true){
                        Date d = parser.parse(dateString);
                        if (!d.equals(dateParsed)){
                            System.out.println("Expected : " + dateParsed + ", got : " + d);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
        Thread t1 = new ParsingThread();
        Thread t2 = new ParsingThread();
        t1.start(); t2.start();

    }
}
