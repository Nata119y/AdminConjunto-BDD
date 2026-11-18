package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userInterface.InmueblesUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GuardarInmuebleVacioTask implements Task {

    public static Performable sinDatos() {
        return Tasks.instrumented(GuardarInmuebleVacioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InmueblesUI.BTN_NUEVO_INMUEBLE),
                WaitUntil.the(InmueblesUI.BTN_GUARDAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(InmueblesUI.BTN_GUARDAR)
        );
    }
}