package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActorPage extends BasePage{

    private final By actingTimelineBy = By.xpath("//table[@class='credit_group']//bdi");
    public ActorPage(WebDriver driver){
        super(driver);
    }

}
