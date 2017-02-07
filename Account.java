package main;

import java.awt.List;
import java.util.ArrayList;

public class Account {
	private ArrayList<Account> accounts = new ArrayList<>();
	
	public Account(String client_ID, String name, String surname, String account_number, String PIN, String money) {
		super();
		this.accounts = new ArrayList<>();
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
