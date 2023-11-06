package pages;

import org.openqa.selenium.WebDriver;

public  class BasePage {
    public String url;
    protected WebDriver driver;
    public BasePage(WebDriver driver, String url){
        this.driver = driver;
        this.url=url;
    }

    public void navigateToPage(){
        driver.get(url);
    }

}
