package com.automation.actions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableActions {

    private WebDriver driver;
    private FindElementActions findElementActions;

    public TableActions(WebDriver driver) {
        this.driver = driver;
        this.findElementActions = new FindElementActions(driver);  // Initialize the FindElementActions class
    }

    // Get the number of rows in the table using a By locator
    public int getRowCount(By tableLocator) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    // Get the number of columns in the table using a By locator
    public int getColumnCount(By tableLocator) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        if (rows.size() > 0) {
        	WebElement header =table.findElement(By.tagName("thead"));
            return header.findElements(By.tagName("th")).size();
        }
        return 0;
    }

    // Get the data of a cell at a specific row and column index using a By locator
    public String getCellData(By tableLocator, int rowIndex, int columnIndex) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        try {
            WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
            WebElement cell = row.findElements(By.tagName("td")).get(columnIndex);
            return cell.getText();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // Click on a cell in the table at the specified row and column index using a By locator
    public void clickCell(By tableLocator, int rowIndex, int columnIndex) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        try {
            WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
            WebElement cell = row.findElements(By.tagName("td")).get(columnIndex);
            cell.click();
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(
                    "No such cell at row index " + rowIndex + " and column index " + columnIndex);
        }
    }

    // Get a cell element by its text using a By locator
    public WebElement getCellByText(By tableLocator, String cellText) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(cellText)) {
                    return cell;
                }
            }
        }
        return null;
    }

    // Click on a row containing specific text using a By locator
    public void clickRowByText(By tableLocator, String rowText) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(rowText)) {
                row.click();
                return;
            }
        }
        throw new NoSuchElementException("No row found with the text: " + rowText);
    }

    // Verify if a row contains specific text using a By locator
    public boolean verifyRowContainsText(By tableLocator, String rowText) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(rowText)) {
                return true;
            }
        }
        return false;
    }

    // Verify if a cell contains specific text using a By locator
    public boolean verifyCellContainsText(By tableLocator, int rowIndex, int columnIndex, String expectedText) {
        String cellText = getCellData(tableLocator, rowIndex, columnIndex);
        return cellText != null && cellText.contains(expectedText);
    }

    // Get the headers of the table using a By locator
    public List<String> getTableHeaders(By tableLocator) {
        WebElement table = findElementActions.findElement(tableLocator);  // Find the table by locator
        List<WebElement> headerCells = table.findElements(By.tagName("th"));
        return headerCells.stream().map(WebElement::getText).toList();
    }
}
