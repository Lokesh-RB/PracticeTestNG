package TestNGPayC;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Cookies {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://backoffice.chaincrm.io/"); // Replace with your URL

        // 1. Add a cookie
        Cookie cookie = new Cookie("myCookie", "cookieValue");
        driver.manage().addCookie(cookie);
        System.out.println("Cookie added: " + cookie);

        // 2. Get a specific cookie
        Cookie retrievedCookie = driver.manage().getCookieNamed("myCookie");
        System.out.println("Retrieved Cookie: " + retrievedCookie);

        // 3. Get all cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("All Cookies:");
        for (Cookie c : allCookies) {
            System.out.println(c);
        }

        // 4. Delete a specific cookie
        driver.manage().deleteCookieNamed("myCookie");
        System.out.println("Cookie 'myCookie' deleted.");

        // 5. Delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted.");

        // Close the browser
        driver.quit();
    }
  //khkgkhv 76576
    
}
