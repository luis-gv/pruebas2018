package java8curso.lambda.ses03;


import java8curso.lambda.Operation;

import java.util.Date;

public class Sintaxis {

    public double probarSintaxis(){
        //Operation operation = (double x, double y) -> (x+y)/2;
        //Operation operation = (double x, double y) -> {return (x+y)/2;};
        Operation operation = (x, y) -> {return (x+y)/2;};
        return operation.calcular(5,2);
    }

    public static void main(String... args){
        Sintaxis sintaxis = new Sintaxis();
        System.out.print( new Date() + " \n " + sintaxis.probarSintaxis() );
    }
}
