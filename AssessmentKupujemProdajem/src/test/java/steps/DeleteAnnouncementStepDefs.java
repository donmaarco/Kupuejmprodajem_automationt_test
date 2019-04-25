package steps;

import cucumber.api.java.en.When;
import elements.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DeleteAnnouncementStepDefs extends BaseMethods {

    /**
     * Global variables
     */
    String urlEnvironment = "https://www.kupujemprodajem.com/";
    String signInLinkText = "Ulogujte se";
    String elementEmail = "data[email]";
    String validTestDataEmailAddress = "ynn68191@cndps.com";
    String elementPassword = "data[password]";
    String testDataPassword = "random";
    String submitButton = "//input[@value='Ulogujte se']";

    String adDelete = "Obriši";
    String myProfile = "//a[@class='bigLink mojKp']";
    String deleteReason = "//input[@id='data[reason]other']";

    @When("^User will delete Announcement$")
    public void userWillDeleteAnnouncement() {

        //Click on My profile
        driver.findElement(By.xpath(myProfile)).click();
        System.out.println("06.Click on My profile button");

        //Click on link "Obrisi"
        driver.findElement(By.linkText(adDelete)).click();
        System.out.println("07.Click on delete ad link");

        //driver.findElement(By.xpath(deleteReason)).click();
        //System.out.println("08.Reason for deleting ad");

       //Click to select reason for deleting ad
        waitPresenceOfElementByCSS("input", 10);
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('input')[5].click()");

        //Click to confirm the deleting of ad
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('input')[6].click()");

        //Close browser if test is finish
        driver.close();
    }
}
