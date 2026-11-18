package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoPresente implements Question<Boolean> {

    private final Target target;

    private ElementoPresente(Target target) {
        this.target = target;
    }

    public static ElementoPresente en(Target target) {
        return new ElementoPresente(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isPresent();
    }
}