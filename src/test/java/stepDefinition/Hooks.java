package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Driveras.DriverUtilites;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverUtilites {
	@Before
    public void beforeScenario() throws IOException{
        System.out.println("This will run before the Scenario");
        openBrowser();
    }	
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        driver.quit();
    }
}
