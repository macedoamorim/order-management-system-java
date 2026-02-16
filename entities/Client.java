package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Client {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date birthDate;
	
	public Client(String name, String email, Date clientBirthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = clientBirthDate;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return getName() + " (" + sdf.format(getBirthDate()) + ") - " + getEmail();
	}
	
}
