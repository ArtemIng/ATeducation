package ru.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObject {private WebDriver chromeDriver;
    WebElement searchField;
    WebElement searchButton;
    List<WebElement> news;

    public List<WebElement> getNews() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"g\"]//*[@class=\"s\"]"));
        //return chromeDriver.findElements(By.xpath("//*[@class=\"product-layout product-list col-xs-12\"]//*[@class=\"short__desc\"]"));
    }

    public List<WebElement> getSnews() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"g\"]//*[@class=\"r\"]"));
    }

    PageObject(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
    }

    public void find(String wordFind){
        searchField.click();
        searchField.sendKeys(wordFind);
        searchButton.click();
    }

}
