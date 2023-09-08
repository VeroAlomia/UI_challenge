package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SortPage extends BasePage{

    private final By clickMovieBtn = By.xpath("//li[@class='k-item k-menu-item k-state-default k-first']//a[text()='Movies']");
    private final By clickonTopRated = By.xpath("//a[@class='k-link k-menu-link' and text()='Top Rated']\n");

    private final By clickOnSort = By.xpath("//h2[text()='Sort']\n");

    private final By deployList = By.xpath("//span[@role='listbox']");
    private final By lookAscending = By.xpath("//li[text()='Release Date Ascending']");


    private final By clickonSearchBtn = By.xpath("//a[@class='no_click load_more' and text()='Search']\n");

    private final By acceptCookiesBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public SortPage (WebDriver driver) {
        super(driver);
    }

    public SortPage goToMovieGenreList() {
        this.driver.findElement(this.clickMovieBtn).click();
        return this;
    }
    public SortPage goToTopRated() {
        this.driver.findElement(this.clickonTopRated).click();
        return this;
    }
    public SortPage showSort() {
        this.driver.findElement(this.clickOnSort).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        this.driver.findElement(this.deployList).click();
        return this;
    }
    public SortPage viewAscendingOrder() {
        this.driver.findElement(this.lookAscending).click();
        return this;
    }

    public SortPage acceptCookies() {
    this.driver.findElement(this.acceptCookiesBtn).click();
    return this;
    }

    public SortPage searchButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        this.driver.findElements(this.clickonSearchBtn).get(1).click();
        return this;
    }

    public LocalDate searchCartDate(int index) {
        try {
            Thread.sleep(2000);
        } catch (Exception  e) {
        }
        String safeDate =  this.driver.findElement(By.xpath("//section[@id='media_results']//div[contains(@class,'card')]["+index+"]//div[@class='content']//p")).getText();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return LocalDate.parse(safeDate, formatoFecha);
    }

}
