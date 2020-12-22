package ru.selenium.training.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.selenium.training.ApplicationManager;
import ru.selenium.training.TestBase;

import java.util.List;

public class CheckDescriptionOfProductTest extends TestBase {

    final By campaignArticlesListLocatorMP = By.cssSelector("section#box-campaign-products div.listing.products a");
    final By campaignArticleNameLocator = By.cssSelector("#box-campaign-products article.product-column h4");
    final By articleOldPriceLocatorMainPage = By.cssSelector("#box-campaign-products article.product-column del.regular-price");
    final By articleNewPriceLocatorMainPage = By.cssSelector("#box-campaign-products article.product-column strong.campaign-price");
    final By articleNameOnProductPageLocator = By.cssSelector("#box-product h1.title");
    final By articleOldPriceProductPageLocator = By.cssSelector("#box-product del.regular-price");
    final By articleNewPriceProductPageLocator = By.cssSelector("#box-product strong.campaign-price");

    @Test
    public void checkAttributesEquivalenceOfProduct() {

        app.openLitecartMall();

        List<WebElement> campaignArticle = ApplicationManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(campaignArticlesListLocatorMP));
        for (int i = 0; i < campaignArticle.size(); i++) {

            String articleNameMainPageText = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(campaignArticleNameLocator)).getText();

