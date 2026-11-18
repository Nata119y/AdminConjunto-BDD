package stepsDefinitions;

import interaction.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.DatosInmueble;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import question.ElementoPresente;
import question.FormularioValido;
import question.TextoDe;
import task.BuscarInmuebleTask;
import task.GuardarInmuebleVacioTask;
import task.IniciarSesionTask;
import task.RegistrarInmuebleTask;
import userInterface.InmueblesUI;
import question.ElementoVisible;
import question.FilasVisibles;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GestionInmuebles {

    private static final String CORREO_ADMIN = "admin.bdd.adminconjunto@gmail.com";
    private static final String CLAVE = "ClaveBdd#2026Prueba";

    private Actor testActor;

    @Managed
    WebDriver driver;

    @Before
    public void setStage() {
        testActor = Actor.named("Administrador").can(BrowseTheWeb.with(driver));
    }

    @Given("El administrador ingresa al sistema")
    public void elAdministradorIngresaAlSistema() {
        testActor.attemptsTo(
                NavigateTo.login(),
                IniciarSesionTask.como(CORREO_ADMIN, CLAVE),
                NavigateTo.inmuebles());
    }

    @When("Registra el inmueble torre {string} apartamento {string} con area {string} y propietario con cedula {string}")
    public void registraElInmueble(String torre, String apto, String area, String cedula) {
        testActor.attemptsTo(RegistrarInmuebleTask.con(new DatosInmueble(torre, apto, area, cedula)));
    }

    @When("Ingresa al modulo de inmuebles")
    public void ingresaAlModuloDeInmuebles() {
        testActor.attemptsTo(NavigateTo.inmuebles());
    }

    @When("Busca el apartamento {string}")
    public void buscaElApartamento(String apartamento) {
        testActor.attemptsTo(BuscarInmuebleTask.conApartamento(apartamento));
    }

    @When("Intenta guardar un inmueble con los campos obligatorios vacios")
    public void intentaGuardarUnInmuebleVacio() {
        testActor.attemptsTo(GuardarInmuebleVacioTask.sinDatos());
    }

    @Then("Se muestra el mensaje {string}")
    public void seMuestraElMensaje(String mensaje) {
        testActor.should(
                seeThat("el mensaje del sistema", TextoDe.elemento(InmueblesUI.LBL_MENSAJE), containsString(mensaje)));
    }

    @Then("Se muestra el inmueble del apartamento {string}")
    public void seMuestraElInmuebleDelApartamento(String apartamento) {
        testActor.should(
                seeThat("la fila del apartamento " + apartamento + " es visible",
                        ElementoVisible.en(InmueblesUI.filaDelApartamento(apartamento))));
    }

    @Then("Solo se muestra el inmueble del apartamento {string}")
    public void soloSeMuestraElInmuebleDelApartamento(String apartamento) {
        testActor.should(
                seeThat("la fila del apartamento " + apartamento + " es visible",
                        ElementoVisible.en(InmueblesUI.filaDelApartamento(apartamento))),
                seeThat("solo queda una fila visible tras buscar",
                        FilasVisibles.deInmuebles(), equalTo(1)));
    }

    @Then("El inmueble del apartamento {string} muestra al propietario {string}")
    public void elInmuebleMuestraAlPropietario(String apartamento, String propietario) {
        testActor.should(
                seeThat("la fila del inmueble existe", ElementoPresente.en(InmueblesUI.filaDelApartamento(apartamento))),
                seeThat("el propietario en la fila", TextoDe.elemento(InmueblesUI.filaDelApartamento(apartamento)),
                        containsString(propietario)));
    }

    @Then("El sistema solicita completar la informacion obligatoria")
    public void elSistemaSolicitaCompletarLaInformacion() {
        testActor.should(
                seeThat("el formulario esta completo", FormularioValido.deInmueble(), equalTo(false)));
    }
}