package stepdefinitions;

import exceptions.ExceptionHandler;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import tasks.CargarArchivo;
import tasks.VerificarMensajeFlash;
import actions.Navigation.Navigate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import questions.PostLoginMessage;
import tasks.RealizarLogin;
import util.Constantes;
import util.Hooks;
import util.LoginUser;
import util.Usuario;


import java.util.List;




public class LoginSteps {
    /*
    private Scenario scenario;

    @Before
    public void setScenario (Scenario scenario) {
        this.scenario = scenario;
    }
    */

    //List<Usuario> listaUsuarios = new ArrayList<>();

    @Given("{actor} carga de manera correcta el archivo CSV")
    public void carga_de_manera_correcta_el_archivo_CSV(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    CargarArchivo.conNombre("src/test/resources/data/prueba.csv")
            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }


        Hooks.tomarCapturaDePantalla();


    }

    @And("{actor} se encuentra en la pagina de login")
    public void se_encuentra_en_la_pagina_de_login(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    Navigate.toLoginPage()
            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
        Hooks.tomarCapturaDePantalla();
    }



    @When("{actor} inicia sesion con credenciales del usuario {string}")
    public void inicia_sesion_con_credenciales_del_usuario(Actor actor, String tipoUsuario) throws Exception{

        try {
            List<Usuario> usuarios = actor.recall("usuarios");

            for(Usuario usuario : usuarios) {
                if(usuario.getTipoUsuario().equals(tipoUsuario)) {
                    String username = usuario.getUsername();
                    String password = usuario.getPassword();
                    actor.attemptsTo(

                            RealizarLogin.Con(username, password)
                    );
                }
            }



        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }
    @Then("{actor} visualiza un mensaje de inicio de sesion valida")
    public void visualiza_un_mensaje_de_inicio_de_sesion_valida(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    VerificarMensajeFlash.Contiene(PostLoginMessage.Text().answeredBy(actor), Constantes.MENSAJE_LOGIN_CORRECTO )
            );
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }
    @When("{actor} intenta iniciar sension con credenciales invalidas")
    public void intenta_iniciar_sension_con_credenciales_invalidas(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    RealizarLogin.Como(LoginUser.INVALID_USER)
            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }
    @Then("{actor} visualiza un mensaje de inicio de sesion fallido")
    public void visualiza_un_mensaje_de_inicio_de_sesion_fallido(Actor actor) throws Exception {

        try {
            actor.attemptsTo(
                    VerificarMensajeFlash.Contiene(PostLoginMessage.Text().answeredBy(actor), Constantes.MENSAJE_LOGIN_INCORRECTO)

            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }


    }


    @When("{actor} intenta iniciar sesion con credencial validas")
    public void userIntentaIniciarSesionConCredencialValidas(Actor actor) throws Exception {

        try {
            actor.attemptsTo(
                    RealizarLogin.Como(LoginUser.VALID_USER)
            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }

    @Then("{actor} visualiza el {string} correspondiente al tipo de usuario")
    public void userVisualizaElMensajeCorrespondienteAlTipoDeUsuario(Actor actor, String mensaje) throws Exception {

        try {
            actor.attemptsTo(
                    VerificarMensajeFlash.Contiene(PostLoginMessage.Text().answeredBy(actor), mensaje)
            );
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }



}
