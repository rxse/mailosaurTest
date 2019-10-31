// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.io.IOException;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPo {
    // Additional data:
    // {"img":"screenshots/f1d95fce-2365-b87d-2c4c-a1d3ded7e415.png"}
    private By emailField = By.cssSelector("input[name='email']");
    // Additional data:
    // {"img":"screenshots/066842b0-8341-b735-7da9-1777279aa93b.png"}
    private By submitButton = By.cssSelector("input[alt='Submit Form']");
    // Additional data: {"img":"screenshots/5f5fe4d4-8901-62c9-73a3-2d8b085ea087.png"}
    private By subscriptionSuccessText = By.cssSelector("h2");

    /*
     * NOTE: Use Ranorex Selocity or the Elements Panel to generate element code
     */

    protected WebDriver driver;
    protected WebDriverWait wait;
    private MailosaurClient mailosaurClient;

    // Enter your mailosaur API and ServerID below:
    private String mailosaurAPIKey = System.getenv("mailosaurAPIKey");
    private String mailosaurServerID = System.getenv("mailosaurServerID");

    public RegistrationPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        // Instantiate the mailosaur client
        this.mailosaurClient = new MailosaurClient(this.mailosaurAPIKey);

    }

    // Generate random email address
    public String generateEmail() {
        String email = this.mailosaurClient.servers().generateEmailAddress(this.mailosaurServerID);
        return email;
    }

    // Get the last email and return the registration link text from it
    public String getLinkText() throws IOException, MailosaurException {
        String msg = this.mailosaurClient.messages().list(this.mailosaurServerID).items().get(0).id();
        String linkText = this.mailosaurClient.messages().get(msg).html().links().get(0).text();
        return linkText;

    }

    // Get the email with specified criteria and return the registration link text
    public String getLinkTextWithCriteria() throws IOException, MailosaurException {
        // Specify a search criteria (e.g. with specific email subject)
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSubject("Day 1: Project Kickoff!");
        // Provide your search criteria, get the email that matches the criteria and
        // return the link Text
        Message message = mailosaurClient.messages().waitFor(this.mailosaurServerID, criteria);
        String linkText = message.html().links().get(0).text();
        return linkText;

    }

    public RegistrationPo open(String url) {
        this.driver.get(url);

        return this;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public RegistrationPo typeIntoEmail(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailField)).sendKeys(text);

        return this;
    }

    public RegistrationPo clickSubmit() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.submitButton)).click();

        return this;
    }

    public String getSubscriptionSuccessTextText() {
        String subscriptionSuccessTextText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.subscriptionSuccessText)).getText();
    
        
        return subscriptionSuccessTextText;
    }
    
    /*
     * NOTE: Drag elements from the Elements panel into the code editor to generate
     * methods. Drag elements into existing methods to add steps.
     */

}
