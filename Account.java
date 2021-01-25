package bankApp;

public abstract class Account implements IBaseRate {
	//List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	
	protected double rate;
	protected String accountNumber;
	static int index = 10000;
	
	//Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		
		//Account Number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoSSN = sSN.substring(sSN.length()-2, sSN.length());
		int randomNum = (int) (Math.random() * Math.pow(10, 3));
		int uniqueID = index;
		return lastTwoSSN + uniqueID + randomNum;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	//List common methods
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Deposit $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount ) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
    public void showInfo() {
		System.out.println( 
				"NAME:           " + name +
				"\nACCOUNT NUMBER: " + accountNumber + 
				"\nBALANCE:        " + balance + 
				"\nRATE:           " + rate + "%");
	}
}
