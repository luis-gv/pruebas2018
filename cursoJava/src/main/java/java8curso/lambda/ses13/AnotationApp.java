package java8curso.lambda.ses13;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnotationApp {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value() default {};
    }

    @Repeatable(value = Lenguajes.class) //Importante para permitir anotaciones repetidas
    public @interface Lenguaje{
        String value();
    }


    @Lenguajes({@Lenguaje("Java"),
            @Lenguaje("Python")
    })
    public interface LenguajeProgramacion{

    }

    @Lenguaje("Java")
    @Lenguaje("Python")
    public interface LenguajeProgramacionV8{

    }

    public static void main(String[] args){
        AnotationApp app = new AnotationApp();


        Lenguaje[] lenguajeArray = LenguajeProgramacionV8.class.getAnnotationsByType(Lenguaje.class);

        System.out.println("Se tienen " + lenguajeArray.length + " anotaciones en lenguajeArray");


        Lenguajes len = LenguajeProgramacionV8.class.getAnnotation(Lenguajes.class);
        for (Lenguaje elemento: len.value()){
            System.out.println(elemento.value());
        }
    }
}
