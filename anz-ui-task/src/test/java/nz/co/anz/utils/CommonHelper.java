package nz.co.anz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

	public static final String REPAYMENTS_CALUCLATOR = "Repayments calculator";
	public static final String LOAN_AMOUNT_ERROR = "Loan amount must be between $5,000 and $5,000,000";
	
	public static void selectOption(WebElement selectElement, String option) {
		
		Select select = new Select(selectElement);
		select.selectByVisibleText(option);
	}
	
	
	public static void waitTillVisible(WebDriver driver, int sec, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
