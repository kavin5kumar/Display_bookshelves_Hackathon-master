package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ThirdPage extends BasePage {

	WebDriver driver;
	Select monthDateSelect;
	public ThirdPage(WebDriver driver) {
		super(driver);
		
	}
    // Locating Gift cards Button and filling the necessary details
	@FindBy(xpath="//a[@class='featuredLinksBar__link' and @href='../../gift-cards?src=header']")
	public WebElement GiftCards;
	
	@FindBy(xpath="//img[@alt='Birthday/Anniversary Gift Card by Urban Ladder']")
	public WebElement ReachBirthday;
	
	@FindBy(xpath="//p[contains(text(),'Gift something memorable to help them celebrate great memories!')]/following::button[1]")
	public WebElement ChooseBirthday;
	
	@FindBy(xpath="//input[@id='ip_2251506436']")
	public WebElement EnterAmount;
	
	@FindBy(xpath="//h4[normalize-space()='Send On:']/following-sibling::select[1]")
	public WebElement EnterMonth;
	
	@FindBy(xpath="//h4[normalize-space()='Send On:']/following-sibling::select[2]")
	public WebElement EnterDay;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement ClickNext;

	
	//Locating the recipient's details and filling the details
    @FindBy(xpath="//input[@id='ip_4036288348']")
    public  WebElement Recipientsname;
    
    @FindBy(xpath="//input[@id='ip_137656023']")
    public WebElement RecipientsEmail;
    
    @FindBy(xpath="//input[@id='ip_3177473671']")
    public WebElement RecipientNumber;
    
    //Locating the Customer's Detail
    
    @FindBy(xpath="//input[@id='ip_1082986083']")
    public WebElement Name;
    
    @FindBy(xpath="//input[@id='ip_4081352456']")
    public WebElement Email;
    
    @FindBy(xpath="//input[@id='ip_2121573464']")
    public WebElement Number;
    
    @FindBy(xpath="//input[@id='ip_2194351474']")
    public WebElement Address;
    
    @FindBy(xpath="//input[@id='ip_567727260']")
    public WebElement pincode;
    
    @FindBy(xpath="//button[contains(text(),'Confirm')]")
    public WebElement Confirm;
    
    @FindBy(xpath="//span[contains(text(),'Proceed to payment')]")
    public WebElement Payment;
    
    @FindBy(xpath="//li[@class='_2tx0o']")
    public WebElement errormsg;
    
    @FindBy(xpath="//div[@class='BCLqs']")
    public WebElement AmountOutput;
    
    @FindBy(xpath="//*[@class='_14QEd _1QpDs']//section//span[1]")
    public WebElement TypeOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[1]/div[1]")
    public WebElement SendNameOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[1]/div[2]")
    public WebElement SendEmailOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[1]/div[3]")
    public WebElement SendPhoneOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[2]/div[1]")
    public WebElement RecieveNameOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[2]/div[2]")
    public WebElement RecieveEmailOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[2]/div[3]")
    public WebElement RecievePhoneOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[2]/div[4]")
    public WebElement RecieveAddressOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[2]/div[5]")
    public WebElement RecieveAddressPinOutput;
    
    @FindBy(xpath="(//*[@class='dL47V'])[3]")
    public WebElement MessageOutput;
    
	public void clickGiftcards() {
		try {
			Thread.sleep(2000);
			GiftCards.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickBirthday(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		
		act.moveToElement(ReachBirthday).build().perform();
		ChooseBirthday.click();
	}
	
	public void Enteramount(String amount) {
		EnterAmount.sendKeys(amount);
	}
	
	public void Entermonth() {
		monthDateSelect = new Select(EnterMonth);
		monthDateSelect.selectByVisibleText("June (2024)");
	}
	
	public void Enterday() {
		monthDateSelect = new Select(EnterDay);
		monthDateSelect.selectByVisibleText("7");
	}
	
	public void Clicknext() {
		ClickNext.click();
	}
	
	public void EnterToDetails(String name,String email,String mobile) {
		
		Recipientsname.sendKeys(name);	
		RecipientsEmail.sendKeys(email);
	    RecipientNumber.sendKeys(mobile);
	}
	
	
	public void EnterCustomerDetails(String name,String email,String mobile,String address,String pinCode) throws InterruptedException
	{  
    	
    	
    Name.sendKeys(name);
    Email.sendKeys(email);
    Address.sendKeys(address);
    Number.sendKeys(mobile);
    pincode.sendKeys(pinCode);
    Thread.sleep(2000);
    Confirm.click();
   
	}
	
	public void clickpayment(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(5000);
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,150)");
    	Thread.sleep(5000);
    	Confirm.click();
    	Thread.sleep(3000);
//	    Payment.click();
	}

	public void getErrorMsg(WebDriver driver) {
		
		String Msg = RecipientsEmail.getAttribute("validationMessage");
		System.out.println("Error Message: "+Msg);
	}
	
	public void displayDetails() {
	    System.out.println("Amount - " + AmountOutput.getText());
		System.out.println("Type - " + TypeOutput.getText());
		System.out.println("Sender's Name - " + SendNameOutput.getText());
		System.out.println("Sender's Email - " +SendEmailOutput.getText());
		System.out.println("Sender's Phone - " +SendPhoneOutput.getText());
		System.out.println("Reciever's Name - " +RecieveNameOutput.getText());
		System.out.println("Reciever's Email - " +RecieveEmailOutput.getText());
		System.out.println("Reciever's Phone - "+ RecievePhoneOutput.getText());
		System.out.println("Reciever's Address - " + RecieveAddressOutput.getText());
		System.out.println("Reciever's Address with Pin - " + RecieveAddressPinOutput.getText());
		System.out.println("Message - " + MessageOutput.getText());

	}
}
