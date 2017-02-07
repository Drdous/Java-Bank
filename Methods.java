package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.FileWork;
import main.Acc;

public class Methods {
	public static List<Acc> accounts;

	public static void admin() throws IOException {
		String adminPassword = "admin123";

		// List<Acc> accounts = new ArrayList<Acc>();

		System.out.println("");
		System.out.println("Administratorska cast");
		System.out.println("");

		String login = User.input("Zadejte heslo: ");

		if (login.equals(adminPassword)) {
			adminController();

		} else {
			System.out.println("Spatne heslo.");
			MainApp.run();
		}

	}

	public static void adminController() throws NumberFormatException, IOException {

		List<String> menu = new ArrayList<String>();
		menu.add("Sprava uzivatelu");
		menu.add("Pridat uzivatele");
		menu.add("Vyhledat uzivatele podle id");
		menu.add("Zpet do hlavniho menu");

		int i = 1;
		for (String m : menu) {
			System.out.println(i + ") " + m);
			i += 1;
		}

		switch (Integer.parseInt(User.input("Zvolte moznost: "))) {
		case 1:
			changeUser();
			break;
		case 2:
			addUser();
			break;
		case 3:
			String searchByID = User.input("Zadejte ID klienta: ");
			List<Acc> accounts3 = new ArrayList<Acc>();
			FileWork.dataImport(accounts3);
			for (Acc ac3 : accounts3) {
				if (Integer.parseInt(searchByID) == ac3.getClientID()) {
					System.out.println(ac3.toString());
				}
			}
			break;
		case 4:
			MainApp.run();
		}
	}

	public static void user() throws IOException {
		System.out.println("Zadejte prihlasovaci udaje");
		String accNumber = User.input("Cislo uctu: ");
		String pin = User.input("PIN: ");

		List<Acc> accounts = new ArrayList<Acc>();
		FileWork.dataImport(accounts);

		for (Acc a : accounts) {
			if ((Long.parseLong(accNumber) == a.getAccountNumber()) && (Integer.parseInt(pin)) == a.getPin()) {
				System.out.println("Vitejte " + a.getName() + " " + a.getSurname());
				System.out.println("Vas zustatek je: " + a.getMoney() + " Kc");
				List<String> menu = new ArrayList<String>();
				menu.add("Vlozit penize");
				menu.add("Poslat penize");

				int i = 1;
				for (String m : menu) {
					System.out.println(i + ") " + m);
					i += 1;
				}

				switch (Integer.parseInt(User.input("Zvolte moznost: "))) {
				case 1:
					String castka = User.input("Zadejte castku: ");
					a.setMoney(a.getMoney() + Integer.parseInt(castka));
					System.out.println("Zustatek po vkladu " + "(" + castka + "): " + a.getMoney() + " Kc");
					saveData(accounts);
					break;
				case 2:
					String cisloUctu = User.input("Zadejte cislo uctu prijemce: ");
					// if (Long.parseLong(cisloUctu) != a.getAccountNumber()) {
					// System.out.println("Zadane cislo uctu " + cisloUctu + "
					// nepatri zadnemu prijemci.");
					// return;
					// }
					
					String castkaPrevod = User.input("Zadejte castku: ");
					String VS = User.input("Zadejte Variabilni Symbol: ");

					DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
					Date actualDate = new Date();
					// System.out.println(df);
					// System.out.println(actualDate);
					// System.out.println(df.format(actualDate));
					String date = df.format(actualDate);

					for (Acc ac : accounts) {
						if (ac.getAccountNumber() == Long.parseLong(cisloUctu)) {
							ac.setMoney(ac.getMoney() + Double.parseDouble(castkaPrevod));
							a.setMoney(a.getMoney() - Double.parseDouble(castkaPrevod));
							System.out.println(
									"Poslal jste " + castkaPrevod + " Kc" + " ve prospech uctu " + ac.getAccountNumber()
											+ " vedeny na jmeno: " + ac.getName() + " " + ac.getSurname()
											+ ". VS platby: " + VS + ". Vas zustatek cini: " + a.getMoney() + " Kc");

							File soubor = new File("log.csv");
							FileWriter writer = null;
							try {
								soubor.createNewFile();
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								writer = new FileWriter(soubor, true);
								// writer.write("OD klienta(jmeno,cislo
								// uctu),PRO klienta(jmeno,cislo
								// uctu),castka,VS,datum a cas" + "\n");
								writer.write(a.getName() + " " + a.getSurname() + "," + a.getAccountNumber() + ","
										+ ac.getName() + " " + ac.getSurname() + "," + ac.getAccountNumber() + ","
										+ castkaPrevod + "," + VS + "," + date + "\n");

							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								writer.close();
							}
						}

					}
					saveData(accounts);
					break;

				}

			} // else {
				// System.out.println("Zadane cislo uctu a pin se neshoduji.");
				// return;
				// }
		}
	}

	public static void addUser() throws IOException {

		List<Integer> numbers = new ArrayList<Integer>();
		List<Acc> accounts2 = new ArrayList<Acc>();
		FileWork.dataImport(accounts2);
		for (Acc a : accounts2) {
			numbers.add(a.getClientID());
		}

		int id = numbers.size() + 1;
		String name = User.input("Zadejte jmeno: ");
		String surname = User.input("Zadejte prijmeni: ");
		String accNumber = User.input("Zadejte cislo uctu: ");
		String pin = User.input("Zadejte PIN: ");
		String money = User.input("Zadejte pocatecni vklad: ");

		// if (pin.equals("1111")) {
		// System.out.println("NE");
		// id = 0; name = null; surname = null; accNumber = null; pin = null;
		// money = null;
		// addUser();
		// }

		List<Acc> accountss = new ArrayList<Acc>();
		FileWork.dataImport(accountss);

		Acc a = new Acc(id, name, surname, Long.parseLong(accNumber), Integer.parseInt(pin), Double.parseDouble(money));
		accountss.add(a);

		System.out.println(a.toString());
		saveData(accountss);
		adminController();
	}

	public static void changeUser() throws IOException {
		FileWork.importData();
		System.out.println("");

		List<Acc> accounts = new ArrayList<Acc>();
		FileWork.dataImport(accounts);

		String idc = User.input("Zadejte ID klienta pro upravu: ");
		int idci = Integer.parseInt(idc);
		for (Acc a : accounts) {
			if (idci == a.getClientID()) {
				System.out.println(a.getName() + " " + a.getSurname());
			}
		}
		saveData(accounts);
	}

	public static void saveData(List<Acc> accounts) throws IOException {
		// TODO: ulozeni dat do souboru
		File soubor = new File("ClientDatabase.csv");
		FileWriter writer = null;
		try {
			soubor.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer = new FileWriter(soubor);
			writer.write("client_ID,name,surname,account_number,PIN,money" + "\n");
			for (Acc a : accounts) {
				writer.write(a.toCSV());

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}
