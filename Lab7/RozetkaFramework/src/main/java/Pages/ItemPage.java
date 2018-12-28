package Pages;

import Extensions.ChromeDriverEx;
import Elements.Button;
import Elements.Label;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends Page{
    public ItemPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='g-price-uah']")
    @CacheLookup
    public Label price;

    @FindBy(name = "topurchasesfromcatalog")
    @CacheLookup
    public Button buy;

    public int getPrice(){
        System.out.println(price);
        String string_with_price = price.getText();
        string_with_price = string_with_price.replaceAll("[^\\d.]", "").replaceAll(" ", "");;
        System.out.println(string_with_price);
        return Integer.parseInt(string_with_price);
    }
}