package nz.co.anz.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(id = "IndividualApplication")
	WebElement individual;

	@FindBy(id = "JointApplication")
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

	@FindBy(css = "#js-hasRealEstateTrue")
	WebElement hasRealEstateTrue;

	@FindBy(id = "hasDepositFalse")
	WebElement hasDepositFalse;

	@FindBy(id = "LoanDetails_ExistingPropertyValue")
	WebElement totalValueOfExistingProperty;

	@FindBy(id = "LoanDetails_ExistingHomeLoanBalance")
	WebElement existingHomeLoanBalance;

	@FindBy(id = "SharesBonds")
	WebElement shareBonds;

	@FindBy(id = "Income_SharesValue")
	WebElement shareIncome;

	@FindBy(id = "AdditionalSavingsAccounts")
	WebElement additionalSavingAcc;
	
	@FindBy(id = "SavingsAndAssets_AdditionalSavingsBalance")
	WebElement additionalSavingBalance;
	
	@FindBy(id = "Rent")
	WebElement rent;
	
	@FindBy(id = "OtherExpenses_RentAmount")
	WebElement otherExpenses;
	
	@FindBy(css = "[for='hasKiwisaverTrue'] span")
	WebElement kiwisaverFalse;
	
	@FindBy(css = "[for='hasOtherSuperTrue'] span")
	WebElement superannuationTrue;

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
	public void clickIndividualApplication() {

		individual.click();
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void clickJointApplication() {

		joint.click();
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void enterAnnualHouseholdIncome(String income) {

		annualHouseholdIncome.sendKeys(income);
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void addDependentChildren(int dependents) {

		for (int i = 1; i <= dependents; i++) {
			plusDependents.click();
		}
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public void addVehicles(int vehicles) {

		for (int i = 1; i <= vehicles; i++) {
			plusVehicles.click();
		}
	}

	/**
	 * This method is used to click Mortgage Calculators -> Borrowing Calculator
	 */
	public String getBorrowAmount() {

		return borrowAmount.getText();
	}
}
