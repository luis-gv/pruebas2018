package java8curso.lambda.ses05;

public interface InterfazB {

    default void hablar(){
        System.out.print("Hola desde Hablar - IB");
    }
}
