package ba.beslic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
@MappedSuperclass
public class PersonEntity extends IdentifiableEntity {
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

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
}
