package ba.beslic.models.presentation.user;

import ba.beslic.models.presentation.IdentifiableData;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class UserSessionData extends IdentifiableData {
	private UserData user;
	private AccountData account;
	private String uuid;
	private boolean active;

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public AccountData getAccount() {
		return account;
	}

	public void setAccount(AccountData account) {
		this.account = account;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
