package userInterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("http://127.0.0.1:8000/usuarios")
public class UsuariosUI extends PageObject {

    public static final Target INP_NOMBRE = Target.the("nombre").located(By.id("nombre"));
    public static final Target INP_DOCUMENTO = Target.the("documento").located(By.id("documento"));
    public static final Target INP_CORREO = Target.the("correo").located(By.id("correo"));
    public static final Target SEL_ROL = Target.the("rol").located(By.id("rol"));
    public static final Target INP_CLAVE_TEMPORAL = Target.the("clave temporal").located(By.id("clave_temporal"));

    public static final Target BTN_CREAR = Target.the("boton crear usuario")
            .located(By.cssSelector("#formUsuario button[type='submit']"));

    public static final Target LBL_MENSAJE_EXITO = Target.the("mensaje de exito")
            .located(By.cssSelector(".alert-success"));

    public static Target filaDelUsuario(String correo) {
        return Target.the("fila del usuario " + correo)
                .located(By.xpath("//tbody/tr[contains(normalize-space(.),'" + correo + "')]"));
    }

    public static Target mensajeConTexto(String texto) {
        return Target.the("mensaje con el texto: " + texto)
                .located(By.xpath("//*[self::div or self::span or self::p or self::li or self::h1 or self::h2]"
                        + "[contains(normalize-space(.),\"" + texto + "\")]"));
    }
}