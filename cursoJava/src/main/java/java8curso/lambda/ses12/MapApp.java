package java8curso.lambda.ses12;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapApp {

    private Map<Integer, String> map;

    public void poblar(){
        map = new HashMap<>();

        map.put(1, "John");
        map.put(2, "Paul");
        map.put(3, "George");
    }

    public void imprimir_v7(){
        for(Map.Entry<Integer, String> e : map.entrySet()){
            System.out.println(" llave: " + e.getKey() + " - valor: " + e.getValue() );
        }
    }

    public void imprimir_v8(){
        map.forEach( (k,v)-> System.out.println(" llave: " + k + " - valor: " + v ));
    }

    private void imprimir_v8_2() {
        map.entrySet().stream().forEach(System.out::println);
    }

    public void insertarSiAusente(){
        map.putIfAbsent(4,"Ringo");
    }

    public void operarSiPresente(){
        map.computeIfPresent(3, (k,v ) -> k + v);
        System.out.println(map.get(3));
    }

    public void obtenerOrPredeterminado(){
        String valor = map.getOrDefault(5,"valor por defecto");
        System.out.println(valor);
    }


    public void recolectar(){
        Map<Integer,String> mapaRecolectado = map.entrySet().stream()
                .filter( e -> e.getValue().contains("n"))
                .collect(Collectors.toMap(p -> p.getKey(), k->k.getValue()));

        mapaRecolectado.entrySet().stream().forEach(System.out::println);

    }

    public static void main(String ...args){
        MapApp app = new MapApp();
        app.poblar();

        //app.imprimir_v7();
        //app.imprimir_v8();

        app.insertarSiAusente();
        //app.imprimir_v8_2();

        //app.operarSiPresente();

        //app.obtenerOrPredeterminado();

        app.recolectar();

    }

}
