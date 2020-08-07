package ru.Google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class Edu1 extends WDSett {
    @Test
    public void firstTest() {
        chromeDriver.get("https://www.google.ru/");
        PageObject g = new PageObject(chromeDriver);
        g.find("Гладиолус");
        Assertions.assertTrue(
                g.getNews().stream().anyMatch(x->x.getText().contains("Гладиолус")),"Нет Гладиолуса");
        //проверка что ссылок больше 3х
        Assertions.assertTrue(
                g.getNews().size()>=3, "Меньше 3х ссылок");

    }
    @Test
    public void trueTest() {
        chromeDriver.get("https://www.google.ru/");
        PageObject g = new PageObject(chromeDriver);
        g.find("Гладиолус");
        //положительный тест на ссылку википедии
        Assertions.assertTrue(
                g.getSnews().stream().anyMatch(x -> x.getText().contains("ru.wikipedia.org")), "Нет Гладиолуса");
    }

    @Test
    public void secondTest() {
        chromeDriver.get("https://www.google.ru/");
        PageObject g = new PageObject(chromeDriver);
        g.find("Гладиолус");
        //негатив тест на ссыль вики
        Assertions.assertTrue(
                g.getSnews().stream().anyMatch(x->x.getText().contains("Гладиолус — Википедия")),"Нет такой ссылки");
    }
}
