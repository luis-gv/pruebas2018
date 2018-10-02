package java8curso.lambda.ses10;

import java.util.Optional;

public class OptionalApp {

    public void probar(String valor){
        System.out.println(valor.contains("mito"));

        Optional optional = Optional.empty();

        optional.get();
    }

    public void orElse(String valor){
        Optional<String> optional = Optional.ofNullable(valor);
        String x = optional.orElse("default");
        System.out.println(x);
    }

    public void orElseThrow(String valor) throws Throwable {
        Optional<String> optional = Optional.ofNullable(valor);
        optional.orElseThrow(NumberFormatException::new);
        System.out.println(optional.get());
    }

    public void isPresent(String valor){
        Optional optional = Optional.ofNullable(valor);
        System.out.println(optional.isPresent());
    }

    public static void main(String args[]) throws Throwable {
        OptionalApp app = new OptionalApp();
        //app.probar(null);

        //app.orElse(null);
        //app.orElse("Luis");

        //app.orElseThrow(null);
        //app.orElseThrow("Ale");

        app.isPresent(null);

    }
}
