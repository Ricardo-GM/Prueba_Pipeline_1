package userinterface;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ConsoleHomePage extends PageObject {

    private static By nombreProducto = By.className("productName");

    private static By itemTreeStorageMain = By.xpath("//span[text()='OS1']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeClases = By.xpath("//span[text()='Clases']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeDocumento = By.xpath("//span[text()='Documento']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");
    private static By itemTreeDocumentoIbk = By.xpath("//span[text()='Documentos IBK']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeAlmacenesObjeto = By.xpath("//span[text()='Almacenes de objetos']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeBarrido = By.xpath("//span[text()='Gestión de barrido']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreePoliticasBarrido = By.xpath("//span[text()='Políticas de barrido']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreePoliticasMigracion = By.xpath("//span[text()='Políticas de migración de contenido']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By tabGeneralMigration = By.xpath("//span[text()='Resultados de barrido']/../preceding-sibling::*/child::span[text()='General']");

    private static By tabStorageMain = By.xpath("//div[@class='ecmAdminTab']//span[@class='dijitObjectStore']");

    private static By itemTreeAdministrativo = By.xpath("//span[text()='Administrativo']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeAlmacenamiento = By.xpath("//span[text()='Almacenamiento']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeAlmacenamientoAvanzado = By.xpath("//span[text()='Almacenamiento avanzado']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemTreeAreaAlmacenamientoAvanzado = By.xpath("//span[text()='Áreas de almacenamiento avanzado']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemOS1_ASA1 = By.xpath("//span[text()='OS1_ASA1']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By itemOS1_ASA2 = By.xpath("//span[text()='OS1_ASA2']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By tabOS1_ASA1 = By.xpath("//div[@data-dojo-attach-point='titleNode,innerDiv,tabContent']//span[text()='OS1_ASA1']");

    private static By tabEstadisticas = By.xpath("//div[@data-dojo-attach-point='titleNode,innerDiv,tabContent']//span[text()='Estadísticas']");

    private static By itemTreeDisenoDeDatos = By.xpath("//span[text()='Diseño de datos']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");

    private static By tabAuditoria = By.xpath("//span[text()='Definiciones de auditoría']");

    private static By labelAuditCrear = By.xpath("//ancestor::td/a[text()='Auditoria de creacion']");

    private static By labelAuditEliminar = By.xpath("//ancestor::td/a[text()='Auditoria  de eliminacion']");
    private static By inputTamanoDisco = By.xpath("//div//*[contains(text(),'Tamaño total de archivo:')]/../../following-sibling::td//div//input[@class='dijitReset dijitInputInner']");


    private static By tabOS1_ASA2 = By.xpath("//div[@data-dojo-attach-point='titleNode,innerDiv,tabContent']//span[text()='OS1_ASA2']");

    private static By tabOS1_ASA1Close = By.xpath("//div[@data-dojo-attach-point='titleNode,innerDiv,tabContent']//span[text()='OS1_ASA1']/../../following-sibling::span");

    private static By profileButtonlocator = By.xpath("//span[@id='ecm_widget_DropDownButton_1']");
    private static By preferenciasUsuarioButtonLocator = By.id("dijit_MenuItem_0_text");
    private static By idiomaAplicacionLocator= By.xpath("//table[@id='ecm_widget_dialog_ChangeLocaleDialog_0_language_locale-field']/tbody[@role='presentation']/tr/td[1]");
    private static By idiomaAplicacionEspañolLocator= By.xpath("//tr[@aria-label='Spanish [es] ']");
    private static By entornoLocalAplicacionLocator = By.xpath("//table[@id='ecm_widget_dialog_ChangeLocaleDialog_0_value_format_locale-field']/tbody[@role='presentation']/tr/td[1]");
    private static By idiomaEspañolEntornoLocalAplicacionLocator = By.xpath("//tr[@aria-label='Spanish [es] ']");
    private static By guardarPreferenciasUsuarioLocator= By.id("ecm_widget_Button_17");


    public static By getItemTreeDocumento() {
        return itemTreeDocumento;
    }
    public static By getItemTreeClases() {
        return itemTreeClases;
    }

    public static By getItemTreeDocumentoIbk() {
        return itemTreeDocumentoIbk;
    }

    public static By getNombreProducto() { return nombreProducto; }

    public static By getItemTreeStorageMain() { return itemTreeStorageMain; }

    public static By getItemTreeAlmacenesObjeto() { return itemTreeAlmacenesObjeto; }

    public static By getItemTreeBarrido() {
        return itemTreeBarrido;
    }

    public static By getItemTreePoliticasBarrido() {
        return itemTreePoliticasBarrido;
    }

    public static By getItemTreePoliticasMigracion() {
        return itemTreePoliticasMigracion;
    }

    private static By labelAuditConsultar = By.xpath("//ancestor::td/a[text()='Auditoria de consulta']");

    private static By labelAuditObtener = By.xpath("//ancestor::td/a[text()='Auditoria por obtener de datos']");

    private static By btnOpcionesClase = By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/div/div/div[5]/div[3]/div[2]/div/div[2]/div[3]/div/div[1]/div[1]");
    public static By getItemTreeDisenoDeDatos() {
        return itemTreeDisenoDeDatos;
    }
    public static By getItemTreeClaseDocumental(String claseDocumental) {
        return By.xpath("//span[text()='" + claseDocumental + "']");
    }
    public static By getItemsMigracionClase(String claseDocumental) {
        return By.xpath("//span[text()='"+claseDocumental+"']/../preceding-sibling::span[@data-dojo-attach-point='expandoNode']");
    }
    public static By getTabAuditoria() {
        return tabAuditoria;
    }
    public static By getLabelAuditEliminar() {
        return labelAuditEliminar;
    }
    public static By getBtnOpcionesClase() {
        return btnOpcionesClase;
    }
    public static By getTabClaseDocumental(String claseDocumental) {
        return By.xpath("//div[@class='ecmAdminTab']/span[@aria-label='" + claseDocumental + "']");
    }
    public static By getHeaderClassMigration(String claseDocumental) {
        return  By.xpath("//span[text()='Política de migración de contenido: "+claseDocumental+"']");
    }
    public static By getTabGeneralMigration() {
        return tabGeneralMigration;
    }
    public static By getConvenioClass(String claseDocumental) {
        return By.xpath("//input[@value='"+claseDocumental+"']");
    }
    public static By getFilterExpression(String claseDocumental) {
        return By.xpath("//textarea[@value=\"DateCreated < NOW() - TimeSpan(1, 'Days')\"]");
    }
    public static By getResultRetention(String claseDocumental) {
        return By.xpath("//input[@value='1'and @type='text']");
    }
    public static By getLabelAuditCrear() {
        return labelAuditCrear;
    }
    public static By getLabelAuditObtener() {
        return labelAuditObtener;
    }
    public static By getLabelAuditConsultar() {
        return labelAuditConsultar;
    }
    public static By getTabStorageMain() { return tabStorageMain; }
    public static By getItemTreeAdministrativo() { return itemTreeAdministrativo; }
    public static By getItemTreeAlmacenamiento() { return itemTreeAlmacenamiento; }
    public static By getItemTreeAlmacenamientoAvanzado() { return itemTreeAlmacenamientoAvanzado; }
    public static By getItemTreeAreaAlmacenamientoAvanzado() { return itemTreeAreaAlmacenamientoAvanzado; }
    public static By getItemOS1_ASA1() { return itemOS1_ASA1; }
    public static By getTabOS1_ASA1() { return tabOS1_ASA1; }
    public static By getTabEstadisticas() { return tabEstadisticas; }
    public static By getInputTamanoDisco() { return inputTamanoDisco; }
    public static By getItemOS1_ASA2() { return itemOS1_ASA2; }
    public static By getTabOS1_ASA2() { return tabOS1_ASA2; }
    public static By getTabOS1_ASA1Close() { return tabOS1_ASA1Close; }

    public static By getProfileButtonlocator() {
        return profileButtonlocator;
    }

    public static By getPreferenciasUsuarioButtonLocator() {
        return preferenciasUsuarioButtonLocator;
    }

    public static By getIdiomaAplicacionLocator() {
        return idiomaAplicacionLocator;
    }

    public static By getIdiomaAplicacionEspañolLocator() {
        return idiomaAplicacionEspañolLocator;
    }

    public static By getEntornoLocalAplicacionLocator() {
        return entornoLocalAplicacionLocator;
    }

    public static By getIdiomaEspañolEntornoLocalAplicacionLocator() {
        return idiomaEspañolEntornoLocalAplicacionLocator;
    }

    public static By getGuardarPreferenciasUsuarioLocator() {
        return guardarPreferenciasUsuarioLocator;
    }
}
