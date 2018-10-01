package java8curso.lambda.ses07;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {

    public static void referenciarMetodoStatic(){
        System.out.print("Método Referido static");
    }

    public void operar(){
        //Operacion op = () -> MeRefApp.referenciarMetodoStatic();
        Operacion op = MeRefApp::referenciarMetodoStatic;
        op.saludar();
    }

    public void referenciarMetodoIntanciaObjArbitrario(){
        String[] nombres = {"Mito","Code" ,"Jaime"};

        /* 1.-
        Arrays.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        */

        //2.-
        //Arrays.sort(nombres,(s1,s2)->s1.compareToIgnoreCase(s2));

        //3.-
        Arrays.sort(nombres,String::compareTo);

        System.out.print(Arrays.toString(nombres));
    }

    public void referenciarMetodoInstanciaObjParticular(){
        System.out.print("Metodo referido instncia de un Objeto en particular");
    }

    public void referenciarConstructor(){
        /*
        IPersona iper = new IPersona() {
            @Override
            public Persona crear(int id, String nombre) {
                return new Persona(id,nombre);
            }
        };
        Persona per =  iper.crear(1,"luis");
        */

        /*
        IPersona iper2 = (x,y) -> (new Persona(x,y));
        Persona per = iper2.crear(1,"luis");
        */

        IPersona iper3 = Persona::new;
        Persona per = iper3.crear(1,"luis");

        System.out.print(per.getId() + " - " + per.getNombre());
    }

    public static void main(String[] args){
        MeRefApp app = new MeRefApp();
        //1app.operar();

        //2app.referenciarMetodoIntanciaObjArbitrario();

        //3
        //Operacion op = app::referenciarMetodoInstanciaObjParticular;
        //op.saludar();

        //4
        app.referenciarConstructor();

    }
}
