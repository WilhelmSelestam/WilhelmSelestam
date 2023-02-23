package lab3;

public class CurrentAccount extends Account {

	public CurrentAccount(String arg1, double arg2) {
		super(arg1, arg2);
		otherAccount = null;
	}
	
	public CurrentAccount(String arg1, double arg2, double arg3) {
		super(arg1, arg2, arg3);
	}

	public void savings(double arg) {
		String result = "";
		if (otherAccount != null) {

			if (this instanceof CurrentAccount) {
				if (arg > 0) {
					if (getBalance() >= arg) {
						setBalance(getBalance() - arg);
						otherAccount.setBalance(arg + otherAccount.getBalance());
						result = "To savings account: " + (arg);
						transactions.add(result);
						result = "From current account: " + (arg);
						otherAccount.transactions.add(result);
					} else {
						otherAccount.setBalance(getBalance() + otherAccount.getBalance());
						result = "To savings account: " + getBalance();
						transactions.add(result);
						result = "From current account: " + getBalance();
						otherAccount.transactions.add(result);
						setBalance(0);
					}
				} else if (arg <= 0) {
					arg = Math.abs(arg);
					if (otherAccount.getBalance() >= arg) {
						setBalance(arg + getBalance());
						result = "From savings account: " + (otherAccount.getBalance() - arg);
						transactions.add(result);
						result = "To current account: " + (otherAccount.getBalance() - arg);
						otherAccount.transactions.add(result);
						otherAccount.setBalance(otherAccount.getBalance() - arg);
					} else {
						double a = otherAccount.getBalance();
						setBalance(getBalance() + a);
						result = "From savings account: " + a;
						transactions.add(result);
						otherAccount.setBalance(0);
						result = "To current account: " + a;
						otherAccount.transactions.add(result);
					}
				}
			}
		}
	}
}
