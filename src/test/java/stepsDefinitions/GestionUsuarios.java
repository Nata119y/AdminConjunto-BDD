package stepsDefinitions;

import interaction.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.DatosUsuario;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import question.ElementoPresente;
import question.TextoDe;
import task.CrearUsuarioTask;
import task.IniciarSesionTask;
import userInterface.UsuariosUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class GestionUsuarios {

    private static final String CLAVE = "ClaveBdd#2026Prueba";
    private static final String CORREO_ADMIN = "admin.bdd.adminconjunto@gmail.com";
    private static final String CORREO_RESIDENTE = "residente.bdd.adminconjunto@gmail.com";

    private Actor actorUsuarios;

    @Managed
    WebDriver driverUsuarios;

    @Before
    public void prepararActorUsuarios() {
        actorUsuarios = Actor.named("Administrador de usuarios").can(BrowseTheWeb.with(driverUsuarios));
    }

    @Given("El administrador de usuarios inicia sesion en el sistema")
    public void elAdministradorDeUsuariosIniciaSesionEnElSistema() {
        actorUsuarios.attemptsTo(
                NavigateTo.login(),
                IniciarSesionTask.como(CORREO_ADMIN, CLAVE),
                NavigateTo.usuarios());
    }

    @Given("El residente inicia sesion para probar usuarios")
    public void elResidenteIniciaSesionParaProbarUsuarios() {
        actorUsuarios.attemptsTo(
                NavigateTo.login(),
                IniciarSesionTask.como(CORREO_RESIDENTE, CLAVE));
    }

    @When("Crea el usuario {string} con documento {string} correo {string} y rol {string}")
    public void creaElUsuario(String nombre, String documento, String correo, String rol) {
        actorUsuarios.attemptsTo(CrearUsuarioTask.con(new DatosUsuario(nombre, documento, correo, rol)));
    }

    @When("Intenta crear un usuario con documento {string} correo {string} y rol {string}")
    public void intentaCrearUnUsuarioConDocumento(String documento, String correo, String rol) {
        actorUsuarios.attemptsTo(CrearUsuarioTask.con(new DatosUsuario("Usuario Duplicado", documento, correo, rol)));
    }

    @When("Intenta ingresar al modulo de usuarios")
    public void intentaIngresarAlModuloDeUsuarios() {
        actorUsuarios.attemptsTo(NavigateTo.usuarios());
    }

    @Then("Se muestra el mensaje de usuarios {string}")
    public void seMuestraElMensajeDeUsuarios(String mensaje) {
        actorUsuarios.attemptsTo(
                WaitUntil.the(UsuariosUI.LBL_MENSAJE_EXITO, isVisible()).forNoMoreThan(15).seconds());
        actorUsuarios.should(
                seeThat("el mensaje de exito", TextoDe.elemento(UsuariosUI.LBL_MENSAJE_EXITO), containsString(mensaje)));
    }

    @Then("La lista muestra al usuario con correo {string} y rol {string}")
    public void laListaMuestraAlUsuarioConCorreoYRol(String correo, String rol) {
        actorUsuarios.should(
                seeThat("la fila del usuario existe", ElementoPresente.en(UsuariosUI.filaDelUsuario(correo))),
                seeThat("el rol en la fila", TextoDe.elemento(UsuariosUI.filaDelUsuario(correo)), containsString(rol)));
    }

    @Then("Se rechaza el registro con el mensaje {string}")
    public void seRechazaElRegistroConElMensaje(String mensaje) {
        actorUsuarios.attemptsTo(
                WaitUntil.the(UsuariosUI.mensajeConTexto(mensaje), isPresent()).forNoMoreThan(15).seconds());
        actorUsuarios.should(
                seeThat("el mensaje de rechazo", ElementoPresente.en(UsuariosUI.mensajeConTexto(mensaje))));
    }

    @Then("El sistema deniega el acceso con el mensaje {string}")
    public void elSistemaDenegaElAccesoConElMensaje(String mensaje) {
        actorUsuarios.should(
                seeThat("el mensaje de acceso denegado", ElementoPresente.en(UsuariosUI.mensajeConTexto(mensaje))));
    }
}