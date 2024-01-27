package config.PageUrl;

public class Imdb {
    public enum PageUrl {

        IMDB_URL("https://www.imdb.com");

        public final String url;

        PageUrl(String url) {
            this.url = url;
        }
    }
}
