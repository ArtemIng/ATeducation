package ru.bellintegrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFsctoryBell {
    private WebDriver chromeDriver;

    @FindBy(how= How.ID, id="input-search")
    WebElement searchField;

    @FindBy(how= How.ID, id="button-search")
    WebElement searchButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@class=\"product-layout product-list col-xs-12\"]//*[@class=\"short__desc\"]"))
    List<WebElement> news;

    public PageFsctoryBell(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }

    public List<WebElement> getNews() {
        return news;
    }

    public void find(String keyWord){
        searchField.click();
        searchField.sendKeys(keyWord);
        searchButton.click();
    }
}
