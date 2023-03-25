@Prueba
  Feature: Usar un select

    Scenario: Usar un select en la página de pruebas de Heroku
      Given user se encuentra en la página de select
      When user selecciona un valor
      Then user no aparece ningun error