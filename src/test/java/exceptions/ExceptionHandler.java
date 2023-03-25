package exceptions;

public class ExceptionHandler {

    public static void Error(Throwable e) throws Exception {
        if (e instanceof AssertionError) {
            String mensajeError = "Se ocasionó un error sobre una Assertion (comparación): "+e.getMessage();
            throw new Exception(mensajeError, new Exception(mensajeError, e));
        }

        if (e instanceof Exception) {
            String mensajeError = "Excepción generada: " + e.getMessage();
            throw new Exception(mensajeError, new Exception(mensajeError, e));
        }

    }
}
