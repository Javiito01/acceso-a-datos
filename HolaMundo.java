import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Introduce el segundo numero: ");
        int b = scanner.nextInt();

        System.out.println("Elige la operación (+, -, *, /): ");
        String operacion = scanner.next();

        switch (operacion) {
            case "+":
                System.out.println("Suma: " + (a + b));
                break;
            case "-":
                System.out.println("Resta: " + (a - b));
                break;
            case "*":
                System.out.println("Multiplicación: " + (a * b));
                break;
            case "/":
                if (b != 0) {
                    System.out.println("División: " + (a / b));
                } else {
                    System.out.println("División: No se puede dividir por cero");
                }
                break;
            default:
                System.out.println("Operación no válida");
        }

        scanner.close();
    }
}