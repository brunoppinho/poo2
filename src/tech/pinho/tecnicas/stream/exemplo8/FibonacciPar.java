package tech.pinho.tecnicas.stream.exemplo8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciPar {

    public static void main(String[] args) {
        List<Long> fibonacci = Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(100)
                .map(f -> f[0])
                .collect(Collectors.toList());

        List<Long> pares = fibonacci.stream()
                .limit(20)
                .collect(Collectors.toList());

        Map<Boolean, List<Long>> agrupados = pares.stream()
                .collect(Collectors.partitioningBy(n -> (n % 2 == 0)));

        System.out.println("Primeiros 20 números de Fibonacci divisíveis por 2:");
        System.out.println(pares);

        System.out.println("\nAgrupados com groupingBy:");
        System.out.println(agrupados);;
    }
}
