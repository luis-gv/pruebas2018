package java8curso.lambda.ses11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelApp {

    private List<Integer> numeros;

    public void llenar(){
        numeros = new ArrayList<>();

        for(int i=0; i<10; i++){
            numeros.add(i);
        }
    }

    public void probarStream(){
        numeros.stream().forEach(System.out::println);
    }

    public void probarParalelo(){
        numeros.parallelStream().forEach(System.out::println);
    }

    public static void main(String ...args){
        ParallelApp app = new ParallelApp();

        app.llenar();
        //app.probarStream();
        app.probarParalelo();
    }
}
