package bankApp;

public class Savings extends Account {
	//List Properties specific to a Savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
    //Constructor to initialize Savings account properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}	
	
	//List methods specific to the Savings account 
	public void showInfo() {
		System.out.println("ACCOUNT TYPE:   SAVINGS");
		super.showInfo();
		System.out.println(
				"\nYour Savings Account Features" + 
		        "\nSafety Deposit Box ID:  " + safetyDepositBoxID + 
		        "\nSafety Deposit Box Key: " + safetyDepositBoxKey 
				);
		
		
	}
	
	
}
