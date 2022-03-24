package selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void busquedaPhoenixTest() {

        String email = "sdhjsd" + Math.floor(Math.random()*(999999-1+1)+1) + "@gmail.com";
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(719, 697));
        driver.findElement(By.cssSelector("#homefeatured > .ajax_block_product:nth-child(1) .button:nth-child(1) > span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,\'Proceed to checkout\')]")));
        driver.findElement(By.cssSelector(".button-medium > span")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.xpath("//form/div/div[2]")).click();
        String emailIngresado = driver.findElement(By.id("email_create")).getAttribute("value");
        assertEquals(email, emailIngresado);
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        WebElement element = driver.findElement(By.cssSelector("#SubmitCreate > span"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id=\'account-creation_form\']/div/div[4]/input")));
        String emailLogin = driver.findElement(By.xpath("//form[@id=\'account-creation_form\']/div/div[4]/input")).getAttribute("value");
        //Validacion de correo
        assertEquals(email, emailLogin);
        driver.findElement(By.cssSelector(".radio-inline:nth-child(3) > .top")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("R");
        driver.findElement(By.id("customer_lastname")).sendKeys("L");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("days")).click();
        driver.findElement(By.cssSelector("#days > option:nth-child(2)")).click();
        driver.findElement(By.id("months")).click();
        driver.findElement(By.cssSelector("#months > option:nth-child(2)")).click();
        driver.findElement(By.id("years")).click();
        driver.findElement(By.cssSelector("#years > option:nth-child(2)")).click();
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).sendKeys("Prueba");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).sendKeys("Test 1019");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("id_state")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_state"));
            dropdown.findElement(By.xpath("//option[. = 'Arizona']")).click();
        }
        driver.findElement(By.cssSelector("#id_state > option:nth-child(4)")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys("34873");
        driver.findElement(By.id("other")).click();
        driver.findElement(By.id("other")).sendKeys("informacion");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("894598459");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).sendKeys("327623727");
        driver.findElement(By.id("alias")).click();
        String stateCreate = driver.findElement(By.cssSelector("#id_state > option:nth-child(4)")).getText();
        String firstnameCreate = driver.findElement(By.id("customer_firstname")).getAttribute("value");
        String lastnameCreate = driver.findElement(By.id("customer_lastname")).getAttribute("value");
        String companyCreate = driver.findElement(By.id("company")).getAttribute("value");
        String addres1Create = driver.findElement(By.id("address1")).getAttribute("value");
        String cityCreate = driver.findElement(By.id("city")).getAttribute("value");
        String postcodeCreate = driver.findElement(By.id("postcode")).getAttribute("value");
        String phoneCreate = driver.findElement(By.id("phone")).getAttribute("value");
        String phoneMobileCreate = driver.findElement(By.id("phone_mobile")).getAttribute("value");
        driver.findElement(By.id("id_country")).click();
        String countryCreate = driver.findElement(By.cssSelector("#id_country > option:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("#submitAccount .icon-chevron-right")).click();
        //Validacion de Address
        String addressFirstname = driver.findElement(By.cssSelector("#address_delivery > .address_firstname")).getText();
        assertEquals(firstnameCreate + " " + lastnameCreate, addressFirstname);
        String addressCompany = driver.findElement(By.cssSelector("#address_delivery > .address_company")).getText();
        assertEquals(companyCreate, addressCompany);
        String addresAddress1 = driver.findElement(By.cssSelector("#address_delivery > .address_address1")).getText();
        assertEquals(addres1Create, addresAddress1);
        String addressCity = driver.findElement(By.cssSelector("#address_delivery > .address_city")).getText();
        assertEquals(cityCreate + ", " + stateCreate + " " + postcodeCreate, addressCity);
        String addressCountryName = driver.findElement(By.cssSelector("#address_delivery > .address_country_name")).getText();
        assertEquals(countryCreate, addressCountryName);
        String addressPhone = driver.findElement(By.cssSelector("#address_delivery > .address_phone")).getText();
        assertEquals(phoneCreate, addressPhone);
        String addressPhoneMobile = driver.findElement(By.cssSelector("#address_delivery > .address_phone_mobile")).getText();
        assertEquals(phoneMobileCreate, addressPhoneMobile);
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.cssSelector(".bankwire > span")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
        String mensajeFinal = driver.findElement(By.cssSelector(".cheque-indent > .dark")).getText();
        assertEquals("Your order on My Store is complete.", mensajeFinal);
    }
}
