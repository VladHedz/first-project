package config.pageUrl;

public class Trello {

    public enum PageUrl {

        LOGIN_PAGE_TRELLO("https://id.atlassian.com/login");

        public final String url;

        PageUrl(String url) {
            this.url = url;
        }
    }
}