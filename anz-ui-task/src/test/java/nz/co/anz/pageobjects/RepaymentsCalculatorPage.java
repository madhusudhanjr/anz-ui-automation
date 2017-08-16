package nz.co.anz.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import nz.co.anz.utils.CommonHelper;

/**
 * RepaymentsCalculator Page Object class contains the WebElements which are
 * required to test Repayments Calculator functionality
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class RepaymentsCalculatorPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(css = ".masthead h1")
	WebElement heading;

	@FindBy(id = "LoanAmount")
	WebElement loanAmount;

	@FindBy(css = ".selector.rates")
	WebElement selectRates;

	@FindBy(css = ".dropdownvalues li")
	List<WebElement> rateValues;

	@FindBy(id = "LoanLength")
	WebElement loanLength;

	@FindBy(css = "input[value='Calculate']")
	WebElement calculateBtn;

	@FindBy(id = "RepaymentFrequency")
	WebElement repayFrequency;

	@FindBy(css = ".js-totalLoanCalc")
	WebElement totalLoan;

	@FindBy(css = ".js-repaymentCalcResult.js-weekly")
	WebElement weeklyRepayAmt;

	@FindBy(css = ".js-totalInterestCalc")
	List<WebElement> totalInterest;

	@FindBy(css = ".js-totalCostCalc")
	List<WebElement> totalCost;

	@FindBy(css = ".field-validation-error")
	WebElement loanAmountError;

	@FindBy(css = ".reset")
	WebElement resetBtn;

	@FindBy(css = ".ui-button-text")
	WebElement resetFormBtn;

	/**
	 * Constructor for HomePage
	 * 
	 * @param driver
	 */
	public RepaymentsCalculatorPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to click Mortgage Calculators -> Repayments
	 * Calculator
	 */
	public String getHeaderText() {

		return heading.getText();
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void enterLoanAmount(String loanAmt) {

		loanAmount.sendKeys(loanAmt);
	}

	public void selectInterestRate(String rate) {

		selectRates.click();

		for (WebElement el : rateValues) {

			if (el.getText().contains(rate)) {
				el.click();
				break;
			}

		}

	}

	public void selectLoanLength(String option) {

		CommonHelper.selectOption(loanLength, option);
	}

	public void clickCalculateBtn() {

		calculateBtn.click();
	}

	public void selectRepayFrequency(String option) {

		CommonHelper.selectOption(repayFrequency, option);
	}

	public String getRepayAmount() {

		CommonHelper.waitTillVisible(m_driver, 10, weeklyRepayAmt);

		return weeklyRepayAmt.getText();
	}

	public String getTotalInterest() {

		for (WebElement el : totalInterest) {

			if (el.isDisplayed() && !el.getText().isEmpty()) {

				return el.getText();
			}
		}

		return null;
	}

	public String getTotalCost() {

		for (WebElement el : totalCost) {

			if (el.isDisplayed() && !el.getText().isEmpty()) {

				return el.getText();
			}
		}

		return null;
	}

	public String getTotalLoanAmount() {

		return totalLoan.getText();
	}

	public String getTotalLoanAmountError() {

		return loanAmountError.getText();
	}

	public void resetLoanForm() {

		resetBtn.click();
		resetFormBtn.click();
	}

	public String getLoanAmount() {

		return loanAmount.getText();
	}

}
