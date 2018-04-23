package lab9;
public class SavingsAccount extends BankAccount {

	private double rate;

	private int savingsNumber = 0;

	private String accountNumber;

	public SavingsAccount(String name, double initialBalance) {

		super(name, initialBalance);

		accountNumber = "";

		rate = 2.5;

	}

	public SavingsAccount(SavingsAccount oldAccount, double amount) {

		super(oldAccount, amount);

		savingsNumber += 1;

	}

	public void postInterest() {

		rate = (rate / 100) / 12;

		setBalance((getBalance() * rate) + getBalance());

	}

	public String getAccountNumber() {

		savingsNumber += 1;

		accountNumber = super.getAccountNumber() + "-" + savingsNumber;

		return accountNumber;

	}

	public class CheckingAccount extends BankAccount {

		private static final double FEE = 0.15;

		public CheckingAccount(String name, double initialAmount) {

			super(name, initialAmount);

			setAccountNumber(getAccountNumber() + "-10");

		}

		public boolean withdraw(double amount) {

			amount += FEE;

			return super.withdraw(amount);

		}
	}
}