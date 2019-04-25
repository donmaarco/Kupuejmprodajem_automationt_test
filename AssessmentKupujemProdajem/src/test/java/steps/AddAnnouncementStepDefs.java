package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elements.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAnnouncementStepDefs extends BaseMethods {

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

    String createAdLink = "//a[@class='bigLink submitAd']";
    String adSubject = "data[group_suggest_text]";
    String validAdSubject = "naocare za sunce";
    String adKind = "data[ad_kind]goods";
    String adCategory = "//div[@id='menuGroup1']/div[14]";
    String adGroup = "//div[@id='menuGroup1']/div[7])[2]";
    String itemCondition = "data[condition]used";
    String adPrice = "price_number";
    String priceValue = "50000";
    String priceCurrency = "data[currency]";
    String adContent = "mceContentBody";
    String contentText = "Ovo je tekst oglasa";
    String name = "data[owner]";
    String nameString = "Marko";
    String phone = "data[phone]";
    String phoneNumber = "065445521";

    @Given("^Open home page$")
    public void openHomePage() {

        //Open URL Environment
        openPage(urlEnvironment);

        //Maximize windows
        driver.manage().window().maximize();
        System.out.println("01.Successfully opened home page");
    }

    @And("^User will click on SignIn button$")
    public void userWillClickOnSignInButton() {

        //Logic for wait element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(signInLinkText)));

        //Click on SignIn button
        driver.findElement(By.linkText(signInLinkText)).click();
        System.out.println("02.Click on SignIn button");

    }

    @And("^User will enter valid email and password and click on Login button$")
    public void userWillEnterValidEmailAndPassword() {

        //Input data in email field
        driver.findElement(By.name(elementEmail)).sendKeys(validTestDataEmailAddress);
        System.out.println("03.Enter valid data in Email field");

        //Input data in password field
        driver.findElement(By.name(elementPassword)).sendKeys(testDataPassword);
        System.out.println("04.Enter valid data in Password field");

        //Click on Submit button on Login form
        driver.findElement(By.xpath(submitButton)).click();
        System.out.println("05.Click on Submit button");
    }

    @When("^User will add new announcement$")
    public void userWillAddNewAnnouncement() throws Exception {

        //Click on "Postavi oglas"
        driver.findElement(By.xpath(createAdLink)).click();
        System.out.println("06.Click to Create new ad");

        //Input ad subject"
        driver.findElement(By.id(adSubject)).sendKeys(validAdSubject);
        System.out.println("07.Input ad subject");

        //Select kind of ad
        driver.findElement(By.id(adKind)).click();
        System.out.println("08.Select kind of ad");

        Thread.sleep(1000);

        //driver.findElement(By.xpath(adCategory)).sendKeys("nakit");
        // Thread.sleep(20000000);
        // new Select(driver.findElement(By.xpath(adCategory)))select.ByVisibleText("Nakit, satovi i dragocenosti");

        //Select category of ad
        driver.findElement( By.xpath("//div[contains(text(),'Nakit, satovi i dragocenosti')]")).click();
        System.out.println("09.Select category of ad");

        Thread.sleep(1000);

        //Select group of ad
        driver.findElement( By.xpath("//div[contains(text(),'Naočare | Za muškarce')]")).click();
        System.out.println("10.Select group of ad");

        //driver.findElement(By.xpath(adGroup)).click();
        //new Select(driver.findElement(By.xpath(adCategory))).selectByVisibleText("Naočare | Za muškarce");
        //System.out.println("05.Select group of ad");

        Thread.sleep(1000);

        //Select item condition
        driver.findElement(By.id(itemCondition)).click();
        System.out.println("11.Select item condition");

        //Thread.sleep(1000);

        //Input price of ad
        driver.findElement(By.id(adPrice)).sendKeys(priceValue);
        System.out.println("12.Input price of ad");

        Thread.sleep(1000);

        //Select currency
        driver.findElement(By.name(priceCurrency)).click();
        System.out.println("13.Select currency");

        Thread.sleep(1000);

        //Input ad description
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame("data[description]_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Odlicno ocuvane naocare za sunce brenda Prada, stanje 9/10");
        driver.switchTo().defaultContent();

        //Input owner name
        driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys(nameString);
        System.out.println("16.Input owner name");

        //Input owner phone
        driver.findElement(By.name(phone)).clear();
        driver.findElement(By.name(phone)).sendKeys(phoneNumber);
        System.out.println("17.Input owner phone");

        Thread.sleep(1000);

        //Click on submit button
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('input.submit-button')[8].click()");

        //Select ad promotion type
        waitElementToBeClickableById("data[promo_type]none", 10);
        findElementByIdAndClick("data[promo_type]none");

        //Click on submit button
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('input.submit-button')[10].click()");

        //Mark checkbox to guarantee for the accuracy of the data entered
        waitElementToBeClickableById("swear_yes", 10);
        findElementByIdAndClick("swear_yes");

        //Mark checkbox to accept the Terms and Conditions for Advertising
        findElementByIdAndClick("accept_yes");

        //Click on submit button to announce a new ad
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('input.submit-button')[12].click()");

    }

    @Then("^User will successfully add new announcement$")
    public void userWillSuccessfullyAddNewAnnouncement() {

        //Validation of success message
        waitPresenceOfElementByCSS("div.pageNotification", 10);

        String expectedFirstColumnTitle = "Vaš oglas je postavljen u Nakit, satovi i dragocenosti » Naočare | Za muškarce\n" +
                "Možete ga naknadno izmeniti ili obnoviti preko Moj kp";

        String returnTitleFromMessage = String.format("return document.querySelectorAll('div.pageNotification')[0].innerText");

        Object titleOfAttributesInColumn = ((JavascriptExecutor)driver).executeScript(returnTitleFromMessage);

        Assert.assertEquals(titleOfAttributesInColumn,expectedFirstColumnTitle);

        //Click on log out button
        findElementByLinkTextAndClick("Izlogujte se");
    }
}
