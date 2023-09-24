package UITests;

import Scenarios.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class Tests extends TestHooks {
    @Test
    public void loginSuccessfull(){
        //System.out.println(driver);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLogin()
                .sendUsername("VeroAlomia")
                .sendPassword("Sk84stereo")
                .login();
        Assert.assertEquals(loginPage.getUsernameText("VeroAlomia"),"VeroAlomia");
    }
    @Test
    public void invalidLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLogin()
                .sendUsername("Alomia")
                .sendPassword("123")
                .login();
        Assert.assertTrue(loginPage.checkInvalidCredentialDialog());

    }
    @Test
    public void successfulSearch () {
        SearchMoviePage searchMoviePage = new SearchMoviePage(driver);
        searchMoviePage.goToSearchmovie()
                .sendMovieName("Fight Club");
        Assert.assertEquals(searchMoviePage.getMovienameText(),"Fight Club");

    }

    @Test
    public void verifySortingByAscendingOrder (){
        SortPage viewAscendingOrder = new SortPage(driver);
        viewAscendingOrder.goToMovieGenreList()
                .goToTopRated()
                .acceptCookies()
                .showSort()
                .viewAscendingOrder()
                .searchButton();

        LocalDate d1 = viewAscendingOrder.searchCartDate(1);
        LocalDate d2 = viewAscendingOrder.searchCartDate(2);
        LocalDate d3 = viewAscendingOrder.searchCartDate(3);
        LocalDate d4 = viewAscendingOrder.searchCartDate(4);

        Assert.assertTrue(
                d1.isBefore(d2) &&
                d2.isBefore(d3) &&
                d3.isBefore(d4)
                  );
    }
    @Test
    public void verifyMovieGenre () {
        MovieGenrePage movieGenre = new MovieGenrePage(driver);
        movieGenre.goToMovieGenreList()
                .goToTopRated()
                .acceptCookies()
                .goToSearchMovieGenre();
    }

    @Test
    public void validateActingTimeline () {
        ActorPage actimeline = new ActorPage(driver);
    }
}


