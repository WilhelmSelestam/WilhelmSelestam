package lab3;

import java.util.ArrayList;

public class Bank {

	public final String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();

	public Bank(String arg) {
		NAME = arg;
		Account.theBank = this;
	}

	public CurrentAccount searchAccount(String arg) {
		
		for (Account a : theAccounts) {
			if (a.getCustomer().equals(arg) && a instanceof CurrentAccount) {
				return (CurrentAccount) a;
			}
		}
		return null;
	}

	public String createAccount(String arg1, double arg2, double arg3) {
		if (searchAccount(arg1) == null) {
			CurrentAccount account = new CurrentAccount(arg1, arg2, arg3);
			theAccounts.add(account.otherAccount);
			theAccounts.add(account);
			return "Current and savings account created for" + arg1;
		}
		return "Account(s) already existed for " + arg1;
	}

	public String createAccount(String arg1, double arg2) {
		if (searchAccount(arg1) == null) {
			CurrentAccount account = new CurrentAccount(arg1, arg2);
			theAccounts.add(account);
			return "Current account created for" + arg1;
		}
		return "Account(s) already existed for " + arg1;
	}

	public void currentToSavings(String arg1, double arg2) {
		searchAccount(arg1).savings(arg2);
	}

	public String checkPerson(String arg) {
		String result = "";
		result += searchAccount(arg).getCustomer() + "\n";

		if (searchAccount(arg) instanceof CurrentAccount) {
			result += searchAccount(arg).toString();
			if (searchAccount(arg).otherAccount instanceof SavingsAccount) {
				result += searchAccount(arg).otherAccount.toString();
			}
		} else {
			result = "Person does not exist";
		}

		return result;
	}

	public String toString() {
		String result = "Bank: " + NAME + "\n" + "Accounts: " + theAccounts.size() + "\n";
		double currentMoney = 0.0;
		double savingsMoney = 0.0;
		for (int i = 0; i < theAccounts.size(); i++) {
			if (theAccounts.get(i) instanceof CurrentAccount) {
				currentMoney += theAccounts.get(i).getBalance();
			} else {
				savingsMoney += theAccounts.get(i).getBalance();
			}
		}
		result += "Money in current / savings accounts: " + currentMoney + " / " + savingsMoney;
		return result;
	}

}