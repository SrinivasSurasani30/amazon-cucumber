package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {

    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By firstProduct = By.cssSelector("div[data-component-type='s-search-result'] h2 a");
    By cartCount = By.id("nav-cart-count");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAmazon() {
        driver.get("https://www.amazon.in/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public void openFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public boolean isCartUpdated() {
        return Integer.parseInt(driver.findElement(cartCount).getText()) > 0;
    }
}
