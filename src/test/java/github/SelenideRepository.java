package github;

//import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class SelenideRepository {


    @Test
    void shouldFindSelenideAsRepository() {

        //открыть страницу гита
        open("https://github.com/");
        //сделать поиск по слову selenide
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //открыть первую ссылку в поиске
        $$("ul.repo-list li").first().$("a").click();
        //открыть wiki проекта
        $("#wiki-tab").click();
        //кликнуть по "показать еще 2 страницы"
        $(byText("Show 2 more pages…")).click();
        //кликнуть по SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //убедиться, что на странице есть раздел с кодом для JUnit5
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
    }
}