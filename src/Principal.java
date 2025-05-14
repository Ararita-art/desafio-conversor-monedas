import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConsultaDivisas consultaDivisas = new ConsultaDivisas();

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("""
                \n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                
                Estimado cliente, ¡bienvenido a nuestro servicio de cambio de divisas!
                Seleccione la opción de cambio que quiere realizar:
                
                1. Dólar a Peso Argentino
                2. Peso Argentino a Dólar
                3. Dólar a Real Brasileño
                4. Real Brasileño a Dólar
                5. Dólar a Peso Colombiano
                6. Peso Colombiano a Dólar
                7. Dólar a Peso Mexicano
                8. Peso Mexicano a Dólar
                9. Salir
                
                &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Se produjo un error; por favor ingrese un número entero.");
                opcion = 0;
            }
        } while (opcion != 9);
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> CambiaDivisas.cambiarDivisas("USD", "ARS", consultaDivisas, scanner);
            case 2 -> CambiaDivisas.cambiarDivisas("ARS", "USD", consultaDivisas, scanner);
            case 3 -> CambiaDivisas.cambiarDivisas("USD", "BRL", consultaDivisas, scanner);
            case 4 -> CambiaDivisas.cambiarDivisas("BRL", "USD", consultaDivisas, scanner);
            case 5 -> CambiaDivisas.cambiarDivisas("USD", "COP", consultaDivisas, scanner);
            case 6 -> CambiaDivisas.cambiarDivisas("COP", "USD", consultaDivisas, scanner);
            case 7 -> CambiaDivisas.cambiarDivisas("USD", "MXN", consultaDivisas, scanner);
            case 8 -> CambiaDivisas.cambiarDivisas("MXN", "USD", consultaDivisas, scanner);
            case 9 -> System.out.println("Transacción finalizada, gracias por utilizar nuestro servicio.");
            default -> System.out.println("Se produjo un error; por favor ingrese número de opción del menú.");
        }
    }
}