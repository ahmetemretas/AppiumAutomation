package com.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRunner {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test() throws InterruptedException, MalformedURLException {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\foreks.android_158_apps.evozi.com.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20000);
            driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
            Thread.sleep(6000);

            WebElement kapat = driver.findElement(MobileBy.AccessibilityId("Kapat"));
            kapat.click();
            Thread.sleep(2000);

            WebElement sayfam = driver.findElement(MobileBy.AccessibilityId("SAYFAM"));
            Assert.assertTrue(sayfam.isDisplayed());
            Thread.sleep(2000);

            WebElement varyant = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView"));
            varyant.click();
            Thread.sleep(2000);

            driver.navigate().back();

            WebElement y??kselenlerD????enler = driver.findElement(MobileBy.AccessibilityId("Y??kselenler / D????enler"));
            y??kselenlerD????enler.click();
            Thread.sleep(2000);

            WebElement Y??KSELENLERd????enler = driver.findElement(MobileBy.AccessibilityId("Y??KSELENLER / D????ENLER"));
            Assert.assertTrue(Y??KSELENLERd????enler.isDisplayed());
            Thread.sleep(2000);

            WebElement birinciSubTab = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[7]"));
            WebElement ikinciSubTab = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[8]"));
            WebElement ??????nc??SubTab = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[9]"));
            Assert.assertEquals("Al????",birinciSubTab.getText());
            Assert.assertEquals("Sat????",ikinciSubTab.getText());
            Assert.assertEquals("%Fark",??????nc??SubTab.getText());

            WebElement y??kselenler = driver.findElement(MobileBy.AccessibilityId("Y??kselenler"));
            Assert.assertTrue(y??kselenler.isSelected());

            farklarArtan();

            Thread.sleep(3000);

            WebElement d????enler = driver.findElement(MobileBy.AccessibilityId("D????ENLER"));
            d????enler.click();
            Thread.sleep(2000);
            Assert.assertTrue(d????enler.isSelected());

            Thread.sleep(2000);

            farklarAzalan();

            driver.closeApp();
    }

    public void farklarArtan(){

            boolean flag = true;
            WebElement ilk, ikinci ;
            String ilk1,ikinci2;
            for (int i = 1; i < 10; i++) {
                    ilk = driver.findElement(By.xpath("(//*[@resource-id='foreks.android:id/rowWarrantSymbolList_textView_column3'])["+i+"]"));
                    ikinci = driver.findElement(By.xpath("(//*[@resource-id='foreks.android:id/rowWarrantSymbolList_textView_column3'])["+(i+1)+"]"));
                    ilk1=ilk.getText();
                    ikinci2=ikinci.getText();
                    ilk1=ilk1.substring(1,ilk1.length()-1);
                    ikinci2=ikinci2.substring(1,ikinci2.length()-1);
                    ilk1=ilk1.replace(",","");
                    ikinci2=ikinci2.replace(",","");
                    ilk1=ilk1.replaceFirst("[.]","");
                    ikinci2=ikinci2.replaceFirst("[.]","");
                    if (Integer.parseInt(ilk1) >= Integer.parseInt(ikinci2)){
                            flag = true;
                    }else {
                            flag=false;
                    }
                    Assert.assertTrue("Farklar s??ral?? de??il",flag);
            }
        return;
    }

        public void farklarAzalan(){
                boolean flag = true;
                WebElement ilk, ikinci ;
                String ilk1,ikinci2;
                for (int i = 1; i < 10; i++) {
                        ilk = driver.findElement(By.xpath("(//*[@resource-id='foreks.android:id/rowWarrantSymbolList_textView_column3'])["+i+"]"));
                        ikinci = driver.findElement(By.xpath("(//*[@resource-id='foreks.android:id/rowWarrantSymbolList_textView_column3'])["+(i+1)+"]"));
                        ilk1=ilk.getText();
                        ikinci2=ikinci.getText();
                        ilk1=ilk1.substring(1);
                        ikinci2=ikinci2.substring(1);
                        ilk1=ilk1.replace(",",".");
                        ikinci2=ikinci2.replace(",",".");
                        ilk1=ilk1.replaceFirst("[.]","");
                        ikinci2=ikinci2.replaceFirst("[.]","");
                        if (Integer.parseInt(ilk1) <= Integer.parseInt(ikinci2)){
                                flag = true;
                        }else {
                                flag=false;
                        }
                        Assert.assertTrue("Farklar s??ral?? de??il",flag);
                }
                return;
        }
}
