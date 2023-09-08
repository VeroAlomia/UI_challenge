package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchMoviePage extends BasePage{

    private final By searchClick = By.xpath("//a[@href='/search']");
    private final By movieNameInput = By.xpath("//input[@id='search_v4']");

    private final By acceptCookiesBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");


    public SearchMoviePage(WebDriver driver) {
        super(driver);
    }

    public SearchMoviePage goToSearchmovie() {
        this.driver.findElement(this.searchClick).click();
        return this;
    }
    public SearchMoviePage sendMovieName(String movienameKey) {
        this.driver.findElement(this.movieNameInput).sendKeys(movienameKey);
        this.driver.findElement(this.movieNameInput).sendKeys(Keys.RETURN);
        return this;
    }

    public String getMovienameText() {
        return this.driver.findElement(By.xpath("//div[@class=\"search_results movie \"]//div[@class=\"card v4 tight\"][1]//div[@class=\"title\"]//h2")).getText();
    }

    public SearchMoviePage acceptCookies() {
        this.driver.findElement(this.acceptCookiesBtn).click();
        return this;
    }
}
