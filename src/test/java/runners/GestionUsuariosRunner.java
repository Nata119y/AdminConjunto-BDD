package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/GestionUsuarios.feature",
        glue = "stepsDefinitions",
        tags = "not @pendiente",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class GestionUsuariosRunner {}