import java.util.*;

public class ATM {
	
	private HashMap<Integer, Double> accounts;

	public ATM () {
		accounts = new HashMap<Integer, Double>();
		
	}
	
	public void openAccount(int accountNumber) {
		accounts.put(accountNumber, 0.0);
	}
	
	public void openAccount(int accountNumber, double initialAmount) {
		accounts.put(accountNumber, initialAmount);
	}
	
	public void closeAccount(int accountNumber) {
		accounts.remove(accountNumber);
	}
	
	public double checkBalance(int accountNumber) {
		if (accounts.get(accountNumber) != null) {
			return accounts.get(accountNumber);
		}
		else {
			return 0;
		}
	}
	
	public boolean withdrawMoney(int accountNumber, double withdrawAmount) {
		double balance;
		if (accounts.get(accountNumber) != null) {
			balance = accounts.get(accountNumber);
		}
		else {
			return false;
		}
		balance =- withdrawAmount;
		if (withdrawAmount >= 0) {
			accounts.replace(accountNumber, balance);
			return true;
		}
		return false;
	}
	
}
