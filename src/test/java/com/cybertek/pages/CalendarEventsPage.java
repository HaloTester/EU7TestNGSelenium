package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.*;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//div[@data-toggle='dropdown'])[2]")
    public WebElement pageSubTitle;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//*[@class='btn-group']/button")
    public WebElement viewPerPageNumber;

    @FindBy(xpath = "(//div[@class='pagination pagination-centered']/label)[3]")
    public WebElement numberOfCalendarEvents;

    @FindBy(xpath = "(//th/div/button/input)[1]")
    public WebElement selectAllCalendarEventsBtn;


    public void changeViewPerPageNumber(int number){
        Select select = new Select(viewPerPageNumber);
        select.selectByVisibleText(String.valueOf(number));
    }

    public int checkSelectedCalendarEvents(){
        String xpath = "//table/tbody/tr/td/input";
        List<WebElement> selectedCalendarEvents = Driver.get().findElements(By.xpath(xpath));
        for (WebElement selectedCalendarEvent : selectedCalendarEvents) {
            Assert.assertTrue(selectedCalendarEvent.isSelected());
        }
        return selectedCalendarEvents.size();
    }

    public String numberOfCalendarEventsRecord(){
        List<String> list = Arrays.asList(numberOfCalendarEvents.getText().split(" "));
        return list.get(2);
    }

    public WebElement selectTitle(String title){
        String xpathTitle = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title']";
        //String xpathStart = "//td[@class='datetime-cell grid-cell grid-body-cell grid-body-cell-start']";
        List<WebElement> listOfTitle = Driver.get().findElements(By.xpath(xpathTitle));
        //List<WebElement> listOfDate = Driver.get().findElements(By.xpath(xpathStart));
        for (int i = 0; i<listOfTitle.size(); i++) {
            if (listOfTitle.get(i).getText().equals(title)) {
                /*if(listOfDate.get(i).getText().equals(date)){
                    return listOfTitle.get(i);
                }*/
            }
            return listOfTitle.get(i);
        }
        return null;
    }

    public List<String> eventInfoPage(){
        String rowNumber = "//div[@class='responsive-block']/div";
        List<WebElement> rowNumberList = Driver.get().findElements(By.xpath(rowNumber));
        List<String> actualEventInfo = new ArrayList<>();

        for (int i = 1; i <= rowNumberList.size(); i++) {

            for (int j = 1; j <= 2; j++) {
                String xpathOfEachRow = "((//div[@class='responsive-block']/div)[" + i
                        + "]//*[starts-with(@class,'control-label')])[" + j + "]";

                String eventValue = Driver.get().findElement(By.xpath(xpathOfEachRow)).getText();
                actualEventInfo.add(eventValue);

            }
        }
        return actualEventInfo;
    }
}
