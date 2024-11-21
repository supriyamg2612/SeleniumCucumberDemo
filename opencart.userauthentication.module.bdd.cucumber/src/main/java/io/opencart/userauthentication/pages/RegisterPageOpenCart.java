package io.opencart.userauthentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageOpenCart {
	
	
WebDriver driver = null;
	
	public RegisterPageOpenCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWaring;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	@FindBy(xpath="//input[@id='input-confirm']/following-sibling::div")
	private WebElement confiemPasswordWarning;
	
	public WebElement getConfirmPasswordWaringText() {
		return confiemPasswordWarning;
	}
	
	public WebElement getFirstNameField() {
		return firstNameField;
		
	}
	public WebElement getLastNameField() {
	    return lastNameField;
	}

	public WebElement getEmailField() {
	    return emailField;
	}

	public WebElement getTelephoneField() {
	    return telephoneField;
	}

	public WebElement getPasswordField() {
	    return passwordField;
	}

	public WebElement getPasswordConfirmField() {
	    return passwordConfirmField;
	}

	public WebElement getPrivacyPolicyOption() {
	    return privacyPolicyOption;
	}

	public WebElement getContinueButton() {
	    return continueButton;
	}
	
	public AccountSuccessPageOpenCart clickOnContinueButton() {
		continueButton.click();

		return new AccountSuccessPageOpenCart();
	}
	
	public  WebElement selectYesNewsletterOption() {
		 return YesNewsletterOption;
	}
	
	public WebElement getWarningMessageText() {
		
		return warningMessage ;
		
	}
	
	public WebElement getFirstNameWarningText() {
		
		return firstNameWarning;
		
	}
	
	public WebElement getLastNameWarningText() {
		
		return lastNameWaring;
		
	}
	
	public WebElement getEmailWarningText() {
		
		return emailWarning;
		
	}
	
	public WebElement getTelephoneWarningText() {
		
		return telephoneWarning;
		
	}
	
	public WebElement getPasswordWarningText() {
		
		return passwordWarning;
		
	}
	

}

