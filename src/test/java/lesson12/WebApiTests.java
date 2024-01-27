package lesson12;

import org.testng.annotations.Test;

public class WebApiTests {

    private final BooksApi booksApi = new BooksApi();

    @Test
    public void findBookTest() throws Exception {
        var bookName = "Василь Симоненко: Задивляюсь у твої зіниці";
        var searchResult = booksApi.searchBooksByName(bookName);

        var item = searchResult.results.itemGroups.stream()
                .filter(result -> result.items.stream().findFirst().get().get(0).name.equals(bookName)).findFirst()
                .orElseThrow(() -> new AssertionError(bookName + "not present"));
    }
}