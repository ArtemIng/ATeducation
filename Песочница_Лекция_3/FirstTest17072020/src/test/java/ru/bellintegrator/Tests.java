package ru.bellintegrator;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "Тест сайта открытия")
    public void test1532919(){
        PageObjectGoogleWithSearch googleWithSearch = new PageObjectGoogleWithSearch(chromeDriver, "открытие");
        List<Map<String,Object>> resultSearch = googleWithSearch.getCollectResults();
        //resultSearch.stream().forEach(x-> System.out.println(x.get("NAME_PAGE").toString()));
        Steps.checkContainsName(resultSearch,"Банк «Открытие» — вклады, кредитные и дебетовые", chromeDriver);
        Steps.goPageText(googleWithSearch,"Банк «Открытие» — вклады, кредитные и дебетовые");
        PageObjectOpen open = new PageObjectOpen(chromeDriver);
        List<Map<String,String>> collectExchangeRates = open.getCollectExchangeRates();
        System.out.println(collectExchangeRates.size());
        System.out.println(collectExchangeRates);
        Steps.checkCourse("USD", open);

    }


    @Test
    public void checkTitle(){
        chromeDriver.get("http://www.bellintegrator.ru/");
        String title = chromeDriver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.contains("Bell Integrator"));
    }

    @Test
    public void checkKirill(){
        chromeDriver.get("https://bellintegrator.ru/index.php?route=product/search");
        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"input-search\"]"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"button-search\"]"));
        searchField.click();
        searchField.sendKeys("RPA");
        searchButton.click();

        List<WebElement> news = chromeDriver.findElements(By.xpath("//*[@class=\"product-layout product-list col-xs-12\"]//*[@class=\"short__desc\"]"));

        System.out.println(news.size());

        news.stream().forEach(x-> System.out.println(x.getText()));

        Assertions.assertTrue(news.stream().anyMatch(x->x.getText().contains("Кирилл Филенков")));

    }

    @Test
    public void testPO(){
        chromeDriver.get("https://bellintegrator.ru/index.php?route=product/search");
        PageObjectBell bellPO = new PageObjectBell(chromeDriver);
        bellPO.find("RPA");
        bellPO.refreshListOfElement();
        Assertions.assertTrue(bellPO.getNews().stream().anyMatch(x->x.getText().contains("Кирилл Филенков")));
    }

    @Test
    public void testPF(){
        chromeDriver.get("https://bellintegrator.ru/index.php?route=product/search");
        PageFsctoryBell bellPF = PageFactory.initElements(chromeDriver,PageFsctoryBell.class);
        bellPF.find("RPA");
        Assertions.assertTrue(bellPF.getNews().stream().anyMatch(x->x.getText().contains("Кирилл Филенков")));
    }

}
