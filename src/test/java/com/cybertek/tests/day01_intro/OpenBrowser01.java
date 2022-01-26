package com.cybertek.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser01 {

    public static void main(String[] args) {

        // have to enter this line everytime want to open Chrome
        WebDriverManager.chromedriver().setup();

        // create chrome driver object for Chrome browser
        // new ChromeDriver() ==> this part will open Chrome browser
        WebDriver driver = new ChromeDriver();

        // call method with the driver object from Driver class
        // execute url in empty Chrome browser
        // navigating code
        driver.get("https://cydeo.com");
    }
}
