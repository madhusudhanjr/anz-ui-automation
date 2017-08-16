package nz.co.anz.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nz.co.anz.utils.CommonHelper;

/**
 * Test class to test RepaymentsCalculator functionalities
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 *
 */
public class RepaymentsCalculatorTests extends BaseTest {

	Logger logger = Logger.getLogger(RepaymentsCalculatorTests.class);

	/**
	 * This Test Method register as a new user to ww.gameduell.com and logs in
	 * with the created user details
	 * 
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 0)
	public void homeLoanRepaymentCalcultorTest(String url) throws Exception {

		logger.info("Enter TestMethod");

		/**
		 * TestData
		 */
		String loanAmount = "10,000";
		String interestRate = "4.99%";
		String loanLength = "25 years";
		String repayFrequency = "Weekly";

		logger.info("Launching URL");
		m_mortgageCalculatorsPage = launchURL(url);

		logger.info("Click RepaymentsCalculator Link");
		m_repaymentsCalculatorPage = m_mortgageCalculatorsPage.clickRepaymentsCalculator();

		logger.info("Verify Reapyments Calcultor Header Text");
		Assert.assertTrue(m_repaymentsCalculatorPage.getHeaderText().contains(CommonHelper.REPAYMENTS_CALUCLATOR),
				"Repayments Calculator Header Text Mismatch!!");

		logger.info("Enter Loan Amount");
		m_repaymentsCalculatorPage.enterLoanAmount(loanAmount);

		logger.info("Select Interest Rate");
		m_repaymentsCalculatorPage.selectInterestRate(interestRate);

		logger.info("Select Loan Length");
		m_repaymentsCalculatorPage.selectLoanLength(loanLength);

		logger.info("Click Calculate Button");
		m_repaymentsCalculatorPage.clickCalculateBtn();

		logger.info("Select Repay Frequency");
		m_repaymentsCalculatorPage.selectRepayFrequency(repayFrequency);

		logger.info("Verify Repay Amount");
		String repayAmt = m_repaymentsCalculatorPage.getRepayAmount();
		Assert.assertTrue((null != repayAmt && !repayAmt.isEmpty()), "Repay Amount NULL / Empty!!");
		logger.info("Repay Amount:: " + repayAmt);

		logger.info("Verify Loan Amount");
		String totalLoanAmt = m_repaymentsCalculatorPage.getTotalLoanAmount();
		Assert.assertTrue((null != totalLoanAmt && !totalLoanAmt.isEmpty()) && totalLoanAmt.contains(loanAmount),
				"Toal Loan Amount NULL / Empty / Mismatch!!");
		logger.info("Total Loan Amount:: " + totalLoanAmt);

		logger.info("Verify Total Interest");
		String totalInterest = m_repaymentsCalculatorPage.getTotalInterest();
		Assert.assertTrue((null != totalInterest && !totalInterest.isEmpty()), "Toal Interest NULL / Empty!!");
		logger.info("Total Interest:: " + totalInterest);

		logger.info("Verify Total Cost");
		String totalCost = m_repaymentsCalculatorPage.getTotalCost();
		Assert.assertTrue((null != totalCost && !totalCost.isEmpty()), "Total Cost NULL / Empty!!");
		logger.info("Total Cost:: " + totalCost);

		logger.info("Exit TestMethod");

	}

	/**
	 * This Test Method register as a new user to ww.gameduell.com and logs in
	 * with the created user details
	 * 
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 0)
	public void verifyLoanAmount(String url) throws Exception {

		logger.info("Enter TestMethod");

		/**
		 * TestData
		 */
		String loanAmount = "1,000";

		logger.info("Launching URL");
		m_mortgageCalculatorsPage = launchURL(url);

		logger.info("Click RepaymentsCalculator Link");
		m_repaymentsCalculatorPage = m_mortgageCalculatorsPage.clickRepaymentsCalculator();

		logger.info("Verify Reapyments Calcultor Header Text");
		Assert.assertTrue(m_repaymentsCalculatorPage.getHeaderText().contains(CommonHelper.REPAYMENTS_CALUCLATOR),
				"Repayments Calculator Header Text Mismatch!!");

		logger.info("Reset Loan Form");
		m_repaymentsCalculatorPage.resetLoanForm();
		
		logger.info("Verify Loan Amount Reset");
		String loanAmt = m_repaymentsCalculatorPage.getLoanAmount();
		Assert.assertTrue(loanAmt.isEmpty(), "Loan Amount is not reset!!");
		
		logger.info("Enter Loan Amount");
		m_repaymentsCalculatorPage.enterLoanAmount(loanAmount);

		logger.info("Click Calculate Button");
		m_repaymentsCalculatorPage.clickCalculateBtn();
		
		logger.info("Verify Loan Amount Error");
		String loanAmtError = m_repaymentsCalculatorPage.getTotalLoanAmountError();
		Assert.assertTrue((null != loanAmtError && !loanAmtError.isEmpty()
				&& loanAmtError.equalsIgnoreCase(CommonHelper.LOAN_AMOUNT_ERROR)), "Loam Amount Error Message NULL / Empty / Mismatch!!");
		logger.info("Loan Amount Error:: " + loanAmtError);

		logger.info("Exit TestMethod");

	}

}