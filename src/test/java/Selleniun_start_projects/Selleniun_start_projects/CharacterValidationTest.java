/**
 * Hello world!
 *
 */

/*
 *		    שמות סטודנטים:
 *		    נגים אלדין זועבי 324887983
			אחמד זועבי       213027667

 */



package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CharacterValidationTest {
	static WebDriver browser;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
    }

    @AfterClass
    public static void teardown() {
        if (browser != null) {
            browser.quit();
        }
    }

    @Test
    public void testValidInput() {
        // Test case: Valid input (abcdefg)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("abcdefg");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Valid Value", validationMessage);
    }

    @Test
    public void testTooShortInput() {
        // Test case: Too short input (abc)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("abc");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Invalid Value", validationMessage);
    }

    @Test
    public void testTooLongInput() {
        // Test case: Too long input (abcdefgh)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("abcdefgh");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Valid Value", validationMessage);
    }

    @Test
    public void testMixedValidInput() {
        // Test case: Mixed valid input (abc123!)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("abc123!");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Invalid Value", validationMessage);
    }

    @Test
    public void testEmptyInput() {
        // Test case: Empty input
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Invalid Value", validationMessage);
    }

    @Test
    public void testNumericInput() {
        // Test case: Numeric input (1234567)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("1234567");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Valid Value", validationMessage);
    }

    @Test
    public void testSpecialCharactersInput() {
        // Test case: Special characters input (@@@@@@@)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("@@@@@@@");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Invalid Value", validationMessage);
    }

    @Test
    public void testInputWithSpaces() {
        // Test case: Input with spaces (a b c d e f)
        WebElement inputBox = browser.findElement(By.name("characters"));
        inputBox.clear();
        inputBox.sendKeys("a b c d e f");

        browser.findElement(By.name("validate")).click();
        WebElement result = browser.findElement(By.name("validation_message"));
        String validationMessage = result.getAttribute("value");
        assertEquals("Invalid Value", validationMessage);
    }
}
