@Auditoria
Feature: Validation Auditor

  @Auditoria-Scenario
  Scenario Outline: Validar configuracion de auditoria.
    Given user carga el archivo CSV para validar las opciones de seguridad
    Given user ha iniciado sesion correctamente
    And user ingresa al Consola Administrativa
    And user selecciona idioma spanish en la aplicacion Navigator
    #And Juan en la pagina principal de IBM Administrative Console for Content Platform Engine
    When user despliega la opcion de Almacenes de Objetos
    And user selecciono la opcion OS1
    Then user visualiza la pantalla principal de Almacen de objetos OS1
    And user despliega la opcion Diseno de Datos
    And user despliega la opcion Clases
    And user despliega la opcion Documentos
    And user despliega la opcion Documentos IBK
    Then user verificar que exista la "<claseDocumental>" correspondiente
    And user seleccionar la "<claseDocumental>" correspondiente
    Then user visualiza la pantalla con informacion de la "<claseDocumental>"
    And user selecciona la pestaña de Definiciones de Auditoria
    Then user visualiza las opciones correspondientes de auditoria
    Examples:
      |claseDocumental|
      |Expediente de Convenios|
      |Afiliacion de LPDP        |
      |Boleta de Deposito        |