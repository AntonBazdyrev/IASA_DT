package Pages;

import Extensions.ChromeDriverEx;
import Elements.Button;
import Elements.Label;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page{
    public CartPage(ChromeDriverEx driver) {
        super(driver);
    }

    @FindBy(id = "popup-checkout")
    @CacheLookup
    public Button validate;

    @FindBy(name = "cost")
    @CacheLookup
    public Label price;

    public int getPrice(){
        String stringValue = price.getText();
        return Integer.parseInt(stringValue);
    }
}