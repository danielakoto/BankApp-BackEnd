package bankApp;

public class Checking extends Account {
	//List Properties specific to a Checking account
	private long debitCardNum;
	private int debitCardPin;
	//Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();

	}
	private void setDebitCard() {
		debitCardNum = (long) (Math.random() * Math.pow(10,12)) ;
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}	
	//List methods specific to the checking account 
	public void showInfo() {
		System.out.println("ACCOUNT TYPE:   CHECKING");
		super.showInfo();
		System.out.println(
				"\nYour Savings Account Features" + 
		        "\nDebit Card Number:  " + debitCardNum + 
		        "\nDebit Card Pin:     " + debitCardPin 
				);
	}

}
