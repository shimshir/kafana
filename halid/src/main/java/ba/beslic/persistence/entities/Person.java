package ba.beslic.persistence.entities;

import java.util.Date;

/**
 * Author: Admir Memić
 * Date:   16.08.2015
 */
public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private Date birthDate;

	public Person()
	{
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
