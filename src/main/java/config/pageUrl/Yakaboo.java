package config.pageUrl;

public class Yakaboo {
    public enum pageUrl {

        WELCOME_PAGE_YAKABOO("https://www.yakaboo.ua/");

        public final String url;

        pageUrl(String url) {
            this.url = url;
        }
    }
}