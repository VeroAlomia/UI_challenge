package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MovieGenrePage extends BasePage{

    private final By clickMovieBtn = By.xpath("//li[@class='k-item k-menu-item k-state-default k-first']//a[text()='Movies']");
    private final By clickonTopRated = By.xpath("//a[@class='k-link k-menu-link' and text()='Top Rated']\n");
    private final By genresSpanBy = By.xpath("//a[@class='no_click' and @href='/discover/movie?with_genres=28']\n");
    private final By acceptCookiesBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    public MovieGenrePage (WebDriver driver) {
        super(driver);
    }

    public  MovieGenrePage goToMovieGenreList() {
        this.driver.findElement(this.clickMovieBtn).click();
        return this;
    }
    public MovieGenrePage goToTopRated() {
        this.driver.findElement(this.clickonTopRated).click();
        return this;
    }
    public MovieGenrePage goToSearchMovieGenre() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)");
        this.driver.findElement(this.genresSpanBy).click();
        return this;
    }

    public MovieGenrePage acceptCookies() {
        this.driver.findElement(this.acceptCookiesBtn).click();
        return this;
    }
}

