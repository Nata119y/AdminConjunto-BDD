package task;

import models.DatosUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userInterface.UsuariosUI;

import java.time.LocalDate;

public class CrearUsuarioTask implements Task {

    private static final String CLAVE_TEMPORAL = "ClaveTemporal#2026";

    private final DatosUsuario datos;

    public CrearUsuarioTask(DatosUsuario datos) {
        this.datos = datos;
    }

    public static Performable con(DatosUsuario datos) {
        return Tasks.instrumented(CrearUsuarioTask.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(datos.getNombre()).into(UsuariosUI.INP_NOMBRE),
                Enter.theValue(datos.getDocumento()).into(UsuariosUI.INP_DOCUMENTO),
                Enter.theValue(datos.getCorreo()).into(UsuariosUI.INP_CORREO),
                SelectFromOptions.byVisibleText(datos.getRol()).from(UsuariosUI.SEL_ROL)
        );

        // El arrendador necesita fecha de vencimiento: se fija por JavaScript para evitar el formato del calendario
        if ("Arrendador".equalsIgnoreCase(datos.getRol())) {
            String fecha = LocalDate.now().plusMonths(6).toString();
            BrowseTheWeb.as(actor).evaluateJavascript(
                    "document.getElementById('acceso_hasta').value='" + fecha + "';");
        }

        actor.attemptsTo(
                Enter.theValue(CLAVE_TEMPORAL).into(UsuariosUI.INP_CLAVE_TEMPORAL),
                Click.on(UsuariosUI.BTN_CREAR)
        );
    }
}