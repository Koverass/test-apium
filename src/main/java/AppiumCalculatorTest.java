import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.net.URL;
import java.time.Duration;

public class AppiumCalculatorTest {
    public static void main(String[] args) throws Exception {
        // Configuración de capacidades
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("automationName", "UiAutomator2");


        // Inicializar AndroidDriver (¡sin diamante <>!)
        AndroidDriver driver = new AndroidDriver(
                new URL("http://localhost:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Ejecutar suma 2 + 3
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        // Obtener y mostrar resultado
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        System.out.println("✅ Resultado: " + result.getText());

        driver.quit();
    }
}
