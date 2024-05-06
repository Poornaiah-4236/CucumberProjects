package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
	@FindBy(xpath="//*[@data-testid='open-registration-form-button']")
	public WebElement signUp;	
	@FindBy(xpath="//*[@name='firstname']")
	public WebElement firstName;	
	@FindBy(xpath="//*[@name='firstname']")
	public WebElement lastName;
	@FindBy(xpath="//*[@name='reg_email__']")
	public WebElement mobile;
	@FindBy(xpath="//*[@name='reg_passwd__']")
	public WebElement password;
	@FindBy(xpath="//*[@name='day']")
	public WebElement day;
	@FindBy(xpath="//*[@name='month']")
	public WebElement month;	
	@FindBy(xpath="//*[@name='year']")
	public WebElement year;
	@FindBy(xpath="//*[@name='//input[@value='2']']")
	public WebElement gender;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
