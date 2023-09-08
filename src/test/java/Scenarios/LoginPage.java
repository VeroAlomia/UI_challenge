package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final By loginLink = By.xpath("//a[@href='/login']");
    private final By usernameInput = By.xpath("//input[@id='username']");
    private final  By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login_button']");

    private final By invalidCredentialDialog = By.xpath("//h2[@class=\"background_color red\"]");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage sendUsername(String usernameKey) {
        this.driver.findElement(this.usernameInput).sendKeys(usernameKey);
        return this;
    }

    public LoginPage sendPassword(String passwordKey) {
        this.driver.findElement(this.passwordInput).sendKeys(passwordKey);
        return this;
    }

    public LoginPage goToLogin() {
        this.driver.findElement(this.loginLink).click();
        return this;
    }

    public LoginPage login() {
        this.driver.findElement(this.loginButton).click();
        return this;
    }

    public String getUsernameText(String username) {
       return this.driver.findElement(By.xpath("//a[.='"+username+"']")).getText();
    }

    public Boolean checkInvalidCredentialDialog(){
       return this.driver.findElement(this.invalidCredentialDialog).isDisplayed();
    }

    //Fluent Interface
}
