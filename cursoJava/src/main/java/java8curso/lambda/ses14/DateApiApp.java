package java8curso.lambda.ses14;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class DateApiApp {



    public static void main(String[] args){
        DateApiApp app = new DateApiApp();

        //app.verificar(8);

    /*
        try {
            app.medirTiempo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //app.periodoEntreFechas(8);

        try {
            app.transformar();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    public void verificar(int version){
        if(version == 8){
            LocalDate fecha1 = LocalDate.of(1981,12,8);
            LocalDate fecha2 = LocalDate.now();

            System.out.println(fecha1.toString());
            System.out.println(fecha1.isBefore(fecha2));
            System.out.println(fecha1.isAfter(fecha2));

            LocalTime time1 = LocalTime.now();
            LocalTime time2 = LocalTime.of(21,30,55);

            System.out.println("time1 = " + time1);
            System.out.println(time1.isBefore(time2));
            System.out.println(time2.isAfter(time2));


            LocalDateTime dateTime1 = LocalDateTime.of(1981,12,8,21,30,50);
            LocalDateTime dateTime2 = LocalDateTime.now();

            System.out.println("dateTime1 = " + dateTime1);
            System.out.println(dateTime1.isBefore(dateTime2));
            System.out.println(dateTime1.isAfter(dateTime2));

        }else{
            Calendar fecha1 = new Calendar.Builder().build();
            Calendar fecha2 = new Calendar.Builder().build(); //01-01-1970

            fecha1.set(1981,11,8);

            System.out.println(fecha1.getTime());
            System.out.println(fecha1.after(fecha2));
            System.out.println(fecha2.getTime());
        }

    }

    public void medirTiempo() throws InterruptedException {
        Instant ini = Instant.now();
        Thread.sleep(1500);
        Instant fin = Instant.now();

        System.out.println(Duration.between(ini,fin));
        System.out.println(Duration.between(ini,fin).toMillis());
    }

    private void transformar() throws ParseException {
        String fecha= "08/12/1981";
        DateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaParseada = formater.parse(fecha);
        System.out.println(fechaParseada);

        formater = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(formater.format(fechaParseada));

    }

    private void periodoEntreFechas(int i) {
     LocalDate nacimiento = LocalDate.of(1981,12,8);
     Period periodo = Period.between(nacimiento,LocalDate.now());

     System.out.println(periodo.getYears());

     System.out.println("Han pasado " + periodo.getYears() + " años, "
             + periodo.getMonths() + " meses, "
             + periodo.getDays() + " días" );
    }

}
