package ba.beslic.presentation.data.user;

import ba.beslic.presentation.data.PresentationData;

/**
 * Author:  Admir Memic
 * Date:    19.10.15
 * E-Mail:  admir.memic@dmc.de
 */
public class CredentialsData implements PresentationData {
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
