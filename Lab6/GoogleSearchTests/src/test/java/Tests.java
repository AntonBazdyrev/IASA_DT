import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class Tests {
    private static ChromeDriverExtended driver;
    private final static String url = "https://www.google.com.ua";
    private String search;
    private String key;
    private boolean contains;

    public Tests(String key, String search, boolean contains) {
        this.key = key;
        this.search = search;
        this.contains = contains;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriverExtended();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void test_contains() throws Exception {
        driver.get(url);
        int page_number = 1;
        GoogleSearchPage result = new GoogleSearchPage(driver);
        result.enterSearchData(search);
        boolean flag = false;
        while (!flag){
            List<String> heads = result.getStringHeads();
            for (int i = 0; i < heads.size(); i++) {
                if (heads.get(i).contains(key) == contains) {
                    if (contains){
                        flag = true;
                        try{
                            FileWriter writer = new FileWriter("Log/result_" + key + "_" + search + ".txt");
                            writer.write("We have found your key: " + key + "\n");
                            writer.write(String.format("Page number: %d \n ", page_number));
                            writer.write(String.format("That was in result number %d \n", i));
                            writer.close();
                        } catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    result.get_screenshot("Screenshots/" + String.format("task_%s_%s_%d.png", search, key, page_number));

                }
            }
            result = result.next_page();
            if (result == null){
                flag = true;
                System.out.println("No more results for your request, we haven't found your key: "+ key);
            }
            page_number += 1;
        }
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"reverb", "les paul", true}, {"gibson", "les paul", true}, {"mmsa", "les paul", false}};
        return Arrays.asList(data);
    }
}