package com.vytrack.utilities.ExtraUtils;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HigthLigth {
    /**
     * Highlighs an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element, String color) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: "+color+"; border: 2px solid red;');", element);
        Sleep.Zzz(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
