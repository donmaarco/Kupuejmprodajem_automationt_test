package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {

    /******************************************************************************
     INITIALIZE SELENIUM WEBDRIVER ON LOCAL MACHINE
     *****************************************************************************/


    public static final WebDriver driver = new ChromeDriver();


    /******************************************************************************
     METHODS
     *****************************************************************************/


    WebElement el = null;

    /***
     * Browser Mximize
     */
    protected void browserMximize() {driver.manage().window().fullscreen();}

    /***
     * Open Page
     * @param urlPage
     */
    protected void openPage(String urlPage) {

        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path);
        driver.get(urlPage);}


    /******************************************************************************
     METHODS FOR FIND ELEMENT AND CLICK
     *****************************************************************************/

    /***
     * findElementByIdAndClick
     * @param id
     */
    protected void findElementByIdAndClick(String id){
        el = findElementById(id);
        click(el);
    }

    /***
     * findElementByXPathAndClick
     * @param xPath
     */
    protected void findElementByXPathAndClick(String xPath){
        el = findElementByXPath(xPath);
        click(el);
    }

    /***
     * findElementByCssAndClick
     * @param css
     */
    protected void findElementByCssAndClick(String css){
        el = findElementByCss(css);
        click(el);
    }

    /***
     * findElementByLinkTextAndClick
     * @param linkText
     */
    protected void findElementByLinkTextAndClick(String linkText){
        el = findElementByLinkText(linkText);
        click(el);
    }

    /***
     * findElementByClassNameAndClick
     * @param className
     */
    protected void findElementByClassNameAndClick(String className){
        el = findElementByClassName(className);
        click(el);
    }

    /***
     * findElementByTagNameAndClick
     * @param tagName
     */
    protected void findElementByTagNameAndClick(String tagName){
        el = findElementByTagName(tagName);
        click(el);
    }

    /******************************************************************************
     METHODS FOR FIND ELEMENT AND SEND KEYS
     *****************************************************************************/


    /***
     * findElementByIdAndSendKeys
     * @param id
     * @param keys
     */
    protected void findElementByIdAndSendKeys(String id, String keys){
        el = findElementById(id);
        sendKeys(el, keys);
    }

    /***
     * findElementByXPathAndSendKeys
     * @param xPath
     * @param keys
     */
    protected void findElementByXPathAndSendKeys(String xPath, String keys){
        el = findElementByXPath(xPath);
        sendKeys(el, keys);
    }

    /***
     * findElementByCssAndSendKeys
     * @param css
     * @param keys
     */
    protected void findElementByCssAndSendKeys(String css, String keys){
        el = findElementByCss(css);
        sendKeys(el, keys);
    }

    /***
     * findElementByLinkTextAndSendKeys
     * @param linkText
     * @param keys
     */
    protected void findElementByLinkTextAndSendKeys(String linkText, String keys){
        el = findElementByLinkText(linkText);
        sendKeys(el, keys);
    }

    /***
     * findElementByClassNameAndSendKeys
     * @param className
     * @param keys
     */
    protected void findElementByClassNameAndSendKeys(String className, String keys){
        el = findElementByClassName(className);
        sendKeys(el, keys);
    }

    /***
     * findElementByTagNameAndSendKeys
     * @param tagName
     * @param keys
     */
    protected void findElementByTagNameAndSendKeys(String tagName, String keys){
        el = findElementByTagName(tagName);
        sendKeys(el, keys);
    }

    /******************************************************************************
     METHODS FOR FIND ELEMENT WITHOUT ACTION
     *****************************************************************************/

    /***
     * findElementById
     * @param id
     * @return
     */
    protected WebElement findElementById(String id){
        try{
            return driver.findElement(By.id(id));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByXPath
     * @param xPath
     * @return
     */
    protected WebElement findElementByXPath(String xPath){
        try{
            return driver.findElement(By.xpath(xPath));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByCss
     * @param css
     * @return
     */
    protected WebElement findElementByCss(String css){
        try{
            return driver.findElement(By.cssSelector(css));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByLinkText
     * @param linkText
     * @return
     */
    protected WebElement findElementByLinkText(String linkText){
        try{
            return driver.findElement(By.linkText(linkText));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByClassName
     * @param className
     * @return
     */
    protected WebElement findElementByClassName(String className){
        try{
            return driver.findElement(By.className(className));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByTagName
     * @param tagName
     * @return
     */
    protected WebElement findElementByTagName(String tagName){
        try{
            return driver.findElement(By.tagName(tagName));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * click
     * @param el
     */
    protected void click(WebElement el){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",el);
    }

    /***
     * sendKeys
     * @param el
     * @param keys
     */
    protected void sendKeys(WebElement el, String keys){
        el.sendKeys(keys);
    }


    /******************************************************************************
     METHOD FOR WAIT
     *****************************************************************************/

    /***
     * Wait for some time
     * @param waitTime
     */
    protected void waitFor(long waitTime){

        try {
            Thread.sleep(waitTime);
        }
        catch (java.lang.InterruptedException e){

        }
    }

    /******************************************************************************
     METHOD PRINTING MESSAGE IN CONSOLE
     *****************************************************************************/

    /***
     * Print message
     * @param message
     */
    protected void logMessage(String message){
        System.out.println(message);
    }


    /******************************************************************************
     METHODS FOR WAITING PRESENCE OF SOME ELEMENTS
     *****************************************************************************/

    /***
     * waitPresenceOfElementByCSS
     * @param css
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByCSS (String css, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementById
     * @param id
     * @param seconds
     */
    protected WebElement waitPresenceOfElementById (String id, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementByXPath
     * @param xpath
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByXPath (String xpath, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementByLinkText
     * @param linkText
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByLinkText (String linkText, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /******************************************************************************
     METHODS FOR WAITING ELEMENT TO BE CLICKABLE
     *****************************************************************************/

    /***
     * waitElementToBeClickableById
     * @param id
     * @param seconds
     */
    protected WebElement waitElementToBeClickableById (String id, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.id(id)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByCSS
     * @param css
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByCSS (String css, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByXpath
     * @param xpath
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByXpath (String xpath, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByLinkText
     * @param linkText
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByLinkText (String linkText, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /******************************************************************************
     METHOD FOR CLOSE WEB DRIVER
     *****************************************************************************/

    /***
     * Close driver
     */
    protected void closeBrowser() {driver.close();}
}
