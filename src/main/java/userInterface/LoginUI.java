package userInterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("http://127.0.0.1:8000/login")
public class LoginUI extends PageObject {

    public static final Target INP_CORREO = Target.the("campo correo")
            .located(By.id("email"));

    public static final Target INP_CLAVE = Target.the("campo clave")
            .located(By.id("password"));

    public static final Target BTN_INGRESAR = Target.the("boton ingresar")
            .located(By.cssSelector("button.btn-login"));
}