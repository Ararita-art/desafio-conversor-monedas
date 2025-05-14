import java.util.Scanner;

public class CambiaDivisas {
    public static void cambiarDivisas(String divisaVenta, String divisaCompra,
                                      ConsultaDivisas consultaDivisas, Scanner scanner) {
        try {
            System.out.println("\n=== Conversión de " + divisaVenta + " a " + divisaCompra + " ===");

            Divisas divisas = consultaDivisas.solicitaDivisas(divisaVenta, divisaCompra);
            System.out.println(divisas);

            System.out.printf("Ingrese la cantidad de %s que desee cambiar: \n", divisaVenta);
            double cantidad = Double.parseDouble(scanner.nextLine());

            if (cantidad <= 0) {
                System.out.println("Se produjo un error; la cantidad debe ser mayor que cero.");
                return;
            }

            double resultado = cantidad * divisas.conversion_rate();
            System.out.printf("\nResultado: %.2f %s = %.2f %s%n",
                    cantidad, divisaVenta, resultado, divisaCompra);

        } catch (NumberFormatException e) {
            System.out.println("Se produjo un error; por favor ingrese una cantidad numérica.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}