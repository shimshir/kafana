package ba.beslic.models.presentation.user;

import ba.beslic.models.presentation.IdentifiableData;

/**
 * Author:  Admir Memic
 * Date:    19.10.15
 * E-Mail:  admir.memic@dmc.de
 */
public class CredentialsData extends IdentifiableData {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
