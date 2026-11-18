package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TextoDe implements Question<String> {

    private final Target target;

    private TextoDe(Target target) {
        this.target = target;
    }

    public static TextoDe elemento(Target target) {
        return new TextoDe(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().trim();
    }
}