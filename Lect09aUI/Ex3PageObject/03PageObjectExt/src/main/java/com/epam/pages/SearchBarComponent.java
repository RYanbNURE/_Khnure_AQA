package com.epam.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search bar component")
@FindBy(id = "searchform")
public class SearchBarComponent {

    @Name("Search input box")
    @FindBy(name = "q")
    private TextInput searchInput;

    @Name("Search button")
    @FindBy(name = "btnK")
    private Button searchButton;

    public void search(String text) {
        searchInput.sendKeys(text);
        searchInput.submit(); // Alternatively use searchButton.click() if visible and necessary.
    }
}
