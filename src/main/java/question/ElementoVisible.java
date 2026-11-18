package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoVisible implements Question<Boolean> {

    private final Target target;

    private ElementoVisible(Target target) {
        this.target = target;
    }

    public static ElementoVisible en(Target target) {
        return new ElementoVisible(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isCurrentlyVisible();
    }
}
