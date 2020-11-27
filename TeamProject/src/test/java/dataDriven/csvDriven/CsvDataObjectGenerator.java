package dataDriven.csvDriven;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import dataDriven.UserData;

public class CsvDataObjectGenerator {
	String file;
	List<UserData> users = new ArrayList<UserData>();
	HashMap<String, String> userValues = new HashMap<String, String>();

	public CsvDataObjectGenerator(String file) {
		this.file = file;
	}

	public CsvDataObjectGenerator makeDataObjectsFromCsv() throws Exception {			
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<String> headers = new ArrayList<String>();
			List<String[]> userData = new ArrayList<String[]>();
			int iterator = 0;

			while((nextRecord = csvReader.readNext()) != null) {
				if(iterator == 0) {
					headers.addAll(Arrays.asList(nextRecord));
					iterator++;
				}
				else {
					userData.add(nextRecord);}
			}
			csvReader.close();


			for(String[] user : userData) {
				userValues = new HashMap<String, String>();
				for (int j = 0; j<headers.size() && j<user.length; j++) {
					userValues.put(headers.get(j), user[j]);
				}
				users.add(new UserData(userValues));
			}

			return this;

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		throw new Exception();
	}

	public List<UserData> getUsers() {
		return users;
	}

}
