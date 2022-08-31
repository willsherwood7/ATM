import java.util.*;

public class ATM {
	
	public static void main (String [] args) {
		ATM testy1 = new ATM();
		
		testy1.openAccount(1);
		System.out.println(testy1.checkBalance(1));
		System.out.println("Should be 0.0");
		testy1.closeAccount(1);
		System.out.println(testy1.withdrawMoney(1, 238.3));
		System.out.println("Should be false");
	}
	
	private HashMap<Integer, Double> accounts;

	public ATM () {
		accounts = new HashMap<Integer, Double>();
		
	}
	
	public void openAccount(int accountNumber) {
		accounts.put(accountNumber, 0.0);
	}
	
	public void openAccount(int accountNumber, double initialAmount) {
		double roundedAmount = Math.round(initialAmount * 100.0) / 100.0;
		accounts.put(accountNumber, roundedAmount);
	}
	
	public void closeAccount(int accountNumber) {
		if (accounts.get(accountNumber) != null && (accounts.get(accountNumber) == 0)) {
			accounts.remove(accountNumber);
		}
	}
	
	public double checkBalance(int accountNumber) {
		if (accounts.get(accountNumber) != null) {
			return accounts.get(accountNumber);
		}
		else {
			return 0;
		}
	}
	
	public boolean depositMoney(int accountNumber, double depositAmount) {
		if (depositAmount < 0) {
			return false;
		}
		if (accounts.get(accountNumber) == null) {
			return false;
		}
		double newValue = accounts.get(accountNumber) + depositAmount;
		newValue = Math.round(newValue * 100.0) / 100.0;
		accounts.replace(accountNumber, newValue);
		return true;
	}
	
	public boolean withdrawMoney(int accountNumber, double withdrawAmount) {
		if (withdrawAmount < 0) {
			return false;
		}
		if (accounts.get(accountNumber) == null) {
			return false;
		}
		double balance = accounts.get(accountNumber);
		balance = balance - withdrawAmount;
		balance = Math.round(balance * 100.0) / 100.0;
		if (balance >= 0) {
			accounts.replace(accountNumber, balance);
			return true;
		}
		return false;
	}
}
