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
public class MortgageCalculatorsPage extends BasePage {

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
	public MortgageCalculatorsPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to click Mortgage Calculators -> Repayments
	 * Calculator
	 * 
	 * @return RepaymentsCalculatorPage
	 */
	public RepaymentsCalculatorPage clickRepaymentsCalculator() {

		repaymentsCalculator.click();

		return new RepaymentsCalculatorPage(m_driver);
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 * 
	 * @return BorrowingCalculatorPage
	 */
	public BorrowingCalculatorPage clickBorrowingCalculator() {

		borrwingCalculator.click();

		return new BorrowingCalculatorPage(m_driver);
	}

}
