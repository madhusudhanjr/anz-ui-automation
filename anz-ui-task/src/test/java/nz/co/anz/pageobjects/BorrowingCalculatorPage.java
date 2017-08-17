package nz.co.anz.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * MortgageCalculators Page Object class contains the WebElements which are
 * required to click Repayments Calculator and Borrowing Calculator
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class BorrowingCalculatorPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(linkText = "Repayments calculator")
	WebElement repaymentsCalculator;

	@FindBy(linkText = "Borrowing calculator")
	WebElement borrwingCalculator;

	/**
	 * Constructor for HomePage
	 * 
	 * @param driver
	 */
	public BorrowingCalculatorPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to click Mortgage Calculators -> Repayments
	 * Calculator
	 */
	public void clickRepaymentsCalculator() {

		repaymentsCalculator.click();
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void clickBorrowingCalculator() {

		borrwingCalculator.click();
	}

}
