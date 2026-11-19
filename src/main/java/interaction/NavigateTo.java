package interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import userInterface.InmueblesUI;
import userInterface.LoginUI;
import userInterface.PagosUI;
import userInterface.UsuariosUI;

public class NavigateTo {

    public static Performable login() {
        return Task.where("{0} abre el login de AdminConjunto",
                Open.browserOn().the(LoginUI.class));
    }

    public static Performable inmuebles() {
        return Task.where("{0} abre el modulo de inmuebles",
                Open.browserOn().the(InmueblesUI.class));
    }

    public static Performable pagos() {
        return Task.where("{0} abre el modulo de saldos y pagos",
                Open.browserOn().the(PagosUI.class));
    }

    public static Performable usuarios() {
        return Task.where("{0} abre el modulo de usuarios",
                Open.browserOn().the(UsuariosUI.class));
    }
}