package bankApp;

import java.util.LinkedList;
import java.util.List;

public class BankApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		
		//Read a CSV File then create new accounts based on that
		String file = "C:\\Users\\sulce\\Downloads\\NewBankAccounts.csv";
		List<String[]> newCustomers = utilities.CSV.read(file);
		for (String[] accountHolder : newCustomers ) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + " " + accountType + " " + " $ " + initDeposit);
			if(accountType.equals("Savings")) {
			    accounts.add(new Savings(name, sSN, initDeposit));
			    
			} 
			else if(accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else 
			    System.out.println("ERROR READING ACCOUNT");
		}
		
		accounts.get(5).showInfo();
		
		for(Account acc : accounts) {
			System.out.println("***********************************");
			acc.showInfo();
		}
	}
}
