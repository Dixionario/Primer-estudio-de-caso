import java.util.Scanner;

// Clase principal
public class AnalisisExpresiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Análisis de Expresiones Aritméticas con Pila ===");
            System.out.println("1. Verificar balanceo de paréntesis");
            System.out.println("2. Mostrar ejemplo paso a paso");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una expresión aritmética: "); // por ejemplo: (a + b) * [c - {d / e}]
                    String expr = scanner.nextLine().trim();
                    if (Pila.estanBalanceados(expr)) {
                        System.out.println("La expresión está correctamente balanceada.");
                    } else {
                        System.out.println("La expresión tiene paréntesis desbalanceados.");
                    }
                    break;

                case 2:
                    String ejemplo = "(a + [b * {c - d}])";
                    System.out.println("\nEjemplo: " + ejemplo);
                    System.out.println("Resultado: " + (Pila.estanBalanceados(ejemplo) ? "Balanceada" : "Desbalanceada"));

                    // Simulación visual del proceso
                    System.out.println("\nSimulación del uso de la pila:");
                    System.out.println("Carácter | Acción     | Pila (tope → fondo)");
                    System.out.println("---------|------------|---------------------");
                    Pila pila = new Pila();
                    for (char c : ejemplo.toCharArray()) {
                        if (c == '(' || c == '[' || c == '{') {
                            pila.push(c);
                            System.out.printf("   %c    | push('%c')  | %s\n", c, c, pila.toString());
                        } else if (c == ')' || c == ']' || c == '}') {
                            pila.pop();
                            System.out.printf("   %c    | pop()      | %s\n", c, pila.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo... ¡Gracias!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
