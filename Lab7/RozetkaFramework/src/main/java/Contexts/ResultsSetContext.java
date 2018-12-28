package Contexts;

import Pages.ItemPage;
import Pages.SledgesPage;

public class ResultsSetContext {
    public static ItemPage selectElement(SledgesPage page, int elementIndex){
        page.resultSet.get(elementIndex).click();
        return new ItemPage(page.getDriver());
    }
}
