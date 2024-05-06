package stepDefinition;
import Driveras.DriverUtilites;
import io.cucumber.java.en.Given;
public class HomePageStepDef extends DriverUtilites{

	@Given("Navigate URL")
	public void navigate_url() {	
		System.out.println("open method");
		//File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	}

}
