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
/**
 * @author jmadh
 *
 */
/**
 * @author jmadh
 *
 */

/**
 * @author jmadh
 *
 */
/**
 * @author jmadh
 *
 */
public class RepaymentsCalculatorPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(id = "LoanAmount")
	WebElement loanAmount;

	@FindBy(css = ".selector.rates")
	WebElement selectRates;

	@FindBy(css = ".dropdownvalues li")
	List<WebElement> rateValues;

	@FindBy(id = "LoanLength")
	WebElement loanLength;

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

	/**
	 * Constructor for RepaymentsCalculatorPage
	 * 
	 * @param driver
	 */
	public RepaymentsCalculatorPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to enter Loan Amount
	 * 
	 * @param loanAmt
	 */
	public void enterLoanAmount(String loanAmt) {

		loanAmount.sendKeys(loanAmt);
	}

	/**
	 * This method is used to select the Interest Rate fromn the drop down
	 * 
	 * @param rate
	 */
	public void selectInterestRate(String rate) {

		selectRates.click();

		for (WebElement el : rateValues) {

			if (el.getText().contains(rate)) {
				el.click();
				break;
			}

		}

	}

	/**
	 * This method is used to select the Loan Length by selecting from the Combo
	 * Box
	 * 
	 * @param option
	 */
	public void selectLoanLength(String option) {

		CommonHelper.selectOption(loanLength, option);
	}

	/**
	 * This method is used to select the Repay Frequency
	 * 
	 * @param option
	 */
	public void selectRepayFrequency(String option) {

		CommonHelper.selectOption(repayFrequency, option);
	}

	/**
	 * This method is used to get the Repay Amount
	 * 
	 * @return RepayAmount
	 */
	public String getRepayAmount() {

		CommonHelper.explicitWaitTillVisible(m_driver, 10, weeklyRepayAmt);

		return weeklyRepayAmt.getText();
	}

	/**
	 * This method is used to get the Total Interest
	 * 
	 * @return Total Interest
	 */
	public String getTotalInterest() {

		for (WebElement el : totalInterest) {

			if (el.isDisplayed() && !el.getText().isEmpty()) {

				return el.getText();
			}
		}

		return null;
	}

	/**
	 * This method is used to get the TotalCost
	 * 
	 * @return TotalCost
	 */
	public String getTotalCost() {

		for (WebElement el : totalCost) {

			if (el.isDisplayed() && !el.getText().isEmpty()) {

				return el.getText();
			}
		}

		return null;
	}

	/**
	 * This method is used to get the Total Loan Amount
	 * 
	 * @return Total Loan Amount
	 */
	public String getTotalLoanAmount() {

		return totalLoan.getText();
	}

	/**
	 * This method is used to get the Loan filed error message
	 * 
	 * @return error message
	 */
	public String getTotalLoanAmountError() {

		return loanAmountError.getText();
	}

	/**
	 * This method is used to get the Loan Amount
	 * 
	 * @return
	 */
	public String getLoanAmount() {

		return loanAmount.getText();
	}

}
