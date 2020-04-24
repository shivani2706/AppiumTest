package Calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTesting {

    static AppiumDriver<MobileElement> objAD;

    public static void OpenCalc() throws MalformedURLException, Exception {


        // Combination of application and capabilties
        DesiredCapabilities objCap = new DesiredCapabilities();
        objCap.setCapability("deviceName","OnePlus5T");
        objCap.setCapability("udid","c9eaa947");
        objCap.setCapability("platformName","Android");
        objCap.setCapability("platformVersion","9");
        objCap.setCapability("appPackage","com.oneplus.calculator1.2.0");
        objCap.setCapability("appActivity","com.oneplus.calculator.Calculator");


        // appium server host
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        objAD = new AppiumDriver<MobileElement>(url,objCap);
        System.out.println("Success!");


        //locating elements by their IDs
        MobileElement digitFive = objAD.findElement(By.id("com.oneplus.calculator:id/digit_5"));
        MobileElement Plus = objAD.findElement(By.id("com.oneplus.calculator:id/op_add"));
        MobileElement digitThree = objAD.findElement(By.id("com.oneplus.calculator:id/digit_3"));
        MobileElement Equals = objAD.findElement(By.id("com.oneplus.calculator:id/eq"));
        MobileElement Result = objAD.findElement(By.className("android.widget.Button"));

        digitFive.click();
        Plus.click();
        digitThree.click();
        Equals.click();
        String strResult = Result.getText();
        System.out.println(strResult);

    }

    public  static void main (String[] args)
    {

        try {
            OpenCalc();
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
    }
}
