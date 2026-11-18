package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import userInterface.InmueblesUI;

public class BuscarInmuebleTask implements Task {

    private final String apartamento;

    public BuscarInmuebleTask(String apartamento) {
        this.apartamento = apartamento;
    }

    public static Performable conApartamento(String apartamento) {
        return Tasks.instrumented(BuscarInmuebleTask.class, apartamento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(apartamento).into(InmueblesUI.INP_BUSCAR));
    }
}