package nz.co.anz.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import nz.co.anz.utils.CommonHelper;

/**
 * BorrowingCalculator Page Object class contains the WebElements which are
 * required to test Borrowing Calculator functionality
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class BorrowingCalculatorPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(id = "simpleIndividualType")
	WebElement individual;

	@FindBy(id = "simpleJointType")
	WebElement joint;

	@FindBy(id = "Income_AnnualHousehold")
	WebElement annualHouseholdIncome;

	@FindBy(css = ".minus [data-btnplusminfor='LoanDetails_Dependants']")
	WebElement minusDependents;

	@FindBy(css = ".plus [data-btnplusminfor='LoanDetails_Dependants']")
	WebElement plusDependents;

	@FindBy(css = ".minus [data-btnplusminfor='LoanDetails_Vehicles']")
	WebElement minusVehicles;

	@FindBy(css = ".plus [data-btnplusminfor='LoanDetails_Vehicles']")
	WebElement plusVehicles;

	@FindBy(id = "amountAbleToBorrow")
	WebElement borrowAmount;

	@FindBy(id = "js-affordabilityRefineResults")
	WebElement revisedEstimateBtn;

	@FindBy(id = "PurposeBuilding")
	WebElement buildingPurpose;

	@FindBy(css = "#js-hasRealEstateFalse")
	WebElement hasRealEstateFalse;

	@FindBy(id = "LoanDetails_OtherDeposit")
	WebElement depositAmount;

	@FindBy(id = "Income_Applicant1")
	WebElement firstApplicantSalary;

	@FindBy(id = "Income_Applicant2")
	WebElement secondAplicantSalary;

	@FindBy(id = "hasDepositFalse")
	WebElement hasDepositFalse;

	@FindBy(id = "LoanDetails_ExistingPropertyValue")
	WebElement totalValueOfExistingProperty;

	@FindBy(id = "LoanDetails_ExistingHomeLoanBalance")
	WebElement existingHomeLoanBalance;

	@FindBy(css = "[for='SharesBonds']")
	WebElement shareBonds;

	@FindBy(id = "Income_SharesValue")
	WebElement shareIncome;

	@FindBy(css = "[for='AdditionalSavingsAccounts']")
	WebElement additionalSavingAcc;

	@FindBy(id = "SavingsAndAssets_AdditionalSavingsBalance")
	WebElement additionalSavingBalance;

	@FindBy(css = "[for='Rent']")
	WebElement rent;

	@FindBy(id = "OtherExpenses_RentAmount")
	WebElement otherExpenses;

	@FindBy(css = "[for='hasKiwisaverTrue'] span")
	WebElement kiwisaverTrue;

	@FindBy(css = "[for='hasOtherSuperTrue'] span")
	WebElement superannuationTrue;

	/**
	 * Constructor for BorrowingCalculatorPage
	 * 
	 * @param driver
	 */
	public BorrowingCalculatorPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to click on Individual Application Radio Button
	 */
	public void clickIndividualApplication() {

		individual.click();
	}

	/**
	 * This method is used to click on Joint Application Radio Button
	 */
	public void clickJointApplication() {

		joint.click();
	}

	/**
	 * This method is used to enter Annual Household Income
	 * 
	 * @param income
	 */
	public void enterAnnualHouseholdIncome(String income) {

		annualHouseholdIncome.sendKeys(income);
	}

	/**
	 * This method is used to add dependent children
	 * 
	 * @param dependents
	 */
	public void addDependentChildren(int dependents) {

		if (dependents > 0)
			for (int i = 1; i <= dependents; i++) {
				plusDependents.click();
			}
	}

	/**
	 * This method is used to add vehicles
	 * 
	 * @param vehicles
	 */
	public void addVehicles(int vehicles) {

		if (vehicles > 0)
			for (int i = 1; i <= vehicles; i++) {
				plusVehicles.click();
			}
	}

	/**
	 * This method is used to get the amount able to borrow
	 */
	public String getBorrowAmount() {

		CommonHelper.explicitWaitTillVisible(m_driver, 10, borrowAmount);
		return borrowAmount.getText();
	}

	/**
	 * This method is used to select the application type based on the parameter
	 * type
	 * 
	 * @param type
	 */
	public void selectApplicationType(String type) {

		if (type.equalsIgnoreCase(CommonHelper.INDIVIDUAL)) {

			clickIndividualApplication();
		} else if (type.equalsIgnoreCase(CommonHelper.JOINT)) {

			clickJointApplication();
		}
	}

	/**
	 * This method is used to get default Annual household Income
	 */
	public String getAnnualHouseholdIncome() {

		return annualHouseholdIncome.getText();
	}

	/**
	 * This method is used to click Revise Estimate Button
	 */
	public void clickReviseEstimateBtn() {

		revisedEstimateBtn.click();
	}

	/**
	 * This method is used to select the property owned
	 * 
	 * @param option
	 */
	public void selectOwnAnyProperty(String option) {

		if (option.equalsIgnoreCase(CommonHelper.NO))
			hasRealEstateFalse.click();
	}

	/**
	 * This method is used to enter deposit amount
	 * 
	 * @param amount
	 */
	public void enterDepositAmount(String amount) {

		depositAmount.sendKeys(amount);
	}

	/**
	 * This method is used to enter First Applicant Salary
	 * 
	 * @param salary
	 */
	public void enterFirstApplicantSalary(String salary) {

		firstApplicantSalary.sendKeys(salary);
	}

	/**
	 * This method is used to enter Second Applicant Salary
	 * 
	 * @param salary
	 */
	public void enterSecondApplicantSalary(String salary) {

		secondAplicantSalary.sendKeys(salary);
	}

	/**
	 * This method is used to select the Shares / Bonds
	 * 
	 * @param income
	 */
	public void selectShareBonds(String income) {

		shareBonds.click();
		shareIncome.sendKeys(income);
	}

	/**
	 * This method is used to select the Additional Savings Account
	 * 
	 * @param balance
	 */
	public void selectAdditionalSavingsAcc(String balance) {

		additionalSavingAcc.click();
		additionalSavingBalance.sendKeys(balance);
	}

	/**
	 * This method is used to select the Rent
	 * 
	 * @param expense
	 */
	public void selectRent(String expense) {

		rent.click();
		otherExpenses.sendKeys(expense);
	}

	/**
	 * This method is used to select the Kiwisaver option
	 * 
	 * @param option
	 */
	public void selectKiwiSaver(String option) {

		if (option.equalsIgnoreCase(CommonHelper.YES))
			kiwisaverTrue.click();
	}

	/**
	 * This method is used to select the superannuation option
	 * 
	 * @param option
	 */
	public void selectSuperannuation(String option) {

		if (option.equalsIgnoreCase(CommonHelper.YES))
			superannuationTrue.click();
	}

}
