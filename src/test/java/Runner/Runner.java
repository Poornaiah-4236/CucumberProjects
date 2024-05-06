package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Featurs/OpenBrowser.feature"}
		,glue={"stepDefinition"}
		,plugin= {"pretty","html:target/cucumber.html"}
		//,tags= {"@Regression"}
		,monochrome=true
		)
public class Runner{

}
