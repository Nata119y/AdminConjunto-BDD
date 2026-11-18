package userInterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("http://127.0.0.1:8000/inmueble")
public class InmueblesUI extends PageObject {

    public static final Target BTN_NUEVO_INMUEBLE = Target.the("boton registrar inmueble")
            .located(By.cssSelector("[data-bs-target='#modalInmueble']"));

    public static final Target INP_TORRE = Target.the("torre").located(By.id("inmueble"));
    public static final Target INP_APARTAMENTO = Target.the("apartamento").located(By.id("numero_apto"));
    public static final Target INP_AREA = Target.the("area").located(By.id("area"));
    public static final Target INP_COEFICIENTE = Target.the("coeficiente").located(By.id("coeficiente"));
    public static final Target INP_IDENTIFICADOR = Target.the("identificador").located(By.id("identificador"));

    public static final Target INP_DOC_PROPIETARIO = Target.the("cedula del propietario")
            .located(By.id("documentoPropietario"));

    public static final Target BTN_BUSCAR_PROPIETARIO = Target.the("boton buscar propietario")
            .located(By.id("btnBuscarPropietario"));

    public static final Target LST_PROPIETARIOS = Target.the("propietarios agregados")
            .located(By.cssSelector("#listaPropietarios *"));

    public static final Target SEL_RESPONSABLE = Target.the("responsable de pago")
            .located(By.id("responsable_pago_id"));

    public static final Target BTN_GUARDAR = Target.the("boton guardar inmueble")
            .located(By.cssSelector("#formInmueble button[type='submit']"));

    public static final Target INP_BUSCAR = Target.the("buscador de inmuebles")
            .located(By.id("buscarInmueble"));

    public static final Target LBL_PRIMERA_FILA = Target.the("primera fila visible")
            .located(By.xpath("(//tbody[@id='tablaInmuebles']/tr[not(contains(@style,'none'))])[1]"));

    public static final Target LBL_MENSAJE = Target.the("mensaje del sistema")
            .located(By.cssSelector(".alert-success, .alert-danger"));

    public static Target filaDelApartamento(String apto) {
        return Target.the("fila del apartamento " + apto)
                .located(By.xpath("//tbody[@id='tablaInmuebles']/tr[contains(normalize-space(.),'Apartamento " + apto + "')]"));
    }
}