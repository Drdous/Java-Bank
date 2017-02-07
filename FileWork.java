package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Account;
import main.Acc;
import main.MainApp;
import main.User;
import main.Methods;

public class FileWork {
	
	
	public static List<Acc> importData() throws IOException {
		List<Acc> accounts = new ArrayList<>();
		
		BufferedReader br = null;
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader("ClientDatabase.csv"));
			while ((line = br.readLine()) != null) {
				if (line.equals("client_ID,name,surname,account_number,PIN,money")) {
					continue;
				}
				
				String[] data = line.split(",");
				accounts.add(new Acc(Integer.parseInt(data[0]), data[1], data[2], Long.parseLong(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5])));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("V databazi je " + accounts.size() + " klientu.");
		System.out.println("");
		
		for (Acc a : accounts) {
			System.out.println("Klientske cislo: " + a.getClientID() + ", " + a.getName() + " " + a.getSurname() + ", cislo uctu: " + a.getAccountNumber() + ", zustatek: " + a.getMoney() + ", PIN: " + a.getPin());
		}
		return accounts;
	}
	public static List<Acc> startImportData() throws IOException {
		List<Acc> accounts = new ArrayList<>();
		
		BufferedReader br = null;
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader("ClientDatabase.csv"));
			while ((line = br.readLine()) != null) {
				if (line.equals("client_ID,name,surname,account_number,PIN,money")) {
					continue;
				}
				
				String[] data = line.split(",");
				accounts.add(new Acc(Integer.parseInt(data[0]), data[1], data[2], Long.parseLong(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5])));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	
	public static List<Acc> dataImport(List<Acc> accounts) throws IOException {
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader("ClientDatabase.csv"));
			while ((line = br.readLine()) != null) {
				if (line.equals("client_ID,name,surname,account_number,PIN,money")) {
					continue;}
				String[] data = line.split(",");
				accounts.add(new Acc(Integer.parseInt(data[0]), data[1], data[2], Long.parseLong(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5])));
			}
		} catch (Exception e) {e.printStackTrace();}
		return accounts;
	}
}
