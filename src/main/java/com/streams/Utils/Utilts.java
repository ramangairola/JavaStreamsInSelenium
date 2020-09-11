package com.streams.Utils;

import com.streams.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Utilts extends BaseClass {

    /**
     * Return price
     * @name returnPrice
     * @param s
     * @return String
     */
    public String returnPrice(WebElement s) {
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }

    /**
     * Get screenshot and capture as Base64
     * @name captureAsBase64
     * @return String
     */
    public static String captureAsBase64()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
