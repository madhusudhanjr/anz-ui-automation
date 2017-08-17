package nz.co.anz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

	/**
	 * String Constants
	 */
	public static final String REPAYMENTS_CALUCLATOR = "Repayments calculator";
	public static final String BORROWING_CALCULATOR = "Borrowing calculator";
	public static final String LOAN_AMOUNT_ERROR = "Loan amount must be between $5,000 and $5,000,000";
	public static final String INDIVIDUAL = "Individual";
	public static final String JOINT = "Joint";
	public static final String NO = "No";
	public static final String YES = "Yes";

	/**
	 * This method is used to select the option from the Combo
	 * 
	 * @param selectElement
	 * @param option
	 */
	public static void selectOption(WebElement selectElement, String option) {

		Select select = new Select(selectElement);
		select.selectByVisibleText(option);
	}

	/**
	 * This method is used to wait till the visible of the Element
	 * 
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public static void explicitWaitTillVisible(WebDriver driver, int sec, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
