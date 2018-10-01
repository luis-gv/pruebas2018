package java8curso.lambda.ses08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionApp {

    private List<String> lista;

    public void llenarLista(){
        lista = Stream.of("MitoCode","Github","Code").collect(Collectors.toList());
/*
        lista = new ArrayList<>();

        lista.add("MitoCode");
        lista.add("Github");
        lista.add("Code");*/
    }

    public void usarForEach(){

        //Con iteracción clasica
        /*for(String elemento : lista){
            System.out.print(elemento);
        }*/

        //Con lambda
        //lista.forEach(x -> System.out.print(x));

        //Con Metodo por referencia
        lista.forEach(System.out::println);

    }

    public void usarRemoveIf(){

        //ConcurrentModificationException
        /*
        for(String elemento: lista){
            if(elemento.equalsIgnoreCase("Code")){
                lista.remove(elemento);
            }
        }*/

        //Usando Iterator
        /*
        Iterator<String> it = lista.iterator();
        while (it.hasNext()){
            if(it.next().equalsIgnoreCase("MitoCode")){
                it.remove();
            }
        }*/

        lista.removeIf(x -> x.equalsIgnoreCase("Code"));

    }

    public void usarSort(){
        lista.sort((x,y)->x.compareToIgnoreCase(y));
    }

    public static void main(String[] args){
        CollectionApp app = new CollectionApp();
        app.llenarLista();

        //app.usarForEach();

        //app.usarRemoveIf();
        app.usarSort();
        app.usarForEach();
    }

}
