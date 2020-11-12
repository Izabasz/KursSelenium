package zadanie2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Katalon-test
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void fillFormTest() {
        // znajdź i wypełnij First name
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Karol");

        //znajdź i wypełnij Last name
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Kowalski");

        // Wybierz male
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        maleRadioButton.click();

        //Znajdź i wypełnij date of birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dob"));
        dateOfBirthInput.sendKeys("05/22/2010");

        //Znajdź i wypełnij address
        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("Prosta 51");

        //Znajdź i wypełnij adres email
        WebElement addressEmail = driver.findElement(By.id("email"));
        addressEmail.sendKeys("karol.kowalski@mailinator.com");

        //Znajdź i wypełnij password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Pass123");

        //Znajdź i wypełnij Company
        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Coders Lab");

        //Select role
        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");

        //Job expectation
        Select jobExpectationDropdown = new Select(driver.findElement(By.id("expectation")));
        jobExpectationDropdown.selectByVisibleText("Challenging");

        //Ways of development
        WebElement developmentButton = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[11]/div/div[1]/label"));
        developmentButton.click();
        WebElement developmentButton2 = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[11]/div/div[2]/label"));
        developmentButton2.click();

        //Znajdź i wypełnij Comment
        WebElement comment = driver.findElement(By.id("comment"));
        comment.sendKeys("To jest mój pierwszy automat testowy");

        driver.findElement(By.id("submit")).click();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}