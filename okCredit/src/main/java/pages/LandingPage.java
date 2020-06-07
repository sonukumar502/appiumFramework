package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import utilities.ExtentReport;
import utilities.GenericMethods;

public class LandingPage {
	ExtentReport ex = new ExtentReport();
	WebDriver driver;
	public static String customName="";
	@FindBy(id = "in.okcredit.merchant:id/fabAddCustomer")
	private List<WebElement> addcustomerBtn;
	@FindBy(id = "in.okcredit.merchant:id/input_name")
	private WebElement customerName;
	@FindBy(id = "in.okcredit.merchant:id/name_button")
	private WebElement customerNameBtn;
	@FindBy(id = "in.okcredit.merchant:id/input_phone")
	private WebElement customerph;
	@FindBy(id = "in.okcredit.merchant:id/phone_button")
	private WebElement customerPhBtn;
	@FindBy(id = "in.okcredit.merchant:id/profile_name")
	private List<WebElement> profileName;
	@FindBy(id = "in.okcredit.merchant:id/add_credit_btn")
	private WebElement addcreditBtn;
	@FindBy(id = "in.okcredit.merchant:id/add_payment_btn")
	private WebElement addPaymentBtn;
	@FindBy(id = "in.okcredit.merchant:id/add_credit_text")
	private WebElement creditAmttxt;
	@FindBy(id = "in.okcredit.merchant:id/add_payment_text")
	private WebElement paymentAmttxt;
	@FindBy(id = "in.okcredit.merchant:id/btn_submit")
	private WebElement submitBtn;
	@FindBy(id = "in.okcredit.merchant:id/tx_amount")
	private WebElement savedAmtCustPage;
	@FindBy(id = "in.okcredit.merchant:id/balance")
	private WebElement savedAmtHomePage;
	@FindBy(id = "in.okcredit.merchant:id/search_bar_text")
	private WebElement searchCustomer;
	@FindBy(id = "in.okcredit.merchant:id/desc")
	private List<WebElement> customerList;
	@FindBy(id = "in.okcredit.merchant:id/total")
	private WebElement balanceAmt;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySuccessfullLogin() throws InterruptedException{
		Thread.sleep(2000);
		if(addcustomerBtn.size()>0){
			return true;
		}
		return false;
	}
	
	public boolean addCustomer(String custName,String phNo) throws InterruptedException{
		customName=custName;
		GenericMethods.click(addcustomerBtn.get(0));
		GenericMethods.enterText(customerName, custName);
		GenericMethods.click(customerNameBtn);
		GenericMethods.enterText(customerph, phNo);
		GenericMethods.click(customerPhBtn);
		Thread.sleep(2000);
		if(profileName.size()>0){
			ex.test.log(Status.INFO,"Customer "+custName+" added successfully");
			return true;
				}
		return false;
	}
	
	public boolean addCredit(String creditAmt) throws InterruptedException{
		Thread.sleep(2000);
		GenericMethods.click(addcreditBtn);
		String id="in.okcredit.merchant:id/btn_";
		for(int i=0;i<creditAmt.trim().length();i++){
			if(creditAmt.charAt(i)=='1'){
				id=id+"one";
			}
			if(creditAmt.charAt(i)=='2'){
				id=id+"two";
			}
			if(creditAmt.charAt(i)=='3'){
				id=id+"three";
			}
			if(creditAmt.charAt(i)=='4'){
				id=id+"four";
			}
			if(creditAmt.charAt(i)=='5'){
				id=id+"five";
			}
			if(creditAmt.charAt(i)=='6'){
				id=id+"six";
			}
			if(creditAmt.charAt(i)=='7'){
				id=id+"seven";
			}if(creditAmt.charAt(i)=='8'){
				id=id+"eight";
			}
			if(creditAmt.charAt(i)=='9'){
				id=id+"nine";
			}
			if(creditAmt.charAt(i)=='0'){
				id=id+"zero";
			}
			driver.findElement(By.id(id)).click();
			id="in.okcredit.merchant:id/btn_";
		}
		GenericMethods.click(submitBtn);
		String savedAmt=savedAmtCustPage.getText().trim().substring(1);
		if(savedAmt.equals(creditAmt)){
			ex.test.log(Status.INFO,"Entered Amount and displayed amount are same in customer Page");
			driver.navigate().back();
			GenericMethods.enterText(searchCustomer, customName);
			Thread.sleep(1000);
			if(savedAmt.equals(savedAmtHomePage.getText().trim().substring(1))){
				ex.test.log(Status.INFO,"Entered Amount and displayed amount are same in Home Page");
				return true;
			}
			
			return false;
		}
		return false;
	}
	
	public List<String> getListOfAllCustomers(){
		List<String> ls= new ArrayList<String>();
		GenericMethods.clearText(searchCustomer);
		for(int i=0;i<customerList.size();i++){
			ls.add(customerList.get(i).getText().trim());
		}
		return ls;
	}
	
	public String addPayment(String creditAmt) throws InterruptedException{
		GenericMethods.enterText(searchCustomer, customName);
		GenericMethods.click(customerList.get(0));
		Thread.sleep(1000);
		GenericMethods.click(addPaymentBtn);
		String id="in.okcredit.merchant:id/btn_";
		for(int i=0;i<creditAmt.trim().length();i++){
			if(creditAmt.charAt(i)=='1'){
				id=id+"one";
			}
			if(creditAmt.charAt(i)=='2'){
				id=id+"two";
			}
			if(creditAmt.charAt(i)=='3'){
				id=id+"three";
			}
			if(creditAmt.charAt(i)=='4'){
				id=id+"four";
			}
			if(creditAmt.charAt(i)=='5'){
				id=id+"five";
			}
			if(creditAmt.charAt(i)=='6'){
				id=id+"six";
			}
			if(creditAmt.charAt(i)=='7'){
				id=id+"seven";
			}if(creditAmt.charAt(i)=='8'){
				id=id+"eight";
			}
			if(creditAmt.charAt(i)=='9'){
				id=id+"nine";
			}
			if(creditAmt.charAt(i)=='0'){
				id=id+"zero";
			}
			driver.findElement(By.id(id)).click();
			id="in.okcredit.merchant:id/btn_";
		}
		GenericMethods.click(submitBtn);
		Thread.sleep(1000);
		String balance=balanceAmt.getText().trim();
		driver.navigate().back();
		return balance;
	}

	

}
