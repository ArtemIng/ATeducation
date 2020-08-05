package ru.bellintegrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectBell {

    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> news;

    PageObjectBell(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@id=\"input-search\"]"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"button-search\"]"));
    }

    public List<WebElement> getNews() {
        return news;
    }

    public void find(String keyWord){
        searchField.click();
        searchField.sendKeys(keyWord);
        searchButton.click();
    }

    public void refreshListOfElement(){
        news = chromeDriver.findElements(By.xpath("//*[@class=\"product-layout product-list col-xs-12\"]//*[@class=\"short__desc\"]"));
    }

}
