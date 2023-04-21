import java.util.Scanner;

public class StringR {
    public static void main(String[] args) {
        System.out.println("Digite uma string: ");
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        System.out.println(reverse(target));
    }

    // Não é possível reverter uma String com complexidade de tempo inferior a O(n)
    public static String reverse(String n) {
        StringBuilder sb = new StringBuilder();

        for (int i = n.length() - 1; i >= 0; i--) {
            sb.append(n.charAt(i));
        }

        return sb.toString();
    }
}
