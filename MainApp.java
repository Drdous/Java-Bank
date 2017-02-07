package main;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import main.User;
import main.Methods;

public class MainApp {
    public FileWork controll;
    public static Methods control;

	
	public MainApp() throws IOException {
        controll = new FileWork();
        control = new Methods();
    }
	
	public static void main(String[] args) throws IOException {
		// FileWork.startImportData();
		MainApp instance = new MainApp();
		instance.run();
		
		
	}
	
	public static void run() throws NumberFormatException, IOException {
		System.out.println("");
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Administratorska cast");
		menu.add("Uzivatelska cast");
		menu.add("Ukoncit program");
		
		int i = 1;
		for (String m : menu) {
			
			System.out.println(i + ") " + m);
			i += 1;
		}
				
		switch(Integer.parseInt(User.input("Vyberte moznost: "))) {
		case 1:
			control.admin();
			break;
		case 2:
			control.user();
			break;
		case 3: 
			return;
		}
		
	}
	
	

}
