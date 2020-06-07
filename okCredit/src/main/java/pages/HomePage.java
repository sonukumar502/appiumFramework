package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import utilities.ExtentReport;
import utilities.GenericMethods;

public class HomePage {
	ExtentReport ex = new ExtentReport();
	WebDriver driver;
	GenericMethods gm = new GenericMethods();
	
	@FindBy(id = "in.okcredit.merchant:id/english")
	private WebElement selectLanguageEnglish;
	@FindBy(id = "in.okcredit.merchant:id/hindi")
	private WebElement selectLanguagehindi;
	@FindBy(id = "in.okcredit.merchant:id/hinglish")
	private WebElement selectLanguagehinglish;
	@FindBy(id = "in.okcredit.merchant:id/punjabi")
	private WebElement selectLanguagepunjabi;
	@FindBy(id = "in.okcredit.merchant:id/malayalam")
	private WebElement selectLanguagemalayalam;
	@FindBy(id = "in.okcredit.merchant:id/getStarted")
	private WebElement gettinStarted;
	@FindBy(id = "in.okcredit.merchant:id/mobile")
	private WebElement mobileNo;
	@FindBy(id = "in.okcredit.merchant:id/ok")
	private WebElement okButton;
	@FindBy(className = "android.widget.EditText")
	private WebElement password;
	@FindBy(className = "android.widget.ImageButton")
	private WebElement menuButton;
	@FindBy(xpath = "(//*[@class='android.widget.LinearLayout'])[16]")
	private WebElement signoutBtn;
	
	@FindBy(id = "in.okcredit.merchant:id/logout")
	private WebElement signoutConfirmationBtn;
	public HomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	public void selectLanguage(String language){
		if(language.equalsIgnoreCase("english")){
		GenericMethods.click(selectLanguageEnglish);
		}
		if(language.equalsIgnoreCase("hindi")){
			GenericMethods.click(selectLanguagehindi);
			}
		if(language.equalsIgnoreCase("hinglish")){
			GenericMethods.click(selectLanguagehinglish);
			}
		if(language.equalsIgnoreCase("punjabi")){
			GenericMethods.click(selectLanguagepunjabi);
			}
		if(language.equalsIgnoreCase("malayalam")){
			GenericMethods.click(selectLanguagemalayalam);
			}
		ex.test.log(Status.INFO, "Clicked on Button: "+language);
	}
	
	public void clickOnGetStarted(){
		GenericMethods.click(gettinStarted);
	}
	
	public void enterMobileNoAndPassword(String mblNo,String pwd){
		GenericMethods.enterText(mobileNo, mblNo);
		ex.test.log(Status.INFO, "Entered Mobile No: "+mblNo);
		GenericMethods.click(okButton);
		GenericMethods.enterText(password, pwd);
		GenericMethods.click(okButton);
	}
	
	public void signout(){
		GenericMethods.click(menuButton);
		GenericMethods.click(signoutBtn);
		GenericMethods.click(signoutConfirmationBtn);
	}

}
