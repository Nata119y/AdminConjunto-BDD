package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userInterface.PagosUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarPagoTotalTask implements Task {

    private final String metodo;

    public RegistrarPagoTotalTask(String metodo) {
        this.metodo = metodo;
    }

    public static Performable por(String metodo) {
        return Tasks.instrumented(RegistrarPagoTotalTask.class, metodo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PagosUI.BTN_REGISTRAR_PAGO),
                WaitUntil.the(PagosUI.SEL_CUOTA, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byIndex(1).from(PagosUI.SEL_CUOTA),
                SelectFromOptions.byVisibleText(metodo).from(PagosUI.SEL_METODO),
                Click.on(PagosUI.BTN_CONFIRMAR_PAGO),
                WaitUntil.the(PagosUI.LBL_MENSAJE, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}