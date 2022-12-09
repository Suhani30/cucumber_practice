package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    @FindBy(xpath = "//a[@class='login']")
    WebElement btnLogin;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnSubmit;
    @FindBy(xpath = "//a[@class='logout']")
    WebElement btnLogout;

    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email, String password){
        btnLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
}
