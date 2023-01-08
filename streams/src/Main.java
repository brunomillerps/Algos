package streams.src;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var names = List.of("João", 
        "Bruno", "Rhiara", "Aykut", "Daniel", "Anan");

        names.stream()
            .filter(name -> name.length() == 4)
            .map(String::toUpperCase)
            .forEach(System.out::println);

    }
}
