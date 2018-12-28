package Contexts;

import org.testng.Assert;
import Pages.DeliveryPage;

public class ElementIsEnabledContext {
    public static void verifyPurchaseButtonIsEnabled(DeliveryPage page){
        Assert.assertTrue(page.purchaseButton.isEnabled());
    }
}
