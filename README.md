# Framework Base Automatización Web -  Serenity - ScreenPlay

Este es un proyecto de Automatización Web Trabajado con Serenity BDD 3.4.2 e implementando el patrón de diseño ScreenPlay.

## 🟢 Pre-requisitos: 🟢
1. Descargar el [JDK de Java](https://www.oracle.com/pe/java/technologies/downloads/).
2. Instalar [Git](https://git-scm.com).
3. Instalar [Apache Maven](https://maven.apache.org).
4. El archivo POM.xml ya está configurado, sólo es necesario usar la herramienta de Maven para cargar el archivo.

## 🏀 Herramientas Utilizadas:

* [Java 19](https://openjdk.java.net/projects/jdk/1/) como lenguaje de programación.
* [Maven](https://maven.apache.org/) como manejador de dependencias.
* [JUnit](https://junit.org/junit5/) como herramienta para realizar pruebas unitarias.
* [Selenium WebDriver](https://www.selenium.dev/) como framework de automatización web.
* [Hamcrest](https://hamcrest.org/) como librería para controlar assertions.
* [Logback](https://logback.qos.ch/) como librería para control de mensajes por consola.
* [Cucumber BDD](https://cucumber.io/) como herramienta para implementar Gherkin y BDD.
* [Serenity BDD](https://serenity-bdd.github.io/) como herramienta para de pruebas basado en BDD (Behavior-Driven Development), así como herramienta de reportería. Esta herramienta implementa a Selenium. Actualmente se utiliza la versión 3.4.2.

## 📃 Estructura del Proyecto:

    .src
     ├── main                   
     ├── test
        ├── java                        
            ├── abilites                    # Source files (alternatively `lib` or `app`)
            ├── actions                     # Automated tests (alternatively `spec` or `tests`)
            ├── assertions                  # Carpeta que contiene la clase que maneja y controla las assertions
            ├── exceptions                  # Carpeta que contiene la clase que maneja y controla las exceptions y errores
            ├── questions                   # Carpeta que contiene las questions utilizadas en el proyecto
            ├── stepdefinitions             # Carpeta que contiene los step definitions utilizados en el proyecto
            ├── tasks                       # Carpeta que contiene las tasks utilizadas en el proyecto
            ├── userinterface               # Carpeta que contiene los localizadores web
            ├── util                        # Carpeta de utilitarios diversos (Constantes, modelos, Hooks, Lógica de actores)
            └── CucumberTestSuite.java      # Punto de inicio de ejecución de proyecto
        └── resources
            ├── data                        # Archivos CSV y otros usados como data de entrada
            ├── features                    # Archivos. feature
            ├── logback-text.xml            # Archivo de configuración de los mensajes por consola
            └── serenity.conf               # Archivo de configuración de Serenity


### 🔬 ️Detalle de Carpetas y archivos
Este proyecto opta por utilizar las herramientas de Serenity BDD que implementan el patrón de diseño ScreenPlay, por lo que existen carpetas para los componentes que se utilizan en este patrón, además de las carpetas correspondientes a la implementación de Cucumber:
1. Carpeta actions (`src/test/java/actions`): Esta carpeta contiene las distintas interacciones de bajo nivel que puede realizar un usuario (actor) sobre la web. Estas acciones se encuentran divididas por funcionalidad.
2. Carpeta tasks (`src/test/java/tasks`): Esta carpeta contiene las distintas tareas que puede realizar un usuario (actor) dentro del proyecto. Estas tareas se encuentran divididas por funcionalidad.
3. Carpeta questions (`src/test/java/questions`): Esta carpeta contiene las distintas preguntas que puede realizar un usuario (actor) para conocer el estado sobre algún elemento web dentro del proyecto. Estas preguntas se encuentran divididas por funcionalidad.
4. Carpeta abilities (`src/test/java/abilities`): Esta carpeta contiene las distintas habilidades que puede tener un usuario (actor). Estas habilidad se encuentran divididas por funcionalidad.
5. Carpeta stepdefinitions (`src/test/java/stepdefinitions`): Esta carpeta contiene los distintos pasos que puede tener un caso de prueba. Estos archivos se encuentran divididos por archivos .feature.
6. Carpeta userinterface (`src/test/java/userinterface`): Esta carpeta contiene los distintos elementos web con los cuales se interactuarán en el proyecto. Existe un archivo por cada página web que se utilizará.
7. Carpeta assertions (`src/test/java/assertions`): Esta carpeta contiene una clase que brinda métodos para realizar distintos tipos de validaciones en nuestro proyecto.
8. Carpeta exceptions (`src/test/java/exceptions`): Esta carpeta contiene una clase que brinda métodos para controlar las excepciones y errores que pueden aparecer en nuestro proyecto.
9. Carpeta util (`src/test/java/util`): Esta carpeta contiene distintos tipos de clases de apoyo para nuestro proyecto, tales como constantes, enums, lógica de creación de actores y Hooks para inicializar y terminar instancias de drivers.
10. Carpeta features (`src/test/resoruces/features`): Esta carpeta contienen los distintos archivos .feature que contienen a su vez la redacción gherkin de los distintos casos de prueba y funcionalidades a probar en nuestro proyecto. Estos archivos .feature se encuentran divididos por funcionalidad.
11. Archivo logback-test.cml: Este archivo contiene la configuración de los mensajes por consola manejador por la dependencia de logback.
12. Archivo serenity.conf: Este archivo contiene la configuración de el proyecto Serenity, donde se establecen el tipo de driver a utilizar, en que acciones se tomarán capturas de pantalla y url's base según ambiente. Actualmente está configurado para trabajar con los navegadores Chrome Y Microsoft Edge.


## 🔰 Como empezar:
En este tópico se detallaran los pasos que se necesitan realizar en caso se requiera añadir una nueva funcionalidad o casos de prueba:
1. Crear un archivo .feature que contenga los pasos de nuestros casos de prueba.
2. Crear un archivo en la carpeta stepdefinitions que implementen los pasos creados en el archivo .feature.
3. Cada tiene que tener la siguiente estructura:
```java
    @Given("{actor} carga de manera correcta el archivo CSV")
    public void carga_de_manera_correcta_el_archivo_CSV(Actor actor) throws Exception {
            //Bloque try-catch para el manejo de errores u excepciones
            try {
            actor.attemptsTo(
            //Código a realizar
            );
            
            }catch (Throwable e) {
            ExceptionHandler.Error(e);
            }
    }
```
4. Dentro de cada paso se podrán utilizar tasks u actions.
5. Las clases actions deben seguir la siguiente estructura:
```java
public class Click {
    public static Performable On(By locator) {
        return net.serenitybdd.screenplay.actions.Click.on(locator);
    }
}
```
6. Las clases tasks deben seguir la siguiente estructura:
```java
public class RealizarLogin implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
    }
    
    public static Performable Como(LoginUser loginUser){
        return Task.where("{0} inicia sesion como " + loginUser,
                EnterText.On(LoginPage.getUsernameInput(), loginUser.username),
                EnterText.On(LoginPage.getPasswordInput(), loginUser.password),
                Click.On(LoginPage.getLoginButton())
        );
    }
}
```

7. Los elementos web con los que se deberán interactuar deben encontrarse en la carpeta userinterface bajo la siguiente estructura:
```java
public class SecurePage extends PageObject {

    private static By flashMessage = By.id("flash");

    public static By getFlashMessage() {
        return flashMessage;
    }
}
```


## 🛠️ Ejecutar el proyecto:

1. Ejecutar el comando `mvn compile` en la ruta del proyecto.
2. Ejecutar el comando `mvn clean verify` en la ruta del proyecto.
3. El proyecto se ejecutará de manera automática.

## 📊 Reportería

* El comando `mvn clean verify` generará un link html donde se podrá visualizar el reporte una vez finalizada la ejecución de las pruebas.
* Los datos que componen el reporte se podrán encontrar en la ruta `target/site/serenity`.