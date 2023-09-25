package UITests;

import Scenarios.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Tests extends TestHooks {
    private static final Logger logger = Logger.getLogger(Tests.class.getName());
    static {
        try {
            FileHandler fh = new FileHandler("logs/UIchallenge.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginSuccessfull(){
        // Create a LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.goToLogin()
                .sendUsername("VeroAlomia")
                .sendPassword("Sk84stereo")
                .login();

        // Verify the login was successful
        Assert.assertEquals(loginPage.getUsernameText("VeroAlomia"),"VeroAlomia");

        // Add a log after the test
        logger.info("Successful login test.");
    }

    @Test
    public void invalidLogin(){
        // Create a LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with invalid credentials
        loginPage.goToLogin()
                .sendUsername("Alomia")
                .sendPassword("123")
                .login();

        // Verify that an invalid credential dialog is displayed
        Assert.assertTrue(loginPage.checkInvalidCredentialDialog());

        // Add a log after the test
        logger.info("Invalid login test.");
    }

    @Test
    public void successfulSearch () {
        // Create a SearchMoviePage object
        SearchMoviePage searchMoviePage = new SearchMoviePage(driver);

        // Perform a search for a movie
        searchMoviePage.goToSearchmovie()
                .sendMovieName("Fight Club");

        // Verify the searched movie name
        Assert.assertEquals(searchMoviePage.getMovienameText(),"Fight Club");

        // Add a log after the test
        logger.info("Successful search test.");
    }

    @Test
    public void verifySortingByAscendingOrder (){
        // Create a SortPage object
        SortPage viewAscendingOrder = new SortPage(driver);

        // Perform sorting by ascending order
        viewAscendingOrder.goToMovieGenreList()
                .goToTopRated()
                .acceptCookies()
                .showSort()
                .viewAscendingOrder()
                .searchButton();

        // Get the dates of the first four items
        LocalDate d1 = viewAscendingOrder.searchCartDate(1);
        LocalDate d2 = viewAscendingOrder.searchCartDate(2);
        LocalDate d3 = viewAscendingOrder.searchCartDate(3);
        LocalDate d4 = viewAscendingOrder.searchCartDate(4);

        // Verify that the dates are in ascending order
        Assert.assertTrue(
                d1.isBefore(d2) &&
                        d2.isBefore(d3) &&
                        d3.isBefore(d4)
        );

        // Add a log after the test
        logger.info("Verify sorting by ascending order test.");
    }

    @Test
    public void verifyMovieGenre () {
        // Create a MovieGenrePage object
        MovieGenrePage movieGenre = new MovieGenrePage(driver);

        // Perform actions related to movie genres
        movieGenre.goToMovieGenreList()
                .goToTopRated()
                .acceptCookies()
                .goToSearchMovieGenre();

        // Add a log after the test
        logger.info("Verify movie genre test.");
    }

    @Test
    public void validateActingTimeline () {
        // Create an ActorPage object
        ActorPage actimeline = new ActorPage(driver);
        // Add a log at the start of the test
        logger.info("Starting acting timeline validation test.");
    }
}


