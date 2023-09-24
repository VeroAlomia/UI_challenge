package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActorPage extends BasePage {

    private final By actorNameElement = By.xpath("//div[@class='name']");
    private final By biographyElement = By.xpath("//div[@class='biography']");

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    public ActorPage extractActorInfo() {
        WebElement actorNameElement = driver.findElement(this.actorNameElement);
        WebElement biographyElement = driver.findElement(this.biographyElement);

        String actorName = actorNameElement.getText();
        String biography = biographyElement.getText();

        System.out.println("Actor Name: " + actorName);
        System.out.println("Biography: " + biography);

        return this;
    }
}