package java8curso.lambda.ses09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp {

    private List<String> lista;
    private List<String> numeros;

    public StreamsApp() {
        lista = new ArrayList<>();
        lista.add("Ringo");
        lista.add("John");
        lista.add("Paul");
        lista.add("George");


        numeros = Stream.of("3","1","5").collect(Collectors.toList());
    }

    public void filtrar(){
        //lista.stream().filter(x -> x.startsWith("J")).forEach(System.out::println);
        lista.stream().filter(x -> x.contains("n")).forEach(System.out::println);
    }

    public void ordenar(){
        //lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(x -> System.out.println(x));
        lista.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
    }
    public void transformar(){
        //lista.stream().map(String::toUpperCase).forEach(System.out::println);

        /*for(String x : numeros){
            int num = Integer.parseInt(x) +1;
            System.out.println(num);
        }*/

        numeros.stream().map(x -> Integer.parseInt(x) +1).forEach(System.out::println);
    }

    public void limitar(){
        lista.stream().limit(2).forEach(System.out::println);
    }

    public void contar(){
        System.out.println(lista.stream().count());
    }

   public static void main(String[] args){
        StreamsApp app = new StreamsApp();

       //app.filtrar();

       //app.ordenar();

       //app.transformar();

       //app.limitar();

       app.contar();
    }
}
