package stepsDefinitions;

import interaction.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import question.TextoDe;
import task.IniciarSesionTask;
import task.RegistrarPagoTotalTask;
import userInterface.PagosUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GestionPagos {

    private static final String CLAVE = "ClaveBdd#2026Prueba";
    private static final String CORREO_ADMIN = "admin.bdd.adminconjunto@gmail.com";
    private static final String CORREO_PROPIETARIO = "residente.bdd.adminconjunto@gmail.com";

    private Actor actorPagos;

    @Managed
    WebDriver driverPagos;

    @Before
    public void prepararActorPagos() {
        actorPagos = Actor.named("Usuario de pagos").can(BrowseTheWeb.with(driverPagos));
    }

    @Given("El propietario inicia sesion en el sistema")
    public void elPropietarioIniciaSesionEnElSistema() {
        actorPagos.attemptsTo(
                NavigateTo.login(),
                IniciarSesionTask.como(CORREO_PROPIETARIO, CLAVE));
    }

    @Given("El administrador de pagos inicia sesion en el sistema")
    public void elAdministradorDePagosIniciaSesionEnElSistema() {
        actorPagos.attemptsTo(
                NavigateTo.login(),
                IniciarSesionTask.como(CORREO_ADMIN, CLAVE),
                NavigateTo.pagos());
    }

    @When("Ingresa al modulo de saldos y pagos")
    public void ingresaAlModuloDeSaldosYPagos() {
        actorPagos.attemptsTo(NavigateTo.pagos());
    }

    @When("Consulta su historial de pagos")
    public void consultaSuHistorialDePagos() {
        actorPagos.attemptsTo(NavigateTo.pagos());
    }

    @When("Registra el pago total de la cuota pendiente por el metodo {string}")
    public void registraElPagoTotalDeLaCuotaPendientePorElMetodo(String metodo) {
        actorPagos.attemptsTo(RegistrarPagoTotalTask.por(metodo));
    }

    @Then("Ve su cuota de {string} con estado {string}")
    public void veSuCuotaDeConEstado(String valor, String estado) {
        actorPagos.should(
                seeThat("la fila de la cuota", TextoDe.elemento(PagosUI.LBL_FILA_CUOTA), containsString(valor)),
                seeThat("el estado de la cuota", TextoDe.elemento(PagosUI.LBL_ESTADO_CUOTA), equalTo(estado)));
    }

    @Then("Se muestra el mensaje de pagos {string}")
    public void seMuestraElMensajeDePagos(String mensaje) {
        actorPagos.should(
                seeThat("el mensaje del sistema", TextoDe.elemento(PagosUI.LBL_MENSAJE), containsString(mensaje)));
    }

    @Then("La cuota pagada queda con estado {string}")
    public void laCuotaPagadaQuedaConEstado(String estado) {
        actorPagos.should(
                seeThat("el estado de la cuota", TextoDe.elemento(PagosUI.LBL_ESTADO_CUOTA), equalTo(estado)));
    }
}