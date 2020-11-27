package dataDriven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class UserData{
	String firstName;
	String lastName;
	String DOB;
	String email;
	String houseNumber;
	String street;
	String city;
	String state;
	String postalCode;
	String mobile;
	String gender;
	String[] subjects;
	String hobby;


	public UserData(HashMap<String,String> data) throws ParseException{		
		this.firstName = data.get("lastFirst").contains(",") ? data.get("lastFirst").split(",")[1] : null;
		this.lastName = data.get("lastFirst").split(",")[0];
		this.DOB = formatDate(data.get("dob"));
		this.email = data.get("email");
		this.houseNumber = data.get("houseNumber");
		this.street = data.get("street");
		this.city = data.get("city");
		this.state = data.get("state");
		this.postalCode = data.get("postalCode");
		this.mobile = data.get("mobile").replaceAll("-", "");
		this.gender = data.get("gender");
		this.subjects = this.subjects != null ? data.get("subjects").split(";") : new String[] {""};
		this.hobby = data.get("hobby");
	}

	public String formatDate(String date) throws ParseException {
		String formattedDate;
		if (date.length() == 10) {
			formattedDate = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("MM/dd/yyyy").parse(date));
		}
		else {
			formattedDate = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("M/d/yyyy").parse(date));
		}
		return formattedDate;
	}

}
