import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginDriver {

    WebDriver driver;

    @Before
    public void inicialiar(){

        System.setProperty("webdriver.edge.driver","C:\\Users\\paulo\\Documents\\Projetos\\Drivers\\chromedriver\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://bugbank.netlify.app/");
    }

    @Test
    public void validarComUsuarioESenhaInvalidos() {

        driver.findElement(By.xpath("//div[@class='card__login']//input[@type='email']")).sendKeys("teste@teste.com");
        driver.findElement(By.xpath("//div[@class='card__login']//input[@type='password']")).sendKeys("teste");
        driver.findElement(By.xpath("//div[@class='login__buttons']//button[@type='submit']")).click();

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@class='styles__ContainerInformations-sc-8zteav-3 fQkeSa']//p"))));
        Assert.assertEquals("Usuário ou senha inválido.\n" +
                "Tente novamente ou verifique suas informações!", element.getText());

    }

    @After
    public void finalizar(){
        driver.close();
        driver.quit();
    }

}

