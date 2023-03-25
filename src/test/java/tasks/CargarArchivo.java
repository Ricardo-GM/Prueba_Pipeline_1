package tasks;

import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import util.Usuario;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarArchivo implements Task {

    private final String nombreArchivo;

    public CargarArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public static CargarArchivo conNombre(String nombreArchivo) {
        return instrumented(CargarArchivo.class, nombreArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //Lista que guardará los datos del archivo .csv
        List<Usuario> usuarios = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(nombreArchivo))) {
            List<String[]> data = reader.readAll();
            for (String[] row : data) {
                String tipoUsuario = row[0];
                String username = row[1];
                String password = row[2];
                usuarios.add(new Usuario(tipoUsuario,username,password));

            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo CSV", e);
        }

        actor.remember("usuarios", usuarios); // Guarda la lista de usuarios en la memoria del actor


    }

}
