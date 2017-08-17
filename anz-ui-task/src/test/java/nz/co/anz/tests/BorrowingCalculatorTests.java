package nz.co.anz.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nz.co.anz.utils.CommonHelper;

/**
 * Test class to test BorrowingCalculator functionalities
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 *
 */
public class BorrowingCalculatorTests extends BaseTest {

	Logger logger = Logger.getLogger(BorrowingCalculatorTests.class);

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 0)
	public void verifyBorrwLoanAmount(String url) throws Exception {

		logger.info("Enter TestMethod");

		/**
		 * TestData
		 */
		String applicationType = CommonHelper.JOINT;
		String annualHouseholdIncome = "150,000";
		int dependentChild = 1;
		int vehicles = 1;

		logger.info("Launching URL");
		m_mortgageCalculatorsPage = launchURL(url);

		logger.info("Click BorrowingCalculator Link");
		m_borrowingCalculatorPage = m_mortgageCalculatorsPage.clickBorrowingCalculator();

		logger.info("Verify Borrowing Calcultor Header Text");
		Assert.assertTrue(m_borrowingCalculatorPage.getHeaderText().contains(CommonHelper.BORROWING_CALCULATOR),
				"Borrowing Calculator Header Text Mismatch!!");

		logger.info("Select Application Type");
		m_borrowingCalculatorPage.selectApplicationType(applicationType);

		logger.info("Enter Annual household Income");
		m_borrowingCalculatorPage.enterAnnualHouseholdIncome(annualHouseholdIncome);

		logger.info("Add dependent children");
		m_borrowingCalculatorPage.addDependentChildren(dependentChild);

		logger.info("Add vehicles");
		m_borrowingCalculatorPage.addVehicles(vehicles);

		logger.info("Click calculate button");
		m_borrowingCalculatorPage.clickCalculateBtn();

		logger.info("Verify Amount to Borrow");
		String borrowAmount = m_borrowingCalculatorPage.getBorrowAmount();
		Assert.assertTrue((null != borrowAmount && !borrowAmount.isEmpty()), "Borrow Amount NULL / Empty!!");
		logger.info("Borrow Amount:: " + borrowAmount);

		logger.info("Exit TestMethod");

	}

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents and to revising the Estimate
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 1)
	public void verifyRevisedEstimate(String url) throws Exception {

		logger.info("Enter TestMethod");

		/**
		 * TestData
		 */
		String applicationType = CommonHelper.JOINT;
		String annualHouseholdIncome = "250,000";
		int dependentChild = 2;
		int vehicles = 1;
		String ownProperty = CommonHelper.NO;
		String depsoitAmount = "10,000";
		String firstAppSalary = "100,000";
		String secondAppSalary = "100,000";
		String valueOfSahre = "10,000";
		String totalSavingsBalance = "15,000";
		String kiwiSaver = CommonHelper.YES;
		String superannuation = CommonHelper.YES;
		String otherExpense = "500";

		logger.info("Launching URL");
		m_mortgageCalculatorsPage = launchURL(url);

		logger.info("Click BorrowingCalculator Link");
		m_borrowingCalculatorPage = m_mortgageCalculatorsPage.clickBorrowingCalculator();

		logger.info("Verify Borrowing Calcultor Header Text");
		Assert.assertTrue(m_borrowingCalculatorPage.getHeaderText().contains(CommonHelper.BORROWING_CALCULATOR),
				"Borrowing Calculator Header Text Mismatch!!");

		logger.info("Reset Loan Form");
		m_borrowingCalculatorPage.resetLoanForm();

		logger.info("Verify Loan Amount Reset");
		String loanAmt = m_borrowingCalculatorPage.getAnnualHouseholdIncome();
		Assert.assertTrue(loanAmt.isEmpty(), "Loan Amount is not reset!!");

		logger.info("Select Application Type");
		m_borrowingCalculatorPage.selectApplicationType(applicationType);

		logger.info("Enter Annual household Income");
		m_borrowingCalculatorPage.enterAnnualHouseholdIncome(annualHouseholdIncome);

		logger.info("Add dependent children");
		m_borrowingCalculatorPage.addDependentChildren(dependentChild);

		logger.info("Add vehicles");
		m_borrowingCalculatorPage.addVehicles(vehicles);

		logger.info("Click calculate button");
		m_borrowingCalculatorPage.clickCalculateBtn();

		logger.info("Verify Amount able to Borrow");
		String borrowAmount = m_borrowingCalculatorPage.getBorrowAmount();
		Assert.assertTrue((null != borrowAmount && !borrowAmount.isEmpty()), "Borrow Amount NULL / Empty!!");
		logger.info("Borrow Amount:: " + borrowAmount);

		logger.info("Click Revise Estimate Button");
		m_borrowingCalculatorPage.clickReviseEstimateBtn();

		logger.info("Select do you own property option");
		m_borrowingCalculatorPage.selectOwnAnyProperty(ownProperty);

		logger.info("Enter deposit amount");
		m_borrowingCalculatorPage.enterDepositAmount(depsoitAmount);

		logger.info("Enter first applicant salary");
		m_borrowingCalculatorPage.enterFirstApplicantSalary(firstAppSalary);

		logger.info("Enter second applicant salary");
		m_borrowingCalculatorPage.enterSecondApplicantSalary(secondAppSalary);

		logger.info("Select share / bonds option");
		m_borrowingCalculatorPage.selectShareBonds(valueOfSahre);

		logger.info("Select additional savings account option");
		m_borrowingCalculatorPage.selectAdditionalSavingsAcc(totalSavingsBalance);

		logger.info("Select Kiwisaver option");
		m_borrowingCalculatorPage.selectKiwiSaver(kiwiSaver);

		logger.info("Select Superannuation option");
		m_borrowingCalculatorPage.selectSuperannuation(superannuation);

		logger.info("Enter Rent / Board expense");
		m_borrowingCalculatorPage.selectRent(otherExpense);

		logger.info("Click Calculate Button");
		m_borrowingCalculatorPage.clickCalculateBtn();

		logger.info("Verify Amount to Borrow");
		borrowAmount = m_borrowingCalculatorPage.getBorrowAmount();
		Assert.assertTrue((null != borrowAmount && !borrowAmount.isEmpty()), "Borrow Amount NULL / Empty!!");
		logger.info("Borrow Amount:: " + borrowAmount);

		logger.info("Exit TestMethod");

	}

}