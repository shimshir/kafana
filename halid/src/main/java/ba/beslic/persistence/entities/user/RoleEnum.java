package ba.beslic.persistence.entities.user;

/**
 * Author:  Admir Memic
 * Date:    19.10.15
 * E-Mail:  admir.memic@dmc.de
 */
public enum RoleEnum {
	ADMIN("admin"),
	STUDENT("student"),
	STAFF("staff"),
	GUEST("guest");

	private String value;

	private RoleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
