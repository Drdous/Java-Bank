package main;

import java.util.ArrayList;
import java.util.List;

public class Acc {
	public int clientID;
	public String name;
	public String surname;
	public long accountNumber;
	public int pin;
	public double money;
	public List<Acc> accounts;

	
	public Acc(int clientID, String name, String surname, long accountNumber, int pin, double money) {
		super();
		this.clientID = clientID;
		this.name = name;
		this.surname = surname;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.money = money;
		this.accounts = new ArrayList<>();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Klientske cislo: " + this.clientID + ", jmeno: " + this.name + " " + this.surname + ", cislo uctu: " + 
		this.accountNumber + ", PIN: " + this.pin + ", zustatek: " + this.money + "\n";
	}

	public List<Acc> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Acc> accounts) {
		this.accounts = accounts;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public String toCSV() {
		return this.clientID + "," + this.name + "," + this.surname + "," + 
				this.accountNumber + "," + this.pin + "," + this.money + "\n";
	}
	
}
