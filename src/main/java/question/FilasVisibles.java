package question;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

// Cuenta las filas de la tabla de inmuebles que el usuario ve en pantalla
public class FilasVisibles implements Question<Integer> {

    public static FilasVisibles deInmuebles() {
        return new FilasVisibles();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return (int) BrowseTheWeb.as(actor)
                .findAll("#tablaInmuebles tr")
                .stream()
                .filter(WebElementFacade::isCurrentlyVisible)
                .count();
    }
}
