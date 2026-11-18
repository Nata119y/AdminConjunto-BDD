package task;

import models.DatosInmueble;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userInterface.InmueblesUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarInmuebleTask implements Task {

    private final DatosInmueble datos;

    public RegistrarInmuebleTask(DatosInmueble datos) {
        this.datos = datos;
    }

    public static Performable con(DatosInmueble datos) {
        return Tasks.instrumented(RegistrarInmuebleTask.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InmueblesUI.BTN_NUEVO_INMUEBLE),
                WaitUntil.the(InmueblesUI.INP_TORRE, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.getTorre()).into(InmueblesUI.INP_TORRE),
                Enter.theValue(datos.getApartamento()).into(InmueblesUI.INP_APARTAMENTO),
                Enter.theValue(datos.getArea()).into(InmueblesUI.INP_AREA),
                Enter.theValue("5").into(InmueblesUI.INP_COEFICIENTE),
                Enter.theValue(datos.getIdentificador()).into(InmueblesUI.INP_IDENTIFICADOR),
                Enter.theValue(datos.getCedulaPropietario()).into(InmueblesUI.INP_DOC_PROPIETARIO),
                Click.on(InmueblesUI.BTN_BUSCAR_PROPIETARIO),
                WaitUntil.the(InmueblesUI.LST_PROPIETARIOS, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byIndex(1).from(InmueblesUI.SEL_RESPONSABLE),
                Click.on(InmueblesUI.BTN_GUARDAR),
                WaitUntil.the(InmueblesUI.LBL_MENSAJE, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}