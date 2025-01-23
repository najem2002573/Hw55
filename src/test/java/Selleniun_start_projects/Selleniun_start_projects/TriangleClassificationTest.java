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

public class TriangleClassificationTest {

    static WebDriver browser;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
    }

    @AfterClass
    public static void teardown() {
        if (browser != null) {
            browser.quit();
        }
    }

    @Test
    public void testEquilateralTriangle() {
        // Input values for an equilateral triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("3");
        browser.findElement(By.id("side2")).sendKeys("3");
        browser.findElement(By.id("side3")).sendKeys("3");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();
 // Change to correct locator if needed

        // Validate the result
        WebElement result = browser.findElement(By.id("triangle-type"));
        assertEquals("Equilateral", result.getText());
    }

    @Test
    public void testIsoscelesTriangle() {
        // Input values for an isosceles triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("5");
        browser.findElement(By.id("side2")).sendKeys("5");
        browser.findElement(By.id("side3")).sendKeys("3");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Isosceles", resultText);
    }

    @Test
    public void testScaleneTriangle() {
        // Input values for a scalene triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("4");
        browser.findElement(By.id("side2")).sendKeys("5");
        browser.findElement(By.id("side3")).sendKeys("6");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Scalene", resultText);
    }
    @Test
    public void invalid() {
        // Input values for a scalene triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("1");
        browser.findElement(By.id("side2")).sendKeys("3");
        browser.findElement(By.id("side3")).sendKeys("4");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Error: Not a Triangle", resultText);
    }
    @Test
    public void invalid1() {
        // Input values for a scalene triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("3");
        browser.findElement(By.id("side2")).sendKeys("4");
        browser.findElement(By.id("side3")).sendKeys("10");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Error: Not a Triangle", resultText);
    }
    @Test
    public void invalid4() {
        // Input values for a scalene triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("0");
        browser.findElement(By.id("side2")).sendKeys("0");
        browser.findElement(By.id("side3")).sendKeys("0");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Error: Not a Triangle", resultText);
    }
    
    
    //scalene but different order
    @Test
    public void scalene2() {
        // Input values for a scalene triangle
    	browser.findElement(By.id("side1")).clear();
    	browser.findElement(By.id("side2")).clear();
    	browser.findElement(By.id("side3")).clear();
        browser.findElement(By.id("side1")).sendKeys("6");
        browser.findElement(By.id("side2")).sendKeys("4");
        browser.findElement(By.id("side3")).sendKeys("5");

        // Click calculate button
        browser.findElement(By.id("identify-triangle-action")).click();


        // Get the result and verify
        WebElement result = browser.findElement(By.id("triangle-type"));
        String resultText = result.getText();
        assertEquals("Scalene", resultText);
    }
}
