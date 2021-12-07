package ru.netology.web;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OrderingCardDelivery {


    @Test
    public void shouldOrderingCardDelivery() {
        open("http://localhost:9999");
        ElementsCollection lines = $$("[class='input__control']");
        lines.get(0).setValue("Москва");
        
        String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        lines.get(1).doubleClick().sendKeys(Keys.BACK_SPACE);
        lines.get(1).setValue(date);
        lines.get(2).setValue("Иванов Иван");
        lines.get(3).setValue("+74955105555");
        $("[data-test-id='agreement']").click();
        $("[class='button__content']").click();
        $("[class='notification__content']").shouldHave(text("Встреча успешно"), Duration.ofSeconds(16));
    }
}
