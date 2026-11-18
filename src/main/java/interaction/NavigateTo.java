package interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import userInterface.InmueblesUI;
import userInterface.LoginUI;

public class NavigateTo {

    public static Performable login() {
        return Task.where("{0} abre el login de AdminConjunto",
                Open.browserOn().the(LoginUI.class));
    }

    public static Performable inmuebles() {
        return Task.where("{0} abre el modulo de inmuebles",
                Open.browserOn().the(InmueblesUI.class));
    }
}