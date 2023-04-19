package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.DatosSalidaGarantia;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LeerExcel implements Task {


    private final String nombreArchivo;

    public LeerExcel(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public static LeerExcel conNombre(String nombreArchivo) {
        return instrumented(LeerExcel.class, nombreArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //Lista que guardará los datos del archivo .csv
        List<DatosSalidaGarantia> datosSalidaGarantias = new ArrayList<>();
        try {
            File file = new File(nombreArchivo);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Obtener la hoja en el índice 0
            int numRows = sheet.getPhysicalNumberOfRows(); // Obtiene el número de filas en la hoja de cálculo
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String tipoBusqueda = row.getCell(0).getStringCellValue();
                String numeroDocumento = row.getCell(1).getStringCellValue();
                String garantia = row.getCell(2).getStringCellValue();
                String motivo = row.getCell(3).getStringCellValue();
                datosSalidaGarantias.add(new DatosSalidaGarantia(tipoBusqueda,numeroDocumento,garantia,motivo));
            }
            workbook.close();
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo Excel", e);
        }

        actor.remember("datosSalidaGarantias", datosSalidaGarantias); // Guarda la lista datos de salida de garantía


    }

}


