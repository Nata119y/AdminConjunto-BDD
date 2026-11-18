package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userInterface.LoginUI;

public class IniciarSesionTask implements Task {

    private final String correo;
    private final String clave;

    public IniciarSesionTask(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public static Performable como(String correo, String clave) {
        return Tasks.instrumented(IniciarSesionTask.class, correo, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(correo).into(LoginUI.INP_CORREO),
                Enter.theValue(clave).into(LoginUI.INP_CLAVE),
                Click.on(LoginUI.BTN_INGRESAR)
        );
    }
}