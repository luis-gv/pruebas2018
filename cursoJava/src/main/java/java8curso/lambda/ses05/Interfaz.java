package java8curso.lambda.ses05;

public interface Interfaz {

    void caminar();

    default void hablar(){
        System.out.print("Hola desde Hablar");
    }
}
