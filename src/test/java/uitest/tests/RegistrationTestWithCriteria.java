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
    public void emailTest() throws  IOException, MailosaurException {
        /*
         * Lets imagine the scenario where we have to test our registration form, or
         * more exactly the email that has been sent out to the user that registered for
         * our service. We expect that the email contains some text and a single link
         * that leads to the login dialog of users profile
         */

        WebDriver driver = getDriver();

        // Instantiate the Page Object and open the webpage
        RegistrationPo home = new RegistrationPo(driver);
        home.open("https://forms.aweber.com/form/82/482158182.htm");

        // Generate a random email address using the client librery
        String myRandomEmail = home.generateEmail();

        // Use the generated email to fill out the registration form
        home.typeIntoEmail(myRandomEmail).clickSubmit();
       
        // Confirm successful subscription
        Assert.assertEquals(home.getSubscriptionSuccessTextText(), "Thank you for subscribing!");

        // Get the confirmation link from the last recieved email that matches your search criteria 
        String linkText = home.getLinkTextWithCriteria();

        // Assert that the link points to the right address
        Assert.assertEquals(linkText, "http://www.demo.guru99.com/V4/");
    }

}
