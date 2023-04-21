import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    static Map<Integer, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Digite um número inferior a 9223372036854775807: ");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        calculate(target);
        BigInteger targetBig = BigInteger.valueOf(target);
        System.out.println(cache.containsValue(targetBig));
    }

    public static void calculate(Integer target) {
        BigInteger bigIntegerTarget = BigInteger.valueOf(target);
        int pointer = 5;
        BigInteger result = fibonacci(pointer);

        while (bigIntegerTarget.compareTo(result) == 1) {
            pointer = pointer + 5;
            result = fibonacci(pointer);
        }
    }

    /**
     * Função para calculo da sequência fibonacci.
     * Faz utilização de memoization, portanto Complexidade O(N).
     */
    public static BigInteger fibonacci(Integer n) {
        if (n == 0) return BigInteger.valueOf(0L);
        if (n == 1) return BigInteger.valueOf(1L);

        if (cache.get(n) == null) {
            BigInteger a = fibonacci(n - 1);
            BigInteger b = fibonacci(n - 2);
            cache.put(n, a.add(b));
        }

        return cache.get(n);
    }
}
;