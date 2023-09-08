package Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BasePage {
    protected WebDriver driver; //Solo los hijos tienen acceso

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement maplocator(By element){
        return driver.findElement(element);
    }

}
