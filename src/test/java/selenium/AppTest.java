package selenium;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void busquedaHandBookTest()
    {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(720, 691));
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("handbook devops");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.xpath("//div[@id=\'rso\']/div/div/div/div/div/div[2]/div/a/g-img/div")).click();
        assertTrue(driver.getTitle().contains("The DevOps Handbook"));
    }

    @Test
    public void busquedaPhoenixTest()
    {
        driver.get("https://www.amazon.com/");
        driver.manage().window().setSize(new Dimension(720, 692));
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the phoenix project");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(bodyText.contains("The Phoenix Project: A Novel about IT"));
    }
}
