package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirExcel implements Task {

    private final String nombreArchivo;
    private final int numeroFila;

    public EscribirExcel(String nombreArchivo, int numeroFila) {
        this.nombreArchivo = nombreArchivo;
        this.numeroFila = numeroFila;
    }

    public static EscribirExcel conNombre(String nombreArchivo, int numeroFila) {
        return instrumented(EscribirExcel.class, nombreArchivo, numeroFila);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            File file = new File(nombreArchivo);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Obtener la hoja en el índice 0

            for(Row row : sheet) {
                 if(row.getRowNum() == numeroFila) {
                    Cell cell = row.createCell(4);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue("Creado");
                }
            }

            FileOutputStream outputStream = new FileOutputStream(nombreArchivo);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (Exception e) {
            throw new RuntimeException("Error al escribir el archivo Excel", e);
        }
    }



}
