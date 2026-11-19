package userInterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("http://127.0.0.1:8000/pagos")
public class PagosUI extends PageObject {

    public static final Target BTN_REGISTRAR_PAGO = Target.the("boton registrar pago")
            .located(By.cssSelector("[data-bs-target='#modalRegistrarPago']"));

    public static final Target SEL_CUOTA = Target.the("cuota a pagar")
            .located(By.id("cuotas_id"));

    public static final Target SEL_METODO = Target.the("metodo de pago")
            .located(By.id("metodo_admin"));

    public static final Target BTN_CONFIRMAR_PAGO = Target.the("boton confirmar pago")
            .located(By.cssSelector("#modalRegistrarPago button[type='submit']"));

    public static final Target LBL_FILA_CUOTA = Target.the("fila de la cuota")
            .located(By.xpath("(//table//tr[.//span[contains(@class,'estado-cuota')]])[1]"));

    public static final Target LBL_ESTADO_CUOTA = Target.the("estado de la cuota")
            .located(By.xpath("(//span[contains(@class,'estado-cuota')])[1]"));

    public static final Target LBL_MENSAJE = Target.the("mensaje del sistema")
            .located(By.cssSelector(".alert-success, .alert-danger"));
}
