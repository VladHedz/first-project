package lesson10.GoogleTranslation;

import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTranslationTest {

    private WebDriver driver;

    private final String[][] expectedTranslations = {
            {"en", "I will study TESTNG cool"},
            {"es", "Estudiaré testng genial"},
            {"fr", "J'étudierai le test."},
            {"ga", "Déanfaidh mé staidéar ar Testng Cool"},
            {"is", "Ég mun læra testng flott"},
            {"it", "Studierò Testng Cool"},
            {"yo", "Emi yoo ṣe iwadi itura itura"},
            {"kk", "Мен тестілеуді керемет түрде оқимын"},
            {"kn", "ನಾನು ಟೆಸ್ಟ್ ಅನ್ನು ತಂಪಾಗಿ ಅಧ್ಯಯನ ಮಾಡುತ್ತೇನೆ"},
            {"qu", "Estudiasaqmi prueba de cool ."},
            {"ky", "Мен Testng Cool"},
            {"gom", "हांव testng cool अभ्यास करतलों ."},
            {"ko", "나는 테스트를 시원하게 공부할 것이다"},
            {"co", "Studiaraghju Testng Cool"},
            {"mt", "Se nistudja testng cool"},
            {"mi", "Ka akohia e au te whakamatautau"},
            {"mr", "मी टेस्टंग कूलचा अभ्यास करेन"},
            {"lus", "Ka zir dawn a ni testng cool ."},
            {"mn", "Би тестнийг судлах болно"},
            {"de", "Ich werde testng cool studieren"},
    };

    private static final String GOOGLE_TRANSLATE_URL = "https://translate.google.com/?sl=uk&tl=";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/hedz.vladyslav/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "languages")
    @Name("Check translate")
    public void testTranslation(String targetLanguage, String expectedTranslation) {
        String url = GOOGLE_TRANSLATE_URL + targetLanguage + "&text=Я%20круто%20вивчу%20TestNG&op=translate";
        driver.get(url);

        WebElement translatedTextElement = driver.findElement(By.cssSelector("[jsname='jqKxS']"));
        String translatedText = translatedTextElement.getText();

        Assert.assertEquals(translatedText, expectedTranslation, "Translation failed for language: " + targetLanguage);
    }

    @DataProvider(name = "languages")
    public Object[][] getLanguages() {
        return expectedTranslations;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}