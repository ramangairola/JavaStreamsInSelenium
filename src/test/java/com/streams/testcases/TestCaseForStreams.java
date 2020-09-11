package com.streams.testcases;

import com.aventstack.extentreports.Status;
import com.streams.Base.BaseClass;
import com.streams.Pages.OfferPage;
import com.streams.reports.ExtentListeners;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseForStreams extends BaseClass {

    OfferPage offerPage;
    ExtentListeners eventListener;

    public TestCaseForStreams(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        offerPage = new OfferPage();
        eventListener = new ExtentListeners();
    }

    @Test(priority = 0, enabled = true)
    public void compareList() {

//      click on sort column
        offerPage.clickOnSortColumn();
        test.log(Status.INFO, "Click on sort Column");

//      Capture all web elements into list
//      Capture test of all web elements into new(original) list
        List<String> originalVeggieNameList = offerPage.returnOriginalVeggieNameListOfVeggieNames();
        test.log(Status.INFO, "Capture all veggies name in a list");

//      Sort on the original list of step 3 -> sorted list
        List<String> sortedVeggieListName = offerPage.returnSortListOfVeggieNames(originalVeggieNameList);
        test.log(Status.INFO, "Sort the original veggies name list into a new list");

//      compare original list vs sorted list
        Assert.assertTrue(originalVeggieNameList.equals(sortedVeggieListName), "List not sorted");
        test.log(Status.PASS, "Column is sorted");
    }

    @Test(priority = 1, enabled = true)
    public void selectPrice(){
        int veggiePrice = offerPage.returnPrice(properties.getProperty("veggie"));
        test.log(Status.INFO, "Retrieve the veggie price");
        Assert.assertEquals(veggiePrice,Integer.parseInt(properties.getProperty("expectedPrice")), "Wrong Price value returned");
        test.log(Status.PASS, "Correct Veggie Price displayed");
    }

    @Test(priority = 2, enabled = true)
    public void filterTest(){
        offerPage.searchForVeggie(properties.getProperty("searchVeggie"));
        test.log(Status.INFO, "Veggie searched");
        List<WebElement> veggieslist = offerPage.returnVeggieList();
        test.log(Status.INFO, "Veggie list returned");
        List<WebElement> filterVeggieList = offerPage.returnFilteredVeggieList(veggieslist, properties.getProperty("searchVeggie"));
        test.log(Status.INFO, "Filtered veggie list returned");
        Assert.assertEquals(veggieslist.size(),filterVeggieList.size(), "Filter not working");
        test.log(Status.PASS, "Filter functionality working");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
