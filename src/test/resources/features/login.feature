@Login
  Feature: Login

    @IJX1-2
    Scenario Outline: Como usuario, realizo login con distintos tipos de usuario
      Given user carga de manera correcta el archivo CSV
      And  user se encuentra en la pagina de login
      When user inicia sesion con credenciales del usuario "<tipousuario>"
      Then user visualiza el "<mensaje>" correspondiente al tipo de usuario

      Examples:
      |tipousuario|mensaje|
      |valido     |You logged into a secure area!|
      |invalido   |Your username is invalid!|
      |admin      |Your username is invalid!|

    @IJX1-9
    Scenario: Como usuario, puedo entrar al area segura con credenciales validas.
      Given user se encuentra en la pagina de login
      When user intenta iniciar sesion con credencial validas
      Then user visualiza un mensaje de inicio de sesion valida


    @InvalidLogin
    Scenario: Como usuario, no puedo entrar al area segura con credenciales invalidas.
      Given user se encuentra en la pagina de login
      When user intenta iniciar sension con credenciales invalidas
      Then user visualiza un mensaje de inicio de sesion fallido

