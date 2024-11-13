package baseDatos;

public class DNI {
    private static String dniCliente;

    public static void iniciarSesion(String dni) {
        dniCliente = dni;
    }

    public static String obtenerDniCliente() {
        return dniCliente;
    }


}
