// Ranorex Webtestit Test File

package uitest.tests;

import java.io.IOException;

import com.mailosaur.MailosaurException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.pageobjects.RegistrationPo;

class RegistrationTest extends TestNgTestBase {
    @Test
    public void testRegistration() throws IOException, MailosaurException {
        WebDriver driver = getDriver();
        /*
         * Lets imagine the scenario where we have to test our registration form, or
         * more exactly the email that has been sent out to the user that registered for
         * our service. We expect that the email contains some text and a single link
         * that leads to the login dialog of users profile
         */

        // Instantiate the Page Object and open the webpage
        RegistrationPo home = new RegistrationPo(driver);
        home.open("https://forms.aweber.com/form/82/482158182.htm");

        // Generate a rendom email using the mailosaur client
        String myRandomEmail = home.generateEmail();

        // Use the generated email to fill out the registration form
        home.typeIntoEmail(myRandomEmail).clickSubmit();

        // Confirm successful subscription
        Assert.assertEquals(home.getSubscriptionSuccessTextText(), "Thank you for subscribing!");

        // Get the link text from the last recieved email
        String linkText = home.getLinkText();

        // Assert that the link points to the right address
        Assert.assertTrue(linkText.contains("http://www.demo.guru99.com/V4/"));
    }

}
