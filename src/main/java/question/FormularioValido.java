package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

// true si el navegador considera completo el formulario de inmueble
public class FormularioValido implements Question<Boolean> {

    public static FormularioValido deInmueble() {
        return new FormularioValido();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Object resultado = BrowseTheWeb.as(actor)
                .evaluateJavascript("return document.getElementById('formInmueble').checkValidity();");
        return Boolean.TRUE.equals(resultado);
    }
}