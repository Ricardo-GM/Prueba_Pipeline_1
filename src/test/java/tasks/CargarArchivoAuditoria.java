package tasks;


import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import util.DataSeguridad;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarArchivoAuditoria implements Task {
    private final String nombreArchivo;

    public CargarArchivoAuditoria(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public static CargarArchivoAuditoria conNombre(String nombreArchivo) {
        return instrumented(CargarArchivoAuditoria.class, nombreArchivo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        //Lista que guardará los datos del archivo .csv
        List<DataSeguridad> datos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(nombreArchivo))) {
            List<String[]> data = reader.readAll();
            for (String[] row : data) {
                String claseDocumental = row[0];
                String categoria = row[1];
                String grupo = row[2];
                datos.add(new DataSeguridad(claseDocumental,categoria,grupo));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo CSV", e);
        }
        actor.remember("datosSeguridad", datos); // Guarda la lista de datos en la memoria del actor
    }
}