            WebElement articleOldPriceMainPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceLocatorMainPage));
            String articleOldPriceMainPageText = articleOldPriceMainPage.getText();

            WebElement articleNewPriceMainPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceLocatorMainPage));
            String articleNewPriceMainPageText = articleNewPriceMainPage.getText();

            campaignArticle.get(i).click();
            String articleNameOnProductPageText = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNameOnProductPageLocator)).getText();

            WebElement articleOldPriceOnProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceProductPageLocator));
            String articleOldPriceOnProductPageText = articleOldPriceOnProductPage.getText();

            WebElement articleNewPriceOnProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceProductPageLocator));
            String articleNewPriceOnProductPageText = articleNewPriceOnProductPage.getText();

            System.out.println("Check elements on the main page and the page of the product: ");

            if (articleNameMainPageText.equals(articleNameOnProductPageText)) {
                System.out.println("-> compare name " + articleNameMainPageText + " with " + articleNameOnProductPageText + ": OK");
            } else {
                System.out.println("-> compare name " + articleNameMainPageText + " with " + articleNameOnProductPageText + ": NOK");
            }

            if (articleOldPriceMainPageText.equals(articleOldPriceOnProductPageText)) {
                System.out.println("-> compare old price " + articleOldPriceMainPageText + " with " + articleOldPriceOnProductPageText + ": OK");
            } else {
                System.out.println("-> compare old price " + articleOldPriceMainPageText + " with " + articleOldPriceOnProductPageText + ": NOK");
            }

            if (articleNewPriceMainPageText.equals(articleNewPriceOnProductPageText)) {
                System.out.println("-> compare new price " + articleNewPriceMainPageText + " with " + articleNewPriceOnProductPageText + ": OK");
            } else {
                System.out.println("-> compare new price " + articleNewPriceMainPageText + " with " + articleNewPriceOnProductPageText + ": NOK");
            }
        }

    }

    @Test
     public void checkAttributesOfProductOnMainPage() {

        app.openLitecartMall();
        List<WebElement> campaignArticle = ApplicationManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(campaignArticlesListLocatorMP));
        //article = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleLocator));
        System.out.println("");
        System.out.println("Color and style on the main page:");

        for (int i = 0; i < campaignArticle.size(); i++) {

            String articleOldPriceColorMainPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceLocatorMainPage)).getCssValue("color");

            System.out.println("Color of old price: " + articleOldPriceColorMainPage);
            // совпадение с серым цветом  - add
            defineColor(articleOldPriceColorMainPage);

            String articleNewPriceColorMainPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceLocatorMainPage)).getCssValue("color");
            System.out.println("Color of old price: " + articleNewPriceColorMainPage);
            // совпадение с красным цветом  - add
            defineColor(articleNewPriceColorMainPage);

            //check text sizes
            String oldPriceMainPageSize = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceLocatorMainPage)).getCssValue("font-size");
            String newPriceMainPageSize = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceLocatorMainPage)).getCssValue("font-size");

            double oldPriceMainPageSizeDouble = convertFontSizeToDouble(oldPriceMainPageSize);
            double newPriceMainPageSizeDouble = convertFontSizeToDouble(newPriceMainPageSize);

            System.out.println("Check text size: old price size (px): " + oldPriceMainPageSizeDouble + "; new price size (px): " + newPriceMainPageSizeDouble);
            if (newPriceMainPageSizeDouble > oldPriceMainPageSizeDouble) {
                System.out.println("New price size text larger than old price size text: OK");
            } else {
                System.out.println("New price size text less or equal to old price size text : NOK");
            }

            //Check strike
            String fontStyleMP = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceLocatorMainPage)).getCssValue("text-decoration-line");
            checkFontIsStrikeout(fontStyleMP);

            //Check bold
            String fontWeightMP = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceLocatorMainPage)).getCssValue("font-weight");
            checkFontIsBold(fontWeightMP);
        }
    }

    @Test
     public void checkAttributesOfProductOnProductPage() {

        app.openLitecartMall();
        System.out.println("Color and style on the product page:");
        List<WebElement> campaignArticle = ApplicationManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(campaignArticlesListLocatorMP));

        for (int i = 0; i < campaignArticle.size(); i++) {
            campaignArticle.get(i).click();
            String articleOldPriceColorProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceProductPageLocator)).getCssValue("color");

            System.out.println("Color of old price: " + articleOldPriceColorProductPage);
            // совпадение с серым цветом  - add
            defineColor(articleOldPriceColorProductPage);

            String articleNewPriceColorProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceProductPageLocator)).getCssValue("color");
            System.out.println("Color of old price: " + articleNewPriceColorProductPage);
            // совпадение с красным цветом  - add
            defineColor(articleNewPriceColorProductPage);

            //check text sizes
            String oldPriceSizeProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceProductPageLocator)).getCssValue("font-size");
            String newPriceSizeProductPage = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceProductPageLocator)).getCssValue("font-size");

            double oldPriceSizeProductPageDouble = convertFontSizeToDouble(oldPriceSizeProductPage);
            double newPriceSizeProductPageDouble = convertFontSizeToDouble(newPriceSizeProductPage);
            System.out.println("Check text size: old price size (px): " + oldPriceSizeProductPageDouble + "; new price size (px): " + newPriceSizeProductPageDouble);

            if (newPriceSizeProductPageDouble > oldPriceSizeProductPageDouble) {
                System.out.println("New price size text larger than old price size text: OK");
            } else {
                System.out.println("New price size text less or equal to old price size text : NOK");
            }
        }

        //Check strike
        String priceFontStylePP = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleOldPriceProductPageLocator)).getCssValue("text-decoration-line");
        checkFontIsStrikeout(priceFontStylePP);

        //Check bold
        String priceFontWeightPP  = ApplicationManager.wait.until(ExpectedConditions.visibilityOfElementLocated(articleNewPriceProductPageLocator)).getCssValue("font-weight");
        checkFontIsBold(priceFontWeightPP);
    }

    // convert font size from string to double
    public Double convertFontSizeToDouble(String fontSize){
        String size = fontSize.replace("px", "");
        double sizeDouble = Double.parseDouble(size);
        return sizeDouble;
    }

    //check if font is bold
    public void checkFontIsBold(String fontWeight) {
        boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;
        if (isBold == true) {
            System.out.println("Font is bold: OK");
        } else {
            System.out.println("Font is not bold: NOK");
        }
    }

    //check if font is strikeout
    public void checkFontIsStrikeout(String fontStyle) {
        boolean isStrikeout = "line-through".equals(fontStyle);
        if (isStrikeout == true) {
            System.out.println("Old price is strikeout: OK");
        } else {
            System.out.println("Old price is strikeout: NOK " + fontStyle);
        }
    }

    // colors converter
    public void defineColor(String color) {

        String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        //System.out.println("--> price color rgba code is:" + color + "; " + "its parsed code is: "+ "r=" + r + "; " + "g=" + g + " ;" + "b=" + b);

        //getting grey
        if (r <= 51 && r >= 0 && b >= 0 && b <= 120) {
            System.out.println("--> price color: GREY");
        }
        //getting red
        else if (b <= 105 && b >= 0 && g >= 0 && g <= 38) {
            System.out.println("--> price color: RED");
        } else {
            System.out.println("--> price color is neither grey nor red");
        }
    }

}