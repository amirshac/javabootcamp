package GeneratorUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class GeneratorUtil {
	private static final String FILENAMECOUNTRY = "generator_files/generator_countries_input.txt";
	private static final String FILENAMENAMES = "generator_files/generator_names_input.txt";
	private static final String FILENAMESTREETS = "generator_files/generator_street_names_input.txt";
	
	protected static Random random;
	protected static ArrayList<String> namesList;
	protected static ArrayList<String> countryList;
	protected static ArrayList<String> streetList;
	
	static {
		random = new Random();
		namesList = new ArrayList<String>();
		countryList = new ArrayList<String>();
		streetList = new ArrayList<String>();
	}
	
	private static void populateListFromFile(ArrayList<String> list, String fileName) {
		String string = null;
		
		try(
				FileReader file = new FileReader(fileName);
				BufferedReader reader = new BufferedReader(file)){
			
			do {
				string = reader.readLine();
				if (string!=null) list.add(string);
			}while (string!=null);
						
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public static void init() {
		loadLists();
	}
	
	private static void loadLists() {
		if (namesList.isEmpty()) populateListFromFile(namesList, FILENAMENAMES);
		if (streetList.isEmpty()) populateListFromFile(streetList, FILENAMESTREETS);
		if (countryList.isEmpty()) populateListFromFile(countryList, FILENAMECOUNTRY);
	}
	
	
	private static String getRandomStringFromList(ArrayList<String> list) {
		String string = null;
		int index = random.nextInt(0, list.size());
		string = new String(list.get(index));
		return string;
	}
	
	public static String randomName() {
		return getRandomStringFromList(namesList);
	}
	
	public static String randomCountry() {
		return getRandomStringFromList(countryList);
	}
	
	public static String randomStreet() {
		return getRandomStringFromList(streetList);
	}
}
