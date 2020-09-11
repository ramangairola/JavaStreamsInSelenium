package com.streams.Pages;

import com.streams.Base.BaseClass;
import com.streams.Utils.Utilts;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class OfferPage extends BaseClass {

    Utilts utilts;

    @FindBy(css = "tr th:nth-child(1)")
    private WebElement column;

    @FindBy(css = "tr td:nth-child(1)")
    private List<WebElement> veggieList;

    @FindBy(css = "[aria-label='Next']")
    private WebElement nextButton;

    @FindBy(css = "[id='search-field']")
    private WebElement searchField;

    public OfferPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * Click on column to sort
     * @name clickOnSortColumn
     * @return void
     */
    public void clickOnSortColumn(){
        try {
            column.click();
        }catch (NoSuchElementException e){
            Assert.fail("Unable to click on sort column");
        }
    }

    /**
     * Return the list of veggies Names
     * @name returnOriginalVeggieNameListOfVeggieNames
     * @return List<String>
     */
    public List<String> returnOriginalVeggieNameListOfVeggieNames(){
        List<String> originalVeggieNameList = null;
//      Capture test of all web elements into new(original) list
        try {
            originalVeggieNameList = veggieList.stream().map(s -> s.getText()).collect(Collectors.toList());

        }catch (NullPointerException npe){
            Assert.fail("Null Veggie Name list is returning");
        }
        return originalVeggieNameList;
    }

    /**
     * Return the sort list of veggies names
     * @name returnSortListOfVeggieNames
     * @param originalVeggieNameList
     * @return List<String>
     */
    public List<String> returnSortListOfVeggieNames(List<String> originalVeggieNameList){
        List<String> sortedVeggieListName=null;
//      Sort on the original list of veggies
        try{
            sortedVeggieListName = originalVeggieNameList.stream().sorted().collect(Collectors.toList());
        }catch (NullPointerException npe){
            Assert.fail("Null sorted veggie name list is returning");
        }
        return sortedVeggieListName;
    }

    /**
     * Return the price of veggie given in arguments
     * @name returnPrice
     * param String
     * @return int
     */
    public int returnPrice(String veggie){
        List<String> priceList = null;
        do {
//          scan the name column with get text -> Beans -> print the price
            try{
                utilts = new Utilts();
                priceList = veggieList.stream().filter(s -> s.getText().contains(veggie)).
                        map(s -> utilts.returnPrice(s)).collect(Collectors.toList());
            }catch (NullPointerException npe){
                Assert.fail("Null price list is returning");
            }

            if (priceList.size() < 1) {
                nextButton.click();
            }

        }while (priceList.size()<1);

        return Integer.parseInt(priceList.get(0));

    }

    /**
     * Search for veggie
     * @name searchForVeggie
     * @param veggieToSearch
     * @return void
     */
    public void searchForVeggie(String veggieToSearch){
        try {
            searchField.sendKeys(veggieToSearch);
        }catch (NoSuchElementException e){
            Assert.fail("Unable to click on sort column");
        }
    }

    /**
     * return for veggie List
     * @name returnVeggieList
     * @return list
     */
    public List<WebElement> returnVeggieList(){
        List<WebElement> veggielist = null;
        try {
            veggielist = veggieList;
        }catch (NoSuchElementException e){
            Assert.fail("Unable to click on sort column");
        }
        return veggielist;
    }

    /**
     * return for filter veggie List
     * @name returnFilteredVeggieList
     * @param veglist
     * @return List<WebElement>
     */
    public List<WebElement> returnFilteredVeggieList(List<WebElement> veglist, String veggieToFilter){
        List<WebElement> filterList = veglist.stream().filter(veggie->veggie.getText().contains(veggieToFilter)).collect(Collectors.toList());
        return filterList;
    }

}
