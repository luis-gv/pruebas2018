package java8curso.lambda.ses07;

@FunctionalInterface
public interface IPersona {

    Persona crear(int id, String nombre);
}
