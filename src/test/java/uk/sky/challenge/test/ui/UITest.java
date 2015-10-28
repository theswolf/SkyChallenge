package uk.sky.challenge.test.ui;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.sky.challenge.SkyChallenge;

import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkyChallenge.class)
@WebIntegrationTest("server.port:0")
public class UITest {

    //"//input[@type='checkbox' and @checked='checked']"

    @Value("${local.server.port}")
    int port;

    @Test
    public void testLondonProduct() {
        open("http://localhost:"+port+"/");
        $(By.name("customerSelection")).setValue("0");
        $(By.tagName("button")).click();
        ElementsCollection collection = $("body").findAll(By.tagName("input"));
        collection.shouldHave(size(4));
        Iterator<SelenideElement> iterator = collection.iterator();
        while(iterator.hasNext()) {
            SelenideElement currentElement = iterator.next();
            currentElement.click();
        }
        $(By.tagName("button")).click();
        $("body").findAll(By.tagName("li")).shouldHaveSize(4);
        $(By.id("customerID")).shouldBe(Condition.text("0"));
    }

    @Test
    public void testLiverpoolProduct() {
        open("http://localhost:"+port+"/");
        $(By.name("customerSelection")).setValue("1");
        $(By.tagName("button")).click();
        ElementsCollection collection = $("body").findAll(By.tagName("input"));
        collection.shouldHave(size(3));
        Iterator<SelenideElement> iterator = collection.iterator();
        while(iterator.hasNext()) {
            SelenideElement currentElement = iterator.next();
            currentElement.click();
        }
        $(By.tagName("button")).click();
        $("body").findAll(By.tagName("li")).shouldHaveSize(3);
        $(By.id("customerID")).shouldBe(Condition.text("1"));
    }

    @Test
    public void testOtherProduct() {
        open("http://localhost:"+port+"/");
        $(By.name("customerSelection")).setValue("2");
        $(By.tagName("button")).click();
        ElementsCollection collection = $("body").findAll(By.tagName("input"));
        collection.shouldHave(size(2));
        Iterator<SelenideElement> iterator = collection.iterator();
        while(iterator.hasNext()) {
            SelenideElement currentElement = iterator.next();
            currentElement.click();
        }
        $(By.tagName("button")).click();
        $("body").findAll(By.tagName("li")).shouldHaveSize(2);
        $(By.id("customerID")).shouldBe(Condition.text("2"));
    }

    @Test
    public void testError() {
        open("http://localhost:"+port+"/");
        $(By.name("customerSelection")).setValue("3");
        $(By.tagName("button")).click();
        $(By.id("errorText")).shouldBe(Condition.text("Problem retrieving data"));
    }
}